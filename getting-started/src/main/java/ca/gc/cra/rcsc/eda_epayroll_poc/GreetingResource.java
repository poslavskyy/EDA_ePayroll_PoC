package ca.gc.cra.rcsc.eda_epayroll_poc;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ca.gc.cra.rcsc.eda_epayroll_poc.GreetingService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.eclipse.microprofile.reactive.messaging.Incoming;
@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;
    
    @Channel("json-data")
    Emitter<String> jsonDataEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
    	System.out.println("*** greeting(" + name +") ***");
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	System.out.println("*** hello() ***");
        return "hello";
    }
    
    @POST
    @Path("/senderror")
    @Consumes(MediaType.TEXT_PLAIN)
    public String sendErrorData(String data) {
 
    	jsonDataEmitter.send(data);
    	
    	String result = "Sent:" + data;
    	System.out.println(result);
    	
    	return result;
    }

    @Incoming("getting-started")   
    public void test_consumer(String obj){
    	System.out.println("Received msg is "+ obj);
    } 
}