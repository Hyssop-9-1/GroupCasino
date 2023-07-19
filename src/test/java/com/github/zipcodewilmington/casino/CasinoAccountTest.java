package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoAccountTest {



    @Test
    void testConstructor(){
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        String expected = "Taylor";
        String expected2 = "Myers";
        double expected3 = 10.00;
        String actual = account.getUsername();
        String actual2 = account.getPassword();
        double actual3 = account.getAccountBalance();


        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }
    @Test
    void getUsername() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers");

        String expected = "Taylor";
        String actual = account.getUsername();

        assertEquals(expected, actual);
    }

    @Test
    void getPassword() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers");

        String expected = "Myers";
        String actual = account.getPassword();

        assertEquals(expected, actual);
    }

    @Test
    void getAccountBalance() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 10.00;
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }

    @Test
    void setAccountBalance() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 10.00;
        double actual = account.getAccountBalance();
        assertEquals(expected, actual);


        expected = 15.00;
        account.setAccountBalance(expected);
        actual = account.getAccountBalance();


        assertEquals(expected, actual);
    }

    @Test
    void addToAccountBalance() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 20.00;
        account.addToAccountBalance(10.00);
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }

    @Test
    void removeFromAccountBalance() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 0.00;
        account.removeFromAccountBalance(10.00);
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }
}