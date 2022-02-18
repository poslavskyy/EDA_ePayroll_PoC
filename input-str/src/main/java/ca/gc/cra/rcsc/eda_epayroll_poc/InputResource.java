package ca.gc.cra.rcsc.eda_epayroll_poc;
import ca.gc.cra.rcsc.eda_epayroll_poc.Epayroll;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.UUID;
import org.json.*; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.*;
import java.io.IOException;  
@Path("/input")
public class InputResource {

    @Inject
    @Channel("validate-data")
    Emitter<String> epayrollEmitter; 


    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<String> sendEpayrolls(String[] epayrolls) {
     //   ObjectMapper Obj = new ObjectMapper();
        ArrayList<String> toReturnEpayrolls = new ArrayList<String>(); 

        for (String e : epayrolls) {
            epayrollEmitter.send(e);
            toReturnEpayrolls.add(e); 
            System.out.println(e);  
      
        }
        return toReturnEpayrolls;  
    }


    @POST
    @Path("/obj")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendEpayrollsObjects(Object epayroll) {
        System.out.println("Received arraylist is  "+epayroll);

        if(epayroll instanceof ArrayList){
        ArrayList<?> epayrolls = ArrayList.class.cast(epayroll);

        epayrolls.forEach((e) ->{
                if(e instanceof String){
                    epayrollEmitter.send(e.toString());
                }else if(e instanceof LinkedHashMap<?,?>){
                    LinkedHashMap<String,?> lh = LinkedHashMap.class.cast(e);
                    System.out.println("e linked hash map is "+lh);
                    JSONObject js2 = new JSONObject();
                    lh.forEach((key, value) -> {
                        System.out.println(key + " : " + value);
                        js2.put(key.trim(),value);
                        System.out.println("Sent epayroll is  "+js2.toString());
                });
                    epayrollEmitter.send(js2.toString());

                }else{
                    System.out.println("Received data is neither ArrayList of LinkedHashMap nor string "+e);
 
                }

            });

        }
        else if(epayroll instanceof LinkedHashMap){
            LinkedHashMap<String,?> lh = LinkedHashMap.class.cast(epayroll);
            System.out.println("epayroll linked hash map is "+lh);
            JSONObject js2 = new JSONObject();
            lh.forEach((key, value) -> {
                    System.out.println(key + " : " + value);
                    js2.put(key.trim(),value);
                    System.out.println("Sent epayroll is  "+js2.toString());
                });
                epayrollEmitter.send(js2.toString());
        }
        else{
            epayrollEmitter.send(epayroll.toString());
            System.out.println("store received data into error data topic");
        }
    }

    public Map<String, ?> convertWithStream(String mapAsString) {
        String withoutCurly = mapAsString.substring(1, mapAsString.length() - 1); 
        Map<String, ?> map = Arrays.stream(withoutCurly.split(","))
          .map(entry -> entry.split("="))
          .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
        return map;
    }

}
    