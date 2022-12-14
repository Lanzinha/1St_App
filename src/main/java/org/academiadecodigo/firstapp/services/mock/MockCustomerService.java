package org.academiadecodigo.firstapp.services.mock;

import org.academiadecodigo.firstapp.exceptions.AssociationExistsException;
import org.academiadecodigo.firstapp.persistence.model.AbstractModel;
import org.academiadecodigo.firstapp.persistence.model.Customer;
import org.academiadecodigo.firstapp.persistence.model.Account;
import org.academiadecodigo.firstapp.services.AccountService;
import org.academiadecodigo.firstapp.services.CustomerService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A mock {@link CustomerService} implementation
 */
public class MockCustomerService extends AbstractMockService<Customer> implements CustomerService {

    private AccountService accountService;

    /**
     * Sets the customer service
     *
     * @param accountService the customer service to set
     */
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @see CustomerService#get(Integer)
     */
    @Override
    public Customer get(Integer id) {
        return modelMap.get(id);
    }


    /**
     * @see CustomerService#save(Customer)
     */
    @Override
    public Customer save(Customer customer) {

        if (customer.getId() == null) {
            customer.setId(getNextId());
        }

        modelMap.put(customer.getId(), customer);
        return customer;
    }

    /**
     * @see CustomerService#delete(Integer)
     */
    @Override
    public void delete(Integer id) throws AssociationExistsException {

        Customer customer = get(id);

        if (!customer.getAccounts().isEmpty()) {
            throw new AssociationExistsException();
        }

        modelMap.remove(id);
    }

    /**
     * @see CustomerService#list()
     */
    @Override
    public List<Customer> list() {
        return new ArrayList<>(modelMap.values());
    }

    /**
     * @see CustomerService#addAccount(Integer, Account)
     */
    @Override
    public Account addAccount(Integer id, Account account) {
        Customer customer = get(id);
        customer.addAccount(account);
        return account;
    }

    /**
     * @see CustomerService#closeAccount(Integer, Integer)
     */
    @Override
    public void closeAccount(Integer cid, Integer accountId) {
        Customer customer = modelMap.get(cid);

        customer.getAccounts().stream()
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .ifPresent(customer::removeAccount);
    }

    private Set<Integer> getAccountIds(Customer customer) {
        List<Account> accounts = customer.getAccounts();

        return accounts.stream()
                .map(AbstractModel::getId)
                .collect(Collectors.toSet());
    }
}
