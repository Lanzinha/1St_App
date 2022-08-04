package org.academiadecodigo.javabank.persistence.model;


import javax.persistence.*;

/**
 * A generic account model entity to be used as a base for concrete types of accounts
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public class Account extends AbstractModel {

    private String suggestion;
    private String picUrl;

    @ManyToOne
    private Customer customer;

    /**
     * Gets the account costumer
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the account costumer
     *
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
