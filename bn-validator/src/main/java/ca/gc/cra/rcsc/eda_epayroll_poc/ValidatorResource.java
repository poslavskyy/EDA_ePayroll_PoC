package ca.gc.cra.rcsc.eda_epayroll_poc;

import java.util.Set;
import java.util.stream.Collectors;
import org.json.*;  
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ca.gc.cra.rcsc.eda_epayroll_poc.ValidatorService;
import javax.ws.rs.core.Response; 
@Path("/bnValidation")
public class ValidatorResource {

    @Inject
    Validator validator;

    @Inject
    ValidatorService validatorService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    
    @Path("/service-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tryMeServiceMethodValidation(String obj) {
        System.out.println("Received data is " + obj);
        try{
            JSONObject json = new JSONObject(obj);
            String bn = json.getString("bn"); 
            boolean isBnValid = validatorService.isBnValid(bn);
            if(isBnValid){
                System.out.println("Inside valid bn conditon");
                json.put("response_code", 200);
                return Response.status(200).entity(json.toString()).build();
            }
            else{
                System.out.println("Inside else condition, bn is invalid");
                //json.put("data",obj);
                json.put("errorDescription","Incorrect BN number");
                json.put("response_code",400);
                return Response.status(400).entity(json.toString()).build();
            }
        } catch (JSONException e){
            JSONObject notJson = new JSONObject();
            notJson.put("errorDescription","Received data is not json parseable");
            notJson.put("response_code",400);
            notJson.put("data",obj);
            return Response.status(400).entity(notJson.toString()).build();
        }

}
}