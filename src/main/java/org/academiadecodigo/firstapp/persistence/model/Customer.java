package org.academiadecodigo.firstapp.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {

    private String name;
    private String pass;
    //private String email;
    //private String phone;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Account> accounts = new ArrayList<>();

    /**
     * Gets the first name of the customer
     *
     * @return the customer last name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the customer
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {return pass;}

    public void setPass(String pass) {this.pass = pass;}

/*

    */
/**
     * Gets the email of the customer
     *
     * @return the customer email
     *//*

    public String getEmail() {
        return email;
    }

    */
/**
     * Sets the email of the customer
     *
     * @param email the email to set
     *//*

    public void setEmail(String email) {
        this.email = email;
    }

    */
/**
     * Gets the phone of the customer
     *
     * @return the customer phone
     *//*

    public String getPhone() {
        return phone;
    }

    */
/**
     * Sets the phone of the customer
     *
     * @param phone the phone to set
     *//*

    public void setPhone(String phone) {
        this.phone = phone;
    }
*/

    /**
     * Gets the customer accounts
     *
     * @return the accounts
     */
    public List<Account> getAccounts() {return accounts;}

    /**
     * Adds a new account to the customer
     *
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
        account.setCustomer(this);
    }

    /**
     * Removes an account from the customer
     *
     * @param account the account to remove
     */
    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setCustomer(null);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                "accounts" + accounts +
                "} " + super.toString();
    }

}



