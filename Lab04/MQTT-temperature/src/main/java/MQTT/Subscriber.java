package MQTT;

import org.eclipse.paho.client.mqttv3.*;

import java.sql.Timestamp;
import java.util.Scanner;


public class Subscriber {
    public static void main(String[] args) {
        MqttClient client;
        String broker = "tcp://localhost:1883";
        String clientId = MqttClient.generateClientId();
        String pubTopic = "home/controllers/temp";
        String subTopic = "home/sensors/temp";
        int subQos = 2;
        int pubQos = 2;

        try {
            client = new MqttClient(broker, clientId);
            final MqttConnectOptions[] connOpts = {new MqttConnectOptions()};
            connOpts[0].setCleanSession(true); // false = the broker stores all subscriptions for the client and all missed messages for the client that subscribed with a Qos level 1 or 2

            // Connect the client
            System.out.println(clientId + " Connecting Broker " + broker);
            client.connect(connOpts[0]);
            System.out.println(clientId + " Connected " + Thread.currentThread().getId());

            // Callback
            client.setCallback(new MqttCallback() {

                Double tempSum = 0.;
                int tempCounter = 0;

                public void messageArrived(String topic, MqttMessage message) {
                    // Called when a message arrives from the server that matches any subscription made by the client
                    String time = new Timestamp(System.currentTimeMillis()).toString();
                    String receivedMessage = new String(message.getPayload());
                    System.out.println(clientId +" Received a Message! - Callback - Thread PID: " + Thread.currentThread().getId() +
                            "\n\tTime:    " + time +
                            "\n\tTemperature: " + receivedMessage);
                    if (tempCounter < 4){
                        tempSum += Double.parseDouble(receivedMessage);
                        tempCounter++;
                    } else {
                        double tempAvg = tempSum/tempCounter;
                        String signal = "on";
                        if (tempAvg > 20){
                            signal = "off";
                        }
                        MqttMessage msg = new MqttMessage(signal.getBytes());
                        // Set the QoS on the Message
                        msg.setQos(pubQos);
                        System.out.println("\n========= HEATER COMMAND ==========");
                        System.out.println(clientId + " Average temperature is: " + tempAvg + " ...");
                        System.out.println(clientId + " Publishing message: " + signal + " ...");
                        System.out.println("===================================");

                        try {
                            client.publish(pubTopic, msg);
                        } catch (MqttException me ) {
                            System.out.println("reason " + me.getReasonCode());
                            System.out.println("msg " + me.getMessage());
                            System.out.println("loc " + me.getLocalizedMessage());
                            System.out.println("cause " + me.getCause());
                            System.out.println("exception " + me);
                            me.printStackTrace();
                        }
                        System.out.println(clientId + " Message published - Thread PID: " + Thread.currentThread().getId());

                        tempSum = 0.;
                        tempCounter = 0;
                    }

                    System.out.println("\n ***  Press a random key to exit *** \n");
                }

                public void connectionLost(Throwable cause) {
                    System.out.println(clientId + " Connection lost! cause:" + cause.getMessage()+ "-  Thread PID: " + Thread.currentThread().getId());
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    if (token.isComplete()) {
                        System.out.println(clientId + " Message delivered - Thread PID: " + Thread.currentThread().getId());
                    }
                }

            });

            System.out.println(clientId + " Subscribing ... - Thread PID: " + Thread.currentThread().getId());
            client.subscribe(subTopic,subQos);
            System.out.println(clientId + " Subscribed to topic : " +  subTopic);


            System.out.println("\n ***  Press a random key to exit *** \n");
            Scanner command = new Scanner(System.in);
            command.nextLine();

            client.disconnect();



        } catch (MqttException me ) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("exception " + me);
            me.printStackTrace();
        }

    }

}
