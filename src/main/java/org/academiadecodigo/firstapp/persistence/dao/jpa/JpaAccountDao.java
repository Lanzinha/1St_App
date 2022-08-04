package org.academiadecodigo.firstapp.persistence.dao.jpa;

import org.academiadecodigo.firstapp.persistence.dao.AccountDao;
import org.academiadecodigo.firstapp.persistence.model.Account;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link AccountDao} implementation
 */
@Repository
public class JpaAccountDao extends GenericJpaDao<Account> implements AccountDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaAccountDao() {
        super(Account.class);
    }
}
