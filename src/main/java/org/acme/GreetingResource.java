package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import java.util.stream.Stream;
import org.eclipse.microprofile.reactive.messaging.*;


@Path("/hello")
public class GreetingResource {

    @Inject
    @Channel("words-out-too")
    Emitter<String> emitter;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        emitter.send("hello world");
        return "Hello from RESTEasy Reactive";
    }
}
