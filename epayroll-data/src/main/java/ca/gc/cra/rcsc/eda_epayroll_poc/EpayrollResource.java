package ca.gc.cra.rcsc.eda_epayroll_poc;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import ca.gc.cra.rcsc.eda_epayroll_poc.model.EpayrollEntity;
import ca.gc.cra.rcsc.eda_epayroll_poc.model.Epayroll;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/epayroll")
public class EpayrollResource {

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @Inject
    @ConfigProperty(name = "myapp.schema.create", defaultValue = "true") 
    boolean schemaCreate;


    @PostConstruct
    void config() {
        if (schemaCreate) {
            initdb();
        }
    }

    // public EpayrollResource(PgPool client) {
    //     this.client = client;
    // }
    private void initdb() {
        client.query("DROP TABLE IF EXISTS epayrolls").execute()
            .flatMap(r -> client.query("CREATE TABLE epayrolls (id SERIAL PRIMARY KEY, bn VARCHAR(255), employer_paydac VARCHAR(255), employer_name VARCHAR(255), pay_start LocalDate ,pay_end LocalDate ,employee_status VARCHAR(255),employee_name VARCHAR(255),employee_sin INT ,employee_id VARCHAR(255),gross_pay Numeric, tax_deducted Numeric,cpp_contrib Numeric,cpp_pension_earn Numeric,ei_contrib Numeric,ei_insur_earnings Numeric)").execute())
            .flatMap(r -> client.query("INSERT INTO epayrolls ( bn, employer_paydac,  employer_name, pay_start,  pay_end,  employee_status, employee_name, employee_sin, employee_id, gross_pay, tax_deducted, cpp_contrib, cpp_pension_earn, ei_contrib, ei_insur_earnings ) VALUES ('123456789RC0001','123456789RP0002','CRA','2020-10-24','2021-11-24','hired','Sam Doe',123466789,'65423',1500.00,150.00,75.00,33.00,17.00,28.00)"
            ).execute())
            .await().indefinitely();
    }

    // @Inject
    // EntityManager entityManager;

    //private Set<Epayroll> epayrolls = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    // public EpayrollResource() {
    //     epayrolls.add(new Epayroll(1, "12345678" ,"john doe",LocalDate.of(2014, 9, 12),LocalDate.of(2015, 9, 12),"fired","mike",123456789,"abc123",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
    //     epayrolls.add(new Epayroll(2, "23456789" ,"mike doe",LocalDate.of(2014, 10, 11),LocalDate.of(2020, 9, 21),"fired","john",123456799,"adfd123",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
    //     epayrolls.add(new Epayroll(3, "34567891" ,"ashish doe",LocalDate.of(2019, 9, 8),LocalDate.of(2021, 9, 2),"active","doe",153456789,"abc134",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
    //     epayrolls.add(new Epayroll(4, "45678912" ,"doe",LocalDate.of(2010, 9, 1),LocalDate.of(2018, 9, 4),"fired","john",125456789,"abth3",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
    //     epayrolls.add(new Epayroll(5, "56789123" ,"john",LocalDate.of(2008, 2, 2),LocalDate.of(2014, 2, 1),"active","john doe",173456789,"ab3453",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
    // }


    // @GET
    // public Set<Epayroll> list() {
    //     return epayrolls;
    // }

    // @GET
    // @Path("/processed")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String storedList() {
    //     List<EpayrollEntity> stored_epayrolls = entityManager.createNamedQuery("Epayrolls.findAll", EpayrollEntity.class).getResultList();
    //     return stored_epayrolls.toString();
    // }
    @GET
    @Path("/processed")
    // @Produces(MediaType.APPLICATION_JSON)
    public Multi<Epayroll> storedList() {
        System.out.println(Epayroll.findAll(client));
        // List<EpayrollEntity> stored_epayrolls = entityManager.createNamedQuery("Epayrolls.findAll", EpayrollEntity.class).getResultList();
        return Epayroll.findAll(client);
    }

    

    // @GET
    // @Path("hello")
    // @Produces(MediaType.TEXT_PLAIN)
    // public String hello() {
    //     return "Hello RESTEasy";
    // }


}