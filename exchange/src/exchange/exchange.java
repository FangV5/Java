package exchange;

import java.util.Scanner;

public class exchange {
	public static void main(String[] args) {
		//final
		final int FIFTYCENT = 50;
		final int TWENTYCENT = 20;
		final int TENCENT = 10;
		final int FIVECENT = 5;
		final int ONEDOLLAR = 100;
		final int TWODOLLAR = 200;
		//input
		double money;
		//output
		int fiftyCent;
		int twentyCent;
		int tenCent;
		int fiveCent;
		int oneDollar;
		int twoDollar;

		//scan
		Scanner scan = new Scanner(System.in);
		System.out.print("Money:");
		money = scan.nextDouble();

		//caculate
		money = 100 * money;
		twoDollar = (int)(money / TWODOLLAR);
		money = money % TWODOLLAR;
		oneDollar = (int)(money / ONEDOLLAR);
		money = money % ONEDOLLAR;
		fiftyCent = (int)(money / FIFTYCENT);
		money = money % FIFTYCENT;
		twentyCent = (int)(money / TWENTYCENT);
		money = money % TWENTYCENT;
		tenCent = (int)(money / TENCENT);
		money = money % TENCENT;
		fiveCent = (int)(money / FIVECENT);
		money = money % FIVECENT;

		//output
		System.out.println("2 Dollar:"+twoDollar);
		System.out.println("1 Dollar:"+oneDollar);
		System.out.println("50 Cent:"+fiftyCent);
		System.out.println("20 Cent:"+twentyCent);
		System.out.println("10 Cent:"+tenCent);
		System.out.println("5 Cent:"+fiveCent);
	}
}