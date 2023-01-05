package au.com.telstra.simcardactivator;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class CustomerData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String iccid;
    private String customerEmail;
    private Boolean active;

    protected CustomerData() {}

    public CustomerData(String iccid, String customerEmail, Boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format( "CustomerData[id%d, iccid='%s', customerEmail='%s', active=%b]", id, iccid, customerEmail, active);
    }

    public Long getId() {
        return id;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Boolean getActive() {
        return active;
    }
}
