package MQTT;

import org.eclipse.paho.client.mqttv3.*;

import java.util.Timer;
import java.util.TimerTask;

public class TempSensor {
    public static void main(String[] args) {
        MqttClient client;
        String broker = "tcp://localhost:1883";
        String clientId = MqttClient.generateClientId();
        String topic = "home/sensors/temp";
        int qos = 2;

        //brew services start mosquitto

        try {
            client = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            //connOpts.setUserName(username); // optional
            //connOpts.setPassword(password.toCharArray()); // optional
            //connOpts.setWill("this/is/a/topic","will message".getBytes(),1,false);  // optional
            //connOpts.setKeepAliveInterval(60);  // optional

            // Connect the client
            System.out.println(clientId + " Connecting Broker " + broker);
            client.connect(connOpts);
            System.out.println(clientId + " Connected");

            Timer t = new Timer();
            t.scheduleAtFixedRate(
                    new TimerTask(){
                        public void run(){
                            try{
                                String payload = String.valueOf(18 + (Math.random() * 4)); // create a random number between 18 and 22
                                MqttMessage message = new MqttMessage(payload.getBytes());

                                // Set the QoS on the Message
                                message.setQos(qos);
                                System.out.println(clientId + " Publishing message: " + payload + " ...");
                                client.publish(topic, message);
                                System.out.println(clientId + " Message published");
                            } catch (MqttException me) {
                                System.out.println("reason " + me.getReasonCode());
                                System.out.println("msg " + me.getMessage());
                                System.out.println("loc " + me.getLocalizedMessage());
                                System.out.println("cause " + me.getCause());
                                System.out.println("exception " + me);
                                me.printStackTrace();
                            }
                        }
                    }, 0, 5000
            );
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
