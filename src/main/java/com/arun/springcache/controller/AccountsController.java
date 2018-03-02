package com.arun.springcache.controller;

import com.arun.springcache.dao.AccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    Logger logger = LoggerFactory.getLogger(AccountsController.class);
    @Autowired
    private AccountDAO accountDAO;

    @GetMapping("/account/{id}")
    public String getAccountByNameId(@PathVariable final int id) {
        StopWatch stopWatch = new StopWatch(Integer.toString(id));
        stopWatch.start();
        String accountName = accountDAO.geAccountByNameId(id);
        stopWatch.stop();
        logger.info("Time taken  {} " + stopWatch);
        return accountName;
    }


    @GetMapping("/account/{id}/evict")
    public String evictTheAccountDAO(@PathVariable final int id) {
        return accountDAO.evictAccountName(id);
    }
}
