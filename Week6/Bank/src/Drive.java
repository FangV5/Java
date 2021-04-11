public class Drive {

    private static BankingApp bApp = null;

    public static void main(String[] args) {
        int choose = bApp.menu();
        if (choose != 1) {
            System.out.println("请先开户！");
            choose = 1;
        }
        while (choose != 8) {
            switch (choose) {
            case 1:
                int choose2 = bApp.menu2();
                switch (choose2) {
                case 1:
                    bApp.createCheckingAccount();
                    break;
                case 2:
                    bApp.createSavingsAccount();
                    break;
                default:
                    System.out.println("输入有误请重试！");
                    break;
                }
                break;
            case 2:
                bApp.save();
                break;
            case 3:
                bApp.withdraw();
                break;
            case 4:
                bApp.comsume();
                break;
            case 5:
                bApp.repay();
                break;
            case 6:
                bApp.settle();
                break;
            case 7:
                bApp.balance();
                break;
            default:
                System.out.println("输入有误请重试！");
                break;
            }
            choose = bApp.menu();
        }
    }
}
