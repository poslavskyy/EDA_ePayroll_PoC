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
import ca.gc.cra.rcsc.eda_epayroll_poc.*;
import javax.ws.rs.core.Response; 

@Path("/sinValidation")
public class SinResource {

    @Inject
    SinService sinService;

   
    @Path("/service-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tryMeServiceMethodValidation(String obj) {
        try{
            JSONObject json = new JSONObject(obj);
            int sin = json.getInt("employee_sin"); 
            boolean isSinVlaid = sinService.isValid(sin);
            if(isSinVlaid){
                json.put("response_code", 200);
                return Response.status(200).entity(json.toString()).build();
            }
            else{
                json.put("errorDescription","Received data contains a sin number with digits more than or less than 9");
                json.put("response_code",101);
                return Response.status(500).entity(json.toString()).build();
            }
           
        } catch (JSONException e){
            JSONObject notJson = new JSONObject();
            notJson.put("errorDescription","Received data is not json parseable");
            notJson.put("response_code",400);
            // notJson.put("data",obj);
            return Response.status(400).entity(notJson.toString()).build();
        }

}
}