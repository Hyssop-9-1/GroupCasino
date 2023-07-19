package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {

    String username;
    String password;
    Double accountBalance;
    public CasinoAccount(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public Double getAccountBalance() {
        return accountBalance;
    }
    public void addToAccountBalance(Double incoming){
        accountBalance += incoming;
    }
    public void removeFromAccountBalance(Double outgoing){
        accountBalance-=outgoing;
    }
}
