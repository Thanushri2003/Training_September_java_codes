import java.util.Scanner;

public class Calculator {
	public long a;
	public long b;

	public long Addition(long a, long b) {
		return a + b;
	}

	public long Mul(long a, long b) {
		return a * b;
	}

	public long Div(long a, long b) {
		return a / b;
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();

		Scanner sc = new Scanner(System.in);

		System.out.println("welcome to the calculator!!!");
		while (true) {
			System.out.println("Here are the options");
			System.out.println("1.Addition \n 2.Mul  \n 3.Division");

			System.out.println("Enter the numbers:");
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.print("Enter your operation??");
			int cc = sc.nextInt();

			switch (cc) {
			case 1:

				System.out.println("Answer after addition:" + c.Addition(a, b));
				break;

			case 2:

				System.out.println("Answer after mul :" + c.Mul(a, b));
				break;

			case 3:
				System.out.println("Answer after div :" + c.Div(a, b));
				break;

			default:
				System.out.println("invalid!!!");
				break;

			}

		}

	}

}
