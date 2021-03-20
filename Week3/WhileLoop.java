import java.util.Scanner;

public class WhileLoop {

    public static int firstNum;
    public static int secondNum;

    public static void main(String[] args) {
        int choose = 0;
        while (true) {
            choose = menu();
            if (choose != 1) {
                System.out.println("Please init numbers first!");
            } else {
                break;
            }
        }
        while (choose != 5) {
            switch (choose) {
            case 1:
                inputNumbers();
                break;
            case 2:
                oddNumbers();
                break;
            case 3:
                evenNumberSum();
                break;
            case 4:
                evenSquareSum();
                break;
            default:
                System.out.println("Wrong input!");
                break;
            }
            choose = menu();
        }
    }

    public static int menu() {
        int choose;
        System.out.println("==========WhileLoop==========");
        System.out.println("1:Enter numbers");
        System.out.println("2:Odd numbers");
        System.out.println("3:Sum of even numbers");
        System.out.println("4:Sum of the squares of all the odd numbers");
        System.out.println("5:Exit Program");
        System.out.print("Input your choose:");
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        return choose;
    }

    public static void inputNumbers() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        while (true) {
            System.out.print("Input first number: ");
            firstNum = scan.nextInt();
            System.out.print("Input second number: ");
            secondNum = scan2.nextInt();
            if (firstNum < secondNum) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    public static void oddNumbers() {
        System.out.print("Odd numbers: ");
        for (int i = firstNum; i <= secondNum; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void evenNumberSum() {
        int sum = 0;
        for (int i = firstNum; i <= secondNum; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("Sum of even numbers: " + sum);
    }

    public static void evenSquareSum() {
        int sum = 0;
        for (int i = firstNum; i <= secondNum; i++) {
            if (i % 2 == 0) {
                sum += Math.pow(i, 2);
            }
        }
        System.out.println("Sum of the squares of all the odd numbers: " + sum);
    }
}
