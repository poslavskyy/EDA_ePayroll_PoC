package ca.gc.cra.rcsc.eda_epayroll_poc;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.smallrye.mutiny.Multi;

import ca.gc.cra.rcsc.eda_epayroll_poc.model.Epayroll;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/epayroll")
public class EpayrollResource {

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;
   
    @GET
    @Path("/processed")
    // @Produces(MediaType.APPLICATION_JSON)
    public Multi<Epayroll> storedList() {
        System.out.println(Epayroll.findAll(client));
        return Epayroll.findAll(client);
    }
}