package ca.gc.cra.rcsc.eda_epayroll_poc.model;
import java.time.LocalDate;
import java.util.Date;


import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

public class Epayroll {

    private String bn;
    private String employer_paydac;
    private String employer_name; //extract from bn
    private LocalDate pay_start; // start time of pay
    private LocalDate pay_end; // end time of pay
    private String employee_status; //new hire or laid off or n-a
    private String employee_name;
    private int employee_sin;
    private String employee_id; 
    private double gross_pay;
    private double tax_deducted;
    private double cpp_contrib;
    private double cpp_pension_earn; //CPP Pensionable Earnings
    private double ei_contrib; //
    private double ei_insur_earnings; //EI Insurable Earnings



    public Epayroll() {

    }

    public Epayroll(String bn,String employer_paydac, String employer_name,LocalDate pay_start, LocalDate pay_end, String employee_status,String employee_name,int employee_sin,String employee_id,double gross_pay,double tax_deducted,double cpp_contrib,double cpp_pension_earn,double ei_contrib,double ei_insur_earnings ) {
        this.bn = bn;
        this.employer_paydac = employer_paydac;
        this.employer_name = employer_name;
        this.pay_start = pay_start;
        this.pay_end = pay_end;
        this.employee_status = employee_status;
        this.employee_name = employee_name;
        this.employee_sin = employee_sin;
        this.employee_id = employee_id;
        this.gross_pay = gross_pay;
        this.tax_deducted = tax_deducted;
        this.cpp_contrib = cpp_contrib;
        this.cpp_pension_earn = cpp_pension_earn;
        this.ei_contrib = ei_contrib;
        this.ei_insur_earnings = ei_insur_earnings;
    }

    private static Epayroll from(Row row) {
        return new Epayroll(
            row.getString("bn"),
            row.getString("employer_paydac"),
            row.getString("employer_name"),
            row.getLocalDate("pay_start"),
            row.getLocalDate("pay_end"),
            row.getString("employee_status"),
            row.getString("employee_name"),
            row.getInteger("sin"),
            row.getString("employee_id"),
            row.getDouble("gross_pay"),
            row.getDouble("tax_deducted"),
            row.getDouble("cpp_contrib"),
            row.getDouble("cpp_pension_earn"),
            row.getDouble("ei_contrib"),
            row.getDouble("ei_insur_earnings")
        );
    }
    public static Multi<Epayroll> findAll(PgPool client) {
        return client.query("SELECT * FROM epayrolls").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(Epayroll::from);
    }


    public String getBn() {
        return this.bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    public String getEmployer_paydac() {
        return this.employer_paydac;
    }

    public void setEmployer_paydac(String employer_paydac) {
        this.employer_paydac = employer_paydac;
    }

    public String getEmployer_name() {
        return this.employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public LocalDate getPay_start() {
        return this.pay_start;
    }

    public void setPay_start(LocalDate pay_start) {
        this.pay_start = pay_start;
    }

    public LocalDate getPay_end() {
        return this.pay_end;
    }

    public void setPay_end(LocalDate pay_end) {
        this.pay_end = pay_end;
    }

    public String getEmployee_status() {
        return this.employee_status;
    }

    public void setEmployee_status(String employee_status) {
        this.employee_status = employee_status;
    }

    public String getEmployee_name() {
        return this.employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_sin() {
        return this.employee_sin;
    }

    public void setEmployee_sin(int employee_sin) {
        this.employee_sin = employee_sin;
    }

    public String getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public double getGross_pay() {
        return this.gross_pay;
    }

    public void setGross_pay(double gross_pay) {
        this.gross_pay = gross_pay;
    }

    public double getTax_deducted() {
        return this.tax_deducted;
    }

    public void setTax_deducted(double tax_deducted) {
        this.tax_deducted = tax_deducted;
    }

    public double getCpp_contrib() {
        return this.cpp_contrib;
    }

    public void setCpp_contrib(double cpp_contrib) {
        this.cpp_contrib = cpp_contrib;
    }

    public double getCpp_pension_earn() {
        return this.cpp_pension_earn;
    }

    public void setCpp_pension_earn(double cpp_pension_earn) {
        this.cpp_pension_earn = cpp_pension_earn;
    }

    public double getEi_contrib() {
        return this.ei_contrib;
    }

    public void setEi_contrib(double ei_contrib) {
        this.ei_contrib = ei_contrib;
    }

    public double getEi_insur_earnings() {
        return this.ei_insur_earnings;
    }

    public void setEi_insur_earnings(double ei_insur_earnings) {
        this.ei_insur_earnings = ei_insur_earnings;
    }
    

}