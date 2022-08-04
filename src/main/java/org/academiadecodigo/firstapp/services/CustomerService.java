package org.academiadecodigo.firstapp.services;

import org.academiadecodigo.firstapp.exceptions.*;
import org.academiadecodigo.firstapp.persistence.model.Customer;
import org.academiadecodigo.firstapp.persistence.model.Account;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface CustomerService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    Customer get(Integer id);

    /**
     * Saves a customer
     *
     * @param customer the customer to save
     * @return the saved custoemr
     */
    Customer save(Customer customer);

    /**
     * Deletes the customer
     *
     * @param id the customer id
     * @throws CustomerNotFoundException
     * @throws AssociationExistsException
     */
    void delete(Integer id) throws AssociationExistsException, CustomerNotFoundException;

    /**
     * Gets a list of the customers
     *
     * @return the customers list
     */
    List<Customer> list();


    /**
     * Adds an account to a customer
     *
     * @param id      the customer id
     * @param account the account
     * @throws CustomerNotFoundException
     * @throws TransactionInvalidException
     */
    Account addAccount(Integer id, Account account)
            throws CustomerNotFoundException, TransactionInvalidException;

    /**
     * Closes an account from the customer
     *
     * @param id        the customer id
     * @param accountId the account id
     * @throws CustomerNotFoundException
     * @throws AccountNotFoundException
     * @throws TransactionInvalidException
     */
    void closeAccount(Integer id, Integer accountId)
            throws CustomerNotFoundException, AccountNotFoundException, TransactionInvalidException;
}
