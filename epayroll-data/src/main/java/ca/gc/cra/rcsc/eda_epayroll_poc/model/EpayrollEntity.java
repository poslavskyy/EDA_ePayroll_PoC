// package ca.gc.cra.rcsc.eda_epayroll_poc.model;
// import java.time.LocalDate;
// import java.util.Date;
// import java.math.BigDecimal;


// import javax.persistence.Cacheable;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.NamedQuery;
// import javax.persistence.QueryHint;
// import javax.persistence.SequenceGenerator;
// import javax.persistence.Table;

// import io.vertx.core.json.Json;

// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;

// @Entity
// @NamedQuery(name = "Epayrolls.findAll", query = "SELECT e FROM EpayrollEntity e")
// public class EpayrollEntity {
//     @Id
//     @GeneratedValue(strategy = GenerationType.SEQUENCE)
//     private int id;
//     @Column
//     private String bn;
//     @Column
//     private String employer_paydac;
//     @Column
//     private String employer_name; //extract from bn
//     @Column
//     private Date  pay_start; // start time of pay
//     @Column
//     private Date  pay_end; // end time of pay
//     @Column
//     private String employee_status; //new hire or laid off or n-a
//     @Column
//     private String employee_name;
//     @Column
//     private int employee_sin;
//     @Column
//     private String employee_id; 
//     @Column
//     private BigDecimal gross_pay;
//     @Column
//     private BigDecimal tax_deducted;
//     @Column
//     private BigDecimal cpp_contrib;
//     @Column
//     private BigDecimal cpp_pension_earn; //CPP Pensionable Earnings
//     @Column
//     private BigDecimal ei_contrib; //
//     @Column
//     private BigDecimal ei_insur_earnings; //EI Insurable Earnings



//     public EpayrollEntity() {

//     }

//     public EpayrollEntity(String bn,String employer_paydac, String employer_name,Date pay_start, Date pay_end, String employee_status,String employee_name,int employee_sin,String employee_id,BigDecimal gross_pay,BigDecimal tax_deducted,BigDecimal cpp_contrib,BigDecimal cpp_pension_earn,BigDecimal ei_contrib,BigDecimal ei_insur_earnings ) {
//         this.bn = bn;
//         this.employer_paydac = employer_paydac;
//         this.employer_name = employer_name;
//         this.pay_start = pay_start;
//         this.pay_end = pay_end;
//         this.employee_status = employee_status;
//         this.employee_name = employee_name;
//         this.employee_sin = employee_sin;
//         this.employee_id = employee_id;
//         this.gross_pay = gross_pay;
//         this.tax_deducted = tax_deducted;
//         this.cpp_contrib = cpp_contrib;
//         this.cpp_pension_earn = cpp_pension_earn;
//         this.ei_contrib = ei_contrib;
//         this.ei_insur_earnings = ei_insur_earnings;
//     }

   
//     public String getBn() {
//         return this.bn;
//     }

//     public void setBn(String bn) {
//         this.bn = bn;
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getEmployer_paydac() {
//         return this.employer_paydac;
//     }

//     public void setEmployer_paydac(String employer_paydac) {
//         this.employer_paydac = employer_paydac;
//     }

//     public String getEmployer_name() {
//         return this.employer_name;
//     }

//     public void setEmployer_name(String employer_name) {
//         this.employer_name = employer_name;
//     }

//     public Date getPay_start() {
//         return this.pay_start;
//     }

//     public void setPay_start(Date pay_start) {
//         this.pay_start = pay_start;
//     }

//     public Date getPay_end() {
//         return this.pay_end;
//     }

//     public void setPay_end(Date pay_end) {
//         this.pay_end = pay_end;
//     }

//     public String getEmployee_status() {
//         return this.employee_status;
//     }

//     public void setEmployee_status(String employee_status) {
//         this.employee_status = employee_status;
//     }

//     public String getEmployee_name() {
//         return this.employee_name;
//     }

//     public void setEmployee_name(String employee_name) {
//         this.employee_name = employee_name;
//     }

//     public int getEmployee_sin() {
//         return this.employee_sin;
//     }

//     public void setEmployee_sin(int employee_sin) {
//         this.employee_sin = employee_sin;
//     }

//     public String getEmployee_id() {
//         return this.employee_id;
//     }

//     public void setEmployee_id(String employee_id) {
//         this.employee_id = employee_id;
//     }

//     public BigDecimal getGross_pay() {
//         return this.gross_pay;
//     }

//     public void setGross_pay(BigDecimal gross_pay) {
//         this.gross_pay = gross_pay;
//     }

//     public BigDecimal getTax_deducted() {
//         return this.tax_deducted;
//     }

//     public void setTax_deducted(BigDecimal tax_deducted) {
//         this.tax_deducted = tax_deducted;
//     }

//     public BigDecimal getCpp_contrib() {
//         return this.cpp_contrib;
//     }

//     public void setCpp_contrib(BigDecimal cpp_contrib) {
//         this.cpp_contrib = cpp_contrib;
//     }

//     public BigDecimal getCpp_pension_earn() {
//         return this.cpp_pension_earn;
//     }

//     public void setCpp_pension_earn(BigDecimal cpp_pension_earn) {
//         this.cpp_pension_earn = cpp_pension_earn;
//     }

//     public BigDecimal getEi_contrib() {
//         return this.ei_contrib;
//     }

//     public void setEi_contrib(BigDecimal ei_contrib) {
//         this.ei_contrib = ei_contrib;
//     }

//     public BigDecimal getEi_insur_earnings() {
//         return this.ei_insur_earnings;
//     }

//     public void setEi_insur_earnings(BigDecimal ei_insur_earnings) {
//         this.ei_insur_earnings = ei_insur_earnings;
//     }

// 	@Override
// 	public String toString() {
// 		return Json.encode(this);
// 	}
    
    

// }
