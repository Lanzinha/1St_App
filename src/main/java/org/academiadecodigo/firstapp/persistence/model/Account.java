package org.academiadecodigo.firstapp.persistence.model;


import javax.persistence.*;

/**
 * A generic account model entity to be used as a base for concrete types of accounts
 */
@Entity
@Table(name = "addiction")
public class Account extends AbstractModel {

    private String name;
    private String suggestion;
    private String picUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Customer customer;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSuggestion() {return suggestion;}

    public void setSuggestion(String suggestion) {this.suggestion = suggestion;}

    public String getPicUrl() {return picUrl;}

    public void setPicUrl(String picUrl) {this.picUrl = picUrl;}

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

    @Override
    public String toString() {

        return "Account{" +
                "name=" + name +
                ", suggestion=" + suggestion +
                ", picUrl=" + picUrl +
                ", userId=" + (customer != null ? customer.getId() : null) +
                "} " + super.toString();
    }

}
