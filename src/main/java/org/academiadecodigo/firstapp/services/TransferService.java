package org.academiadecodigo.firstapp.services;

import org.academiadecodigo.firstapp.domain.Transfer;
import org.academiadecodigo.firstapp.exceptions.AccountNotFoundException;
import org.academiadecodigo.firstapp.exceptions.CustomerNotFoundException;
import org.academiadecodigo.firstapp.exceptions.TransactionInvalidException;
import org.academiadecodigo.firstapp.persistence.model.Account;

/**
 * Common interface for transfer services, provides methods to perform account transfers
 */
public interface TransferService {

    /**
     * Performs a transfer between two {@link Account}
     *
     * @param transfer the transfer object
     * @throws AccountNotFoundException
     * @throws TransactionInvalidException
     */
    void transfer(Transfer transfer)
            throws AccountNotFoundException, TransactionInvalidException;

    /**
     * Performs a transfer between two {@link Account}, if possible
     *
     * @param transfer   the transfer object
     * @param customerId the customer id
     * @throws CustomerNotFoundException
     * @throws AccountNotFoundException
     * @throws TransactionInvalidException
     */
    void transfer(Transfer transfer, Integer customerId)
            throws CustomerNotFoundException, AccountNotFoundException, TransactionInvalidException;
}
