public class Main {
    public static void main(String[] args) throws InterruptedException {
        // your code here
        SavingsAccount sa = new SavingsAccount();
        Thread t1 = new Thread(() -> {
            sa.deposit(100);
            sa.deposit(2000);
            sa.withdraw(1000);
        });
        t1.setName("FIRST THREAD");
        t1.start();

        Thread t2 = new Thread(() -> {
          sa.deposit(50000);
          sa.withdraw(10000);
          sa.withdraw(1234123424);
        });
        t2.setName("SECOND THREAD");
        t2.start();

        t1.join();
        t2.join();
        System.out.println("OUR ACTUAL TOTAL: "+sa.getTotal()); //EXPECTED OUTPUT: 41_100
    }
}
