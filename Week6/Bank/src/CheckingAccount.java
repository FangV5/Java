public class CheckingAccount extends BankAccount {
    private double serviceCharge;

    public CheckingAccount(String accountNum, double balance, double serviceCharge) {
        super(accountNum, balance);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public void assessServiceCharge() {
        this.setBalance(this.getServiceCharge() * this.getBalance() + this.getBalance());
    }

    @Override
    public String toString() {
        return "CheckingAccount [serviceCharge=" + serviceCharge + "]" + "\n" + super.toString();
    }

}
