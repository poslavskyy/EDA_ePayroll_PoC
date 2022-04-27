package ca.gc.cra.rcsc.eda_epayroll_poc;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Date;
import java.time.LocalDate;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.gc.cra.rcsc.eda_epayroll_poc.model.Errors;

import java.text.*;

@Path("/errors")
public class ErrorResource {
	
	private Set<Errors> errors = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
	
	public ErrorResource(){
		
		errors.add(new Errors(100, "Network failure", 123, 123456, "Acme Inc", "Regular", "01/01/2021", "01/13/2021", 123456789, "Jane Donalds", 123, "N/A", 20000, 1000, 100, 20000, 100, 20000));
		errors.add(new Errors(101, "Failed Validation", 231, 123456, "Books Inc", "Regular", "01/01/2021", "01/13/2021", 852697032, "Joe Donalds", 123, "N/A", 20000, 1000, 100, 20000, 100, 20000));
		errors.add(new Errors(102, "403 Status Code", 581, 951758, "Cards Inc", "Regular", "01/01/2021", "01/13/2021", 987154623, "Mike Myers", 123, "N/A", 20000, 1000, 100, 20000, 100, 20000));
		errors.add(new Errors(103, "600 Status Code", 600, 541874, "Horses Inc", "N/A", "01/01/2021", "01/13/2021", 852963741, "Stuart Andrews", 123, "N/A", 20000, 1000, 100, 20000, 100, 20000));
	}
	
	@GET
	public Set<Errors> list(){
		return errors;
	}
}
