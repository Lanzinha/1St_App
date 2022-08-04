package org.academiadecodigo.firstapp.factories;

import org.academiadecodigo.firstapp.persistence.model.Account;
import org.springframework.stereotype.Component;

/**
 * A factory for creating accounts of different types
 */
@Component
public class AccountFactory {

    /**
     * Creates a new {@link Account}
     *
     * @return the new account
     */
    public Account createAccount() {
        return new Account();
    }
}
