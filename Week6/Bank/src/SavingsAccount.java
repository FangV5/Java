public class SavingsAccount extends BankAccount {
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void payInterest() {
        this.setBalance(this.getInterestRate() * this.getBalance() + this.getBalance());
    }

    @Override
    public String toString() {
        return "SavingsAccount [interestRate=" + interestRate + "]" + "\n" + super.toString();
    }

    public SavingsAccount(String accountNum, double balance, double interestRate) {
        super(accountNum, balance);
        this.interestRate = interestRate;
    }

}