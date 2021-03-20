import java.util.Scanner;
import java.util.Arrays;

public class StudentResult {
    public static double score[];

    public static void main(String[] args) {
        int choose = 0;
        while (true) {
            choose = menu();
            if (choose != 1) {
                System.out.println("Please init score first!");
            } else {
                break;
            }
        }
        while (choose != 6) {
            switch (choose) {
            case 1:
                enterResult();
                break;
            case 2:
                classAverage();
                break;
            case 3:
                highestGrade();
                break;
            case 4:
                lowestGrade();
                break;
            case 5:
                sortGrade();
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
        System.out.println("==========StudentResult==========");
        System.out.println("1:Enter Result");
        System.out.println("2:Class Average");
        System.out.println("3:Highest Grade");
        System.out.println("4:Loest Grade");
        System.out.println("5:Sort Grade");
        System.out.println("6:Exit Program");
        System.out.print("Input your choose:");
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        return choose;
    }

    public static void enterResult() {
        score = new double[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            int num = i + 1;
            System.out.print("Input number " + num + ":");
            score[i] = scan.nextDouble();
            if (score[i] < 0 || score[i] > 100) {
                System.out.println("Out of limite!");
                i--;
            }
        }
    }

    public static void classAverage() {
        double sum = 0;
        double average = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        average = sum / score.length;
        System.out.println("Average Score: " + average);
    }

    public static void highestGrade() {
        double max = score[0];
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }
        System.out.println("Max score:" + max);
    }

    public static void lowestGrade() {
        double low = score[0];
        for (int i = 0; i < score.length; i++) {
            if (low > score[i]) {
                low = score[i];
            }
        }
        System.out.println("Low score:" + low);
    }

    public static void sortGrade() {
        Arrays.sort(score);
        for (double d : score) {
            System.out.print(d + " ");
        }
        System.out.println();

    }
}
