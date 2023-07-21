package com.github.zipcodewilmington.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void testGetAbbreviation() {
        Rank rank = Rank.ACE;

        String expected = "A";
        String actual = rank.getAbbreviation();

        assertEquals(expected,actual);
    }
    @Test
    void testGetAbbreviation1() {
        Rank rank = Rank.QUEEN;

        String expected = "Q";
        String actual = rank.getAbbreviation();

        assertEquals(expected,actual);
    }
    @Test
    void testGetAbbreviation2() {
        Rank rank = Rank.TWO;

        String expected = "2";
        String actual = rank.getAbbreviation();

        assertEquals(expected,actual);
    }
    @Test
    void testGetAbbreviation3() {
        Rank rank = Rank.SEVEN;

        String expected = "7";
        String actual = rank.getAbbreviation();

        assertEquals(expected,actual);
    }

    @Test
    void testGetBlackJackValue() {
        Rank rank = Rank.SEVEN;

        int expected = 7;
        int actual = rank.getBlackJackValue();

        assertEquals(expected,actual);
    }
    @Test
    void testGetBlackJackValue1() {
        Rank rank = Rank.KING;

        int expected = 10;
        int actual = rank.getBlackJackValue();

        assertEquals(expected,actual);
    }
    @Test
    void testGetBlackJackValue2() {
        Rank rank = Rank.ACE;

        int expected = 1;
        int actual = rank.getBlackJackValue();

        assertEquals(expected,actual);
    }
    @Test
    void testGetBlackJackValue3() {
        Rank rank = Rank.FIVE;

        int expected = 5;
        int actual = rank.getBlackJackValue();

        assertEquals(expected,actual);
    }

}