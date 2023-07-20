package com.github.zipcodewilmington.casino;

public abstract class GamblingPlayer implements PlayerInterface {

   private Double currentBet;
   CasinoAccount acct;


   public GamblingPlayer(CasinoAccount acct){
       this.acct = acct;
   }

   public CasinoAccount getArcadeAccount() {
      return acct;
   }

   public double getCurrentBet(){ //Used for Roll Game to track bet but not necessarily lose money
      return currentBet;
   }

   public void setCurrentBet(double bet){
      this.currentBet = bet;
   }

   public void collectWinnings(double winnings){
      acct.addToAccountBalance(winnings);
   }

   public void payToPlay(double cost) { //every gambling game
      acct.removeFromAccountBalance(cost);
   }
   public String getAccountName(){return acct.getUsername();}

}
