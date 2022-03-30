package ca.gc.cra.rcsc.eda_epayroll_poc.consumers;

import java.util.*;
import org.json.*;  
import java.util.Set;
import java.io.IOException;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import javax.validation.Valid;
import javax.validation.Validator;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@ApplicationScoped
public class consumeIncoming {

    @ConfigProperty(name = "validators.url",defaultValue = "epayrollValidator='http://epayroll-validator-eda-epayroll-poc.apps.ocp4.omega.dce-eir.net/epayrollValidation/service-method-validation'") 
    Map<String, String> urls;

    @Inject
    Validator validator;

    @Inject
    @Channel("output-valid-data")
    Emitter<String> validEmitter;

    @Inject
    @Channel("output-error-data")
    Emitter<String> errorEmitter;
    

    public JSONObject executePost(String u,String obj){
        String u1 = u.substring(1,u.length() - 1);
        System.out.println("url is : " + u.substring(1,u.length() - 1));
        System.out.println("obj to post is : " + obj);  
        RestAssured.baseURI =u1;
        RequestSpecification request = RestAssured.given(); 

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(obj);
        Response response = request.post("/");
        // int statusCode = response.getStatusCode();
        System.out.println("Response body: " + response.body().asString());
        JSONObject responseObj = new JSONObject(response.body().asString());
        return responseObj;
    }

    @Incoming("validator-epayrolls")   
    public void validate(String obj){
    Boolean valid = true;  
    for (String u : urls.values()) { 
        JSONObject responseObj = executePost(u,obj);
        int statusCode = responseObj.getInt("response_code");
        if(statusCode!=200){ 
            responseObj.put("errorNumber",statusCode);
            responseObj.remove("response_code");
            errorEmitter.send(responseObj.toString());
            System.out.println("invalid data: "+responseObj.toString() );
            valid = false;
        }

    }
    if(valid){
        //JSONObject validObj = new JSONObject(obj);
        validEmitter.send(obj);
        System.out.println("valid data:" + obj);
    } 
    } 


}
