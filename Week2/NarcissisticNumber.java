import java.util.Scanner;

public class NarcissisticNumber {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Number(3~7):");
        n = scan.nextInt();
        int max = (int) Math.pow(10, n);
        int min = (int) Math.pow(10, n - 1);
        for (int i = min; i < max; i++) {
            int num = i;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int wei = num % 10;
                num = num / 10;
                sum += (int) Math.pow(wei, n);
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
