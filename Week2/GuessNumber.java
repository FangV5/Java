import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        char choose;
        do {
            final int MAX_TIMES = 10;
            int randomNumber;
            randomNumber = 1 + (int) (Math.random() * 1000);

            Scanner scan = new Scanner(System.in);

            int times = 1;

            while (true) {
                if (times > MAX_TIMES) {
                    System.out.println("Out of times!");
                    break;
                }
                System.out.print("Input a number(1~1000):");
                int myGuess = scan.nextInt();
                if (randomNumber == myGuess) {
                    System.out.println("Right!");
                    times += 1;
                    System.out.println("Your times is:" + times + " times");
                    break;
                } else {
                    if (myGuess > randomNumber) {
                        System.out.println("Too high!");
                        times += 1;
                    } else {
                        System.out.println("Too low!");
                        times += 1;
                    }
                }
            }
            System.out.print("Play again?(Y/N):");
            Scanner scan1 = new Scanner(System.in);
            choose = scan1.next().charAt(0);
        } while (choose == 'Y');

    }
}
