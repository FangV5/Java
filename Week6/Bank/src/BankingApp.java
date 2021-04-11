import java.util.Scanner;

public class BankingApp {

    private static Customer account = null;

    public static int menu() {
        int choose = 0;
        System.out.println("��ӭʹ������ϵͳ");
        System.out.println("1.����create");
        System.out.println("2.���save");
        System.out.println("3.ȡ��withdraw");
        System.out.println("4.����comsume");
        System.out.println("5.����repay");
        System.out.println("6.���н���settle");
        System.out.println("7.��ѯ���balance");
        System.out.println("8.�˳�exit");
        System.out.println("��ѡ��1-8��: ");
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        return choose;
    }

    public static int menu2() {
        int choose = 0;
        System.out.println("��ѡ�񿪿�����");
        System.out.println("1.���ÿ�checkingAccount");
        System.out.println("2.�洢��savingAccount");
        System.out.println("3.����exit");
        System.out.println("��ѡ��1-3����");
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        return choose;
    }

    public static void createCheckingAccount() {
        System.out.print("������SSN: ");
        Scanner scan1 = new Scanner(System.in);
        String ssn = scan1.nextLine();
        System.out.print("����������: ");
        Scanner scan2 = new Scanner(System.in);
        String name = scan2.nextLine();
        System.out.print("�����뿨��: ");
        Scanner scan3 = new Scanner(System.in);
        String accountNum = scan3.nextLine();
        System.out.print("������������: ");
        Scanner scan4 = new Scanner(System.in);
        double serviceCharge = scan4.nextDouble();
        CheckingAccount cAccount = new CheckingAccount(accountNum, 0, serviceCharge);
        if (account == null) {
            account = new Customer(ssn, name, cAccount);
        } else {
            account.setSsn(ssn);
            account.setName(name);
            account.setCheckingAccount(cAccount);
        }
        System.out.println("�����ɹ���");
    }

    public static void createSavingsAccount() {
        System.out.print("������SSN: ");
        Scanner scan1 = new Scanner(System.in);
        String ssn = scan1.nextLine();
        System.out.print("����������: ");
        Scanner scan2 = new Scanner(System.in);
        String name = scan2.nextLine();
        System.out.print("�����뿨��: ");
        Scanner scan3 = new Scanner(System.in);
        String accountNum = scan3.nextLine();
        System.out.print("����������: ");
        Scanner scan4 = new Scanner(System.in);
        double interestRate = scan4.nextDouble();
        SavingsAccount sAccount = new SavingsAccount(accountNum, 0, interestRate);
        if (account == null) {
            account = new Customer(ssn, name, sAccount);
        } else {
            account.setSsn(ssn);
            account.setName(name);
            account.setSavingsAccount(sAccount);
        }

        System.out.println("�����ɹ���");
    }

    public static void save() {
        System.out.print("�������");
        Scanner scan = new Scanner(System.in);
        double money = scan.nextDouble();
        if (money < 0) {
            System.out.println("����Ƿ���");
            return;
        } else {
            account.getSavingsAccount().setBalance(account.getSavingsAccount().getBalance() + money);
            System.out.println("����ɹ���");
        }
    }

    public static void withdraw() {
        System.out.print("����ȡ���");
        Scanner scan = new Scanner(System.in);
        double money = scan.nextDouble();
        if (money > account.getSavingsAccount().getBalance() || money < 0) {
            System.out.println("���������Ƿ���");
            return;
        } else {
            account.getSavingsAccount().setBalance(account.getSavingsAccount().getBalance() - money);
            System.out.println("ȡ��ɹ���");
        }
    }

    public static void comsume() {
        System.out.print("�������ѽ�");
        Scanner scan = new Scanner(System.in);
        double money = scan.nextDouble();
        if (money < 0) {
            System.out.println("����Ƿ���");
            return;
        } else {
            account.getCheckingAccount().setBalance(account.getCheckingAccount().getBalance() + money);
            System.out.println("���ѳɹ���");
        }
    }

    public static void repay() {
        System.out.print("���뻹���");
        Scanner scan = new Scanner(System.in);
        double money = scan.nextDouble();
        if (money > account.getCheckingAccount().getBalance() || money < 0) {
            System.out.println("����Ƿ���������Ƿ���");
            return;
        } else {
            account.getCheckingAccount().setBalance(account.getCheckingAccount().getBalance() - money);
            System.out.println("����ɹ���");
        }
    }

    public static void settle() {
        double money = account.getCheckingAccount().getServiceCharge() * account.getCheckingAccount().getBalance();
        System.out.println("�����Ϊ��" + money);
        account.getCheckingAccount().assessServiceCharge();
        double money2 = account.getSavingsAccount().getInterestRate() * account.getSavingsAccount().getBalance();
        System.out.println("��ϢΪ��" + money2);
        account.getSavingsAccount().payInterest();
    }

    public static void balance() {
        System.out.println("���ÿ�����Ϊ��" + account.getCheckingAccount().getBalance());
        System.out.println("�洢�����Ϊ��" + account.getSavingsAccount().getBalance());
    }
}
/*
 * public static void main(String[] args) { int choose = menu(); if (choose !=
 * 1) { System.out.println("���ȿ�����"); choose = 1; } while (choose != 8) { switch
 * (choose) { case 1: int choose2 = menu2(); switch (choose2) { case 1:
 * createCheckingAccount(); break; case 2: createSavingsAccount(); break;
 * default: System.out.println("�������������ԣ�"); break; } break; case 2: save();
 * break; case 3: withdraw(); break; case 4: comsume(); break; case 5: repay();
 * break; case 6: settle(); break; case 7: balance(); break; default:
 * System.out.println("�������������ԣ�"); break; } choose = menu(); } }
 * 
 * public BankingApp() { } }
 */