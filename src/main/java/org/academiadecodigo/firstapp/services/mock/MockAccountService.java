package org.academiadecodigo.firstapp.services.mock;

import org.academiadecodigo.firstapp.persistence.model.Account;
import org.academiadecodigo.firstapp.services.AccountService;
import org.academiadecodigo.firstapp.services.CustomerService;

import java.util.Optional;

/**
 * A mock {@link AccountService} implementation
 */
public class MockAccountService extends AbstractMockService<Account> implements AccountService {

    private CustomerService customerService;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @see AccountService#get(Integer)
     */
    @Override
    public Account get(Integer id) {
        return modelMap.get(id);
    }

}
