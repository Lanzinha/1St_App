package org.academiadecodigo.firstapp.exceptions;

import org.academiadecodigo.firstapp.errors.ErrorMessage;

/**
 * Thrown to indicate that the transaction was not valid
 */
public class TransactionInvalidException extends JavaBankException {

    /**
     * @see JavaBankException#JavaBankException(String)
     */
    public TransactionInvalidException() {
        super(ErrorMessage.TRANSACTION_INVALID);
    }
}
