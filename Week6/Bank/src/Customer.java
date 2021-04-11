public class Customer {
    private String ssn;
    private String name;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public String toString() {
        return "Customer [checkingAccount=" + checkingAccount + ", name=" + name + ", savingsAccount=" + savingsAccount
                + ", ssn=" + ssn + "]";
    }

    public Customer(String ssn, String name, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        this.ssn = ssn;
        this.name = name;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
    }

    public Customer(String ssn, String name, CheckingAccount checkingAccount) {
        this.ssn = ssn;
        this.name = name;
        this.checkingAccount = checkingAccount;
    }

    public Customer(String ssn, String name, SavingsAccount savingsAccount) {
        this.ssn = ssn;
        this.name = name;
        this.savingsAccount = savingsAccount;
    }

}
