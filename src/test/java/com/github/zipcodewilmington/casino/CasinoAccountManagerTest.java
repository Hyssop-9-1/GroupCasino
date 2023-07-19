package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoAccountManagerTest {

    @Test
    void getAccount() {
        CasinoAccount account  = new CasinoAccount("Taylor", "Myers", 10.00);
        CasinoAccountManager manager = new CasinoAccountManager();
        manager.registerAccount(account);

        String username = "Taylor";
        String password = "Myers";
        CasinoAccount expected = manager.getAccount(username, password);

        assertEquals(account, expected);
    }

    @Test
    void createAccount() {
        CasinoAccountManager manager = new CasinoAccountManager();
        CasinoAccount account = manager.createAccount("Taylor", "Myers");

        assertTrue(account instanceof CasinoAccount);
    }

    @Test
    void registerAccount() {
        CasinoAccount account  = new CasinoAccount("Taylor", "Myers", 10.00);
        CasinoAccountManager manager = new CasinoAccountManager();
        manager.registerAccount(account);


        int expected = 1;
        int actual = manager.accounts.size();

        assertEquals(expected,actual);
    }
}