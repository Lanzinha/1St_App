package org.academiadecodigo.firstapp.services;


import org.academiadecodigo.firstapp.persistence.dao.AccountDao;
import org.academiadecodigo.firstapp.persistence.dao.CustomerDao;
import org.academiadecodigo.firstapp.persistence.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An {@link AccountService} implementation
 */
@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private CustomerDao customerDao;

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
     * Sets the customer data access object
     *
     * @param customerDao the customer DAO to set
     */
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * @see AccountService#get(Integer)
     */
    @Override
    public Account get(Integer id) {
        return accountDao.findById(id);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

}
