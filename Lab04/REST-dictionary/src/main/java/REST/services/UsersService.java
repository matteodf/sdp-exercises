package REST.services;


import REST.beans.Word;
import REST.beans.Words;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("dictionary")
public class UsersService {

    //returns a word list
    @GET
    @Produces({"application/json", "application/xml"})
    public Response getUsersList(){
        return Response.ok(Words.getInstance()).build();
    }

    //allows to enter a new word
    @Path("add")
    @POST
    @Consumes({"application/json", "application/xml"})
    public Response addUser(Word u){
        Word w = Words.getInstance().getByWord(u.getWord());
        if(w!=null)
            return Response.status(Response.Status.CONFLICT).entity("The word is already present").build();
        else{
            Words.getInstance().add(u);
            return Response.ok().build();
        }
    }

    //returns a given word
    @Path("get/{name}")
    @GET
    @Produces({"application/json", "application/xml"})
    public Response getByName(@PathParam("name") String name){
        Word u = Words.getInstance().getByWord(name);
        if(u!=null)
            return Response.ok(u).build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("The word was not found").build();
    }


    //allows to remove a word
    @Path("delete/{name}")
    @DELETE
    @Consumes({"application/json", "application/xml"})
    public Response removeUser(@PathParam("name") String name){
        Word u = Words.getInstance().getByWord(name);
        if(u!=null) {
            Words.getInstance().delete(u);
            return Response.ok().build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("The word was not found").build();
    }

    //allows to change the definition of a word
    @Path("modify/{name}")
    @POST
    @Produces({"application/json", "application/xml"})
    public Response modifyDefinition(@PathParam("name") String name, String definition){
        Word u = Words.getInstance().getByWord(name);
        if(u!=null){
            u.setDefinition(definition);
            return Response.ok(u).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("The word was not found").build();
    }

}