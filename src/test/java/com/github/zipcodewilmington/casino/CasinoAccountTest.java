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
    void testConstructor2(){

        String expected = "Liz";
        String expected2 = "Lizington";
        double expected3 = 123.00;
        CasinoAccount account = new CasinoAccount(expected, expected2, expected3);
        String actual = account.getUsername();
        String actual2 = account.getPassword();
        double actual3 = account.getAccountBalance();




        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }
    @Test
    void testConstructor3(){

        String expected = "Manny";
        String expected2 = "Manington";
        double expected3 = 4784.00;
        CasinoAccount account = new CasinoAccount(expected, expected2, expected3);
        String actual = account.getUsername();
        String actual2 = account.getPassword();
        double actual3 = account.getAccountBalance();




        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }
    @Test
    void testConstructor4(){

        String expected = "Dave";
        String expected2 = "Davington";
        double expected3 = 898981.00;
        CasinoAccount account = new CasinoAccount(expected, expected2, expected3);
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
    void getUsername1() {
        CasinoAccount account = new CasinoAccount("Liz", "Lizington");

        String expected = "Liz";
        String actual = account.getUsername();

        assertEquals(expected, actual);
    }
    @Test
    void getUsername2() {
        CasinoAccount account = new CasinoAccount("Manny", "Manington");

        String expected = "Manny";
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
    void getPassword1() {
        CasinoAccount account = new CasinoAccount("Liz", "Lizington");

        String expected = "Lizington";
        String actual = account.getPassword();

        assertEquals(expected, actual);
    }
    @Test
    void getPassword2() {
        CasinoAccount account = new CasinoAccount("Manny", "Manington");

        String expected = "Manington";
        String actual = account.getPassword();

        assertEquals(expected, actual);
    }
    @Test
    void getPassword3() {
        CasinoAccount account = new CasinoAccount("Dave", "Davington");

        String expected = "Davington";
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
    void getAccountBalance1() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 100.00);

        double expected = 100.00;
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }
    @Test
    void getAccountBalance2() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 231.00);

        double expected = 231.00;
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }
    @Test
    void getAccountBalance3() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 9919.31);

        double expected = 9919.31;
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
    void setAccountBalance1() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 10.00;
        double actual = account.getAccountBalance();
        assertEquals(expected, actual);


        expected = 212.00;
        account.setAccountBalance(expected);
        actual = account.getAccountBalance();


        assertEquals(expected, actual);
    }
    @Test
    void setAccountBalance2() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 10.00;
        double actual = account.getAccountBalance();
        assertEquals(expected, actual);


        expected = 3133.00;
        account.setAccountBalance(expected);
        actual = account.getAccountBalance();


        assertEquals(expected, actual);
    }
    @Test
    void setAccountBalance3() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 10.00;
        double actual = account.getAccountBalance();
        assertEquals(expected, actual);


        expected = 12144.44;
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
    void addToAccountBalance1() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 30.00;
        account.addToAccountBalance(20.00);
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }
    @Test
    void addToAccountBalance2() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 10.00);

        double expected = 200.00;
        account.addToAccountBalance(190.00);
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
    @Test
    void removeFromAccountBalance1() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 100.00);

        double expected = 90.00;
        account.removeFromAccountBalance(10.00);
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }
    @Test
    void removeFromAccountBalance2() {
        CasinoAccount account = new CasinoAccount("Taylor", "Myers", 200.00);

        double expected = 190.00;
        account.removeFromAccountBalance(10.00);
        double actual = account.getAccountBalance();

        assertEquals(expected, actual);
    }
}