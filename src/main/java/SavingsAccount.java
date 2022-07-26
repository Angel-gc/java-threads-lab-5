public class SavingsAccount {

  private long total = 0;

  public synchronized boolean withdraw(long amount) {
      if (amount > total) return false;
      total -= amount;
      return true;
  }

  public synchronized void deposit(long amount) {
      total+= amount;
  }

  public synchronized long getTotal() {
      return total;
  }
}