import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //final
        final double COLORING_FRAME = 0.1;
        final double REGULAR_FRAME = 0.15;
        final double FANCY_FRAME = 0.25;
        //final double CARDBOARD_PAPER = 0.02;
        //final double GLASS = 0.07;
        final double CROWN = 0.35;
        //input
        double length;
        double width;
        int choose;
        //output
        double money;

        //scan
        Scanner scan = new Scanner(System.in);
        System.out.print("length(inch):");
        length = scan.nextDouble();
        System.out.print("width(inch):");
        width = scan.nextDouble();

        //caculate
        money = 0;
        int pass = 0;
        double perimeter = 2 *(length + width);
        double square = length * width;
        System.out.println("1:regular 2:fancy");
        while (pass == 0) {
            System.out.print("The type of the frame(1 or 2):");
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    money += perimeter * REGULAR_FRAME;
                    pass = 1;
                    break;
                case 2:
                    money += perimeter * FANCY_FRAME;
                    pass = 1; 
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
        pass = 0;
        System.out.println("1:White 2:Other");
        while (pass == 0) {
            System.out.print("Frame color(1 or 2):");
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    pass = 1;
                    break;
                case 2:
                    money += perimeter * COLORING_FRAME;
                    pass =1;
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
        pass = 0;
        while (pass == 0) {
            System.out.print("The number of crowns(0 ~ 4):");
            choose = scan.nextInt();
            if (choose > 4 || choose < 0) {
                System.out.println("Wrong input!");
            } else{
                money += choose * CROWN;
                pass =1;
            }
        }

        //output
        System.out.print("Total price:");
        System.out.format("%.2f\n",money);
    }
}
