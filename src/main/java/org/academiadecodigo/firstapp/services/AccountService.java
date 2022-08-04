package org.academiadecodigo.firstapp.services;

import org.academiadecodigo.firstapp.exceptions.AccountNotFoundException;
import org.academiadecodigo.firstapp.exceptions.CustomerNotFoundException;
import org.academiadecodigo.firstapp.exceptions.TransactionInvalidException;
import org.academiadecodigo.firstapp.persistence.model.Account;

/**
 * Common interface for account services, provides methods to manage accounts and perform account transactions
 */
public interface AccountService {

    /**
     * Gets the account with the given id
     *
     * @param id the account id
     * @return the account
     */
    Account get(Integer id);

}
