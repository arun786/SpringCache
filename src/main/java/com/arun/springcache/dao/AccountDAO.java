package com.arun.springcache.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    private Logger logger = LoggerFactory.getLogger(AccountDAO.class);


    @Cacheable("accounts")
    public String geAccountByNameId(final int id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "arun";
    }

    @CacheEvict("accounts")
    public String evictAccountName(final int id) {
        logger.info("Evicted the id " + id);
        return "evicted";
    }
}
