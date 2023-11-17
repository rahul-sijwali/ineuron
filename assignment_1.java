public class assignment_1 {
	static void printIneuron() {
		System.out.println("INEURON");
	}

	static void printpattern2() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	static void printpattern3() {
		int gaps;
		for (int i = 0; i < 14; i++)
			System.out.print("*");
		System.out.println();
		for (int i = 1; i < 7; i++) {
			gaps = (2 * i) - 1;
			for (int j = 1; j <= 7 - i; j++) {
				System.out.print("*");

			}
			for (int j = 1; j <= gaps; j++) {
				System.out.print(" ");

			}
			for (int j = 1; j <= 8 - i; j++) {
				System.out.print("*");

			}
			System.out.println();
		}

		for (int i = 0; i < 6; i++) {
			System.out.print("*");
			for (int j = 0; j < 12; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}

		for (int j = 0; j < 14; j++) {
			System.out.print("*");
		}
		System.out.println();
	}

	static void printpattern4() {
		int gaps;
		for (int i = 0; i < 7; i++) {
			gaps = 14 - (i + 1) * 2;
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < gaps; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int j = 0; j < 14; j++) {
			System.out.print("*");
		}
		System.out.println();

	}

	static void printpattern5() {
		for (int i = 0; i < 14; i++) {
			System.out.print("*");
		}
		System.out.println();

		for (int i = 1; i < 7; i++) {
			for (int j = 7-i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 2; i <=7; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 14; i++) {
			System.out.print("*");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		printIneuron();
		System.out.println("----------------------------------------");
		printpattern2();
		System.out.println("----------------------------------------");
		printpattern3();
		System.out.println("----------------------------------------");
		printpattern4();
		System.out.println("----------------------------------------");
		printpattern5();


	}

}
