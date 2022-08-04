package org.academiadecodigo.firstapp.services;

import org.academiadecodigo.firstapp.exceptions.*;
import org.academiadecodigo.firstapp.persistence.dao.AccountDao;
import org.academiadecodigo.firstapp.persistence.dao.CustomerDao;
import org.academiadecodigo.firstapp.persistence.model.AbstractModel;
import org.academiadecodigo.firstapp.persistence.model.Customer;
import org.academiadecodigo.firstapp.persistence.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private AccountDao accountDao;

    /**
     * Sets the customer data access object
     *
     * @param customerDao the account DAO to set
     */
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    /**
     * Sets the account data access object
     *
     * @param accountDao the account DAO to set
     */
    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @see CustomerService#get(Integer)
     */
    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    /**
     * @see CustomerService#save(Customer)
     */
    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    /**
     * @see CustomerService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        if (!customer.getAccounts().isEmpty()) {
            throw new AssociationExistsException();
        }

        customerDao.delete(id);
    }

    /**
     * @see CustomerService#list()
     */
    @Override
    public List<Customer> list() {
        return customerDao.findAll();
    }



    /**
     * @see CustomerService#addAccount(Integer, Account)
     */
    @Transactional
    @Override
    public Account addAccount(Integer id, Account account) throws CustomerNotFoundException, TransactionInvalidException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

/*        if (!account.canWithdraw() &&
                account.getBalance() < SavingsAccount.MIN_BALANCE) {
            throw new TransactionInvalidException();
        }*/

        customer.addAccount(account);
        customerDao.saveOrUpdate(customer);

        return customer.getAccounts().get(customer.getAccounts().size() - 1);
    }

    /**
     * @see CustomerService#closeAccount(Integer, Integer)
     */
    @Transactional
    @Override
    public void closeAccount(Integer id, Integer accountId)
            throws CustomerNotFoundException, AccountNotFoundException, TransactionInvalidException {

        Customer customer = Optional.ofNullable(customerDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        Account account = Optional.ofNullable(accountDao.findById(accountId))
                .orElseThrow(AccountNotFoundException::new);

        if (!account.getCustomer().getId().equals(id)) {
            throw new AccountNotFoundException();
        }

/*        //different from 0 in case we later decide that negative values are acceptable
        if (account.getBalance() != 0) {
            throw new TransactionInvalidException();
        }*/

        customer.removeAccount(account);
        customerDao.saveOrUpdate(customer);
    }

    private Set<Integer> getAccountIds(Customer customer) {
        List<Account> accounts = customer.getAccounts();

        return accounts.stream()
                .map(AbstractModel::getId)
                .collect(Collectors.toSet());
    }
}

