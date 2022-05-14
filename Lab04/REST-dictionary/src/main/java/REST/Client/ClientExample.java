package REST.Client;

import REST.beans.Word;
import REST.beans.Words;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientExample {

    public static void main(String args[]){
        Client client = Client.create();
        String serverAddress = "http://localhost:1337";
        ClientResponse clientResponse = null;

        // POST EXAMPLE
        String postPath = "/dictionary/add";
        Word word = new Word("home","the place where you live");
        clientResponse = postRequest(client,serverAddress+postPath, word);
        System.out.println(clientResponse.toString());

        String postPathDupl = "/dictionary/add";
        Word wordDupl = new Word("home","the place where you want to live");
        clientResponse = postRequest(client,serverAddress+postPathDupl, wordDupl);
        System.out.println(clientResponse.toString());


        String postPathDuplic = "/dictionary/add";
        Word wordDuplic = new Word("car","the thing you use to move");
        clientResponse = postRequest(client,serverAddress+postPathDuplic, wordDuplic);
        System.out.println(clientResponse.toString());

        //GET REQUEST #1
        String getPath = "/dictionary";
        clientResponse = getRequest(client,serverAddress+getPath);
        System.out.println(clientResponse.toString());
        Words words = clientResponse.getEntity(Words.class);
        System.out.println("Word List");
        for (Word u : words.getWordslist()){
            System.out.println("Word: " + u.getWord() + " - Definition: " + u.getDefinition());
        }

        //GET REQUEST #2
        String getWordPath = "/dictionary/get/home";
        clientResponse = getRequest(client,serverAddress+getWordPath);
        System.out.println(clientResponse.toString());
        Word wordResponse = clientResponse.getEntity(Word.class);
        System.out.println("Word: " + wordResponse.getWord() + " - Definition: " + wordResponse.getDefinition());


        //MODIFY REQUEST
        String modifyPath = "/dictionary/modify/home";
        clientResponse = modifyRequest(client,serverAddress+modifyPath, "the new place where you want to live");
        System.out.println(clientResponse.toString());
        Word wordResponseModified = clientResponse.getEntity(Word.class);
        System.out.println("Word: " + wordResponseModified.getWord() + " - Definition: " + wordResponseModified.getDefinition());


        //DELETE REQUEST
        String deletePath = "/dictionary/delete/car";
        clientResponse = deleteRequest(client,serverAddress+deletePath);
        System.out.println(clientResponse.toString());


    }

    public static ClientResponse postRequest(Client client, String url, Word u){
        WebResource webResource = client.resource(url);
        String input = new Gson().toJson(u);
        try {
            return webResource.type("application/json").post(ClientResponse.class, input);
        } catch (ClientHandlerException e) {
            System.out.println("Server non disponibile");
            return null;
        }
    }

    public static ClientResponse getRequest(Client client, String url){
        WebResource webResource = client.resource(url);
        try {
            return webResource.type("application/json").get(ClientResponse.class);
        } catch (ClientHandlerException e) {
            System.out.println("Server non disponibile");
            return null;
        }
    }

    public static ClientResponse modifyRequest(Client client, String url, String newDescription){
        WebResource webResource = client.resource(url);
        try {
            return webResource.type("application/json").post(ClientResponse.class, newDescription);
        } catch (ClientHandlerException e) {
            System.out.println("Server non disponibile");
            return null;
        }
    }

    public static ClientResponse deleteRequest(Client client, String url){
        WebResource webResource = client.resource(url);
        try {
            return webResource.type("application/json").delete(ClientResponse.class);
        } catch (ClientHandlerException e) {
            System.out.println("Server non disponibile");
            return null;
        }
    }
}
