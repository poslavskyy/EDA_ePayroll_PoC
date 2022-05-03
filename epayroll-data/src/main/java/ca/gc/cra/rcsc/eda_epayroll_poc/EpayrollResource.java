package ca.gc.cra.rcsc.eda_epayroll_poc;


import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;
import ca.gc.cra.rcsc.eda_epayroll_poc.model.EpayrollEntity;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/epayroll")
public class EpayrollResource {
    @Inject
    EntityManager entityManager;
    @GET
    @Path("/processed")
    @Produces(MediaType.APPLICATION_JSON)
    public String storedList() {
        List<EpayrollEntity> stored_epayrolls = entityManager.createNamedQuery("Epayrolls.findAll", EpayrollEntity.class).getResultList();
        return stored_epayrolls.toString();
    }
    
}