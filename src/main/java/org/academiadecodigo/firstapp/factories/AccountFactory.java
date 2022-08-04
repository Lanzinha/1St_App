package org.academiadecodigo.firstapp.factories;

import org.academiadecodigo.firstapp.errors.ErrorMessage;
import org.academiadecodigo.firstapp.persistence.model.Account;
import org.academiadecodigo.firstapp.persistence.model.account.AccountType;
import org.academiadecodigo.firstapp.persistence.model.account.CheckingAccount;
import org.academiadecodigo.firstapp.persistence.model.account.SavingsAccount;
import org.springframework.stereotype.Component;

/**
 * A factory for creating accounts of different types
 */
@Component
public class AccountFactory {

    /**
     * Creates a new {@link Account}
     *
     * @param accountType the account type
     * @return the new account
     */
    public Account createAccount(AccountType accountType) {

        Account newAccount;

        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount();
                break;
            case SAVINGS:
                newAccount = new SavingsAccount();
                break;
            default:
                throw new IllegalArgumentException(ErrorMessage.TRANSACTION_INVALID);
        }

        return newAccount;
    }
}
