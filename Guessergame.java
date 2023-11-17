import java.util.Scanner;
//modified such that players will get hints after finishing the game
//which they can use in another round
class Guesser {
	int guessNum;

	void guessNum() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Guesser enter the number");
		guessNum = scan.nextInt();
		if (guessNum <= 0) {
			System.out.println("please enter a positive number");
			guessNum = scan.nextInt();
		}
	}
}

class Player {
	int guessNum;

	void guessNum() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player kindly guess the number");
		guessNum = scan.nextInt();
		if (guessNum <= 0) {
			System.out.println("please enter a positive number");
			guessNum = scan.nextInt();
		}
	}
}

class Umpire {
	Player p1 = new Player();
	Player p2 = new Player();
	Player p3 = new Player();
	Guesser g = new Guesser();

	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;

	void collectNumFromGuesser() {
		g.guessNum();
		numFromGuesser = g.guessNum;
	}

	void collectNumFromPlayers() {

		p1.guessNum();
		p2.guessNum();
		p3.guessNum();

		numFromPlayer1 = p1.guessNum;
		numFromPlayer2 = p2.guessNum;
		numFromPlayer3 = p3.guessNum;

	}

	void offBy(int correct, int guess) {
		float ratio = ((float) correct - (float) guess) / (float) guess;
		if (ratio < 0) {
			System.out.println("your guess is larger than the correct number");

			if (Math.abs(ratio) <= .5) {
				System.out.println("but you are very close to the correct number");
			} else {
				System.out.println("your guess is more than double the correct number");
			}

		} else {
			System.out.println("your guess is smaller than the correct number");

			if (Math.abs(ratio) <= .5) {
				System.out.println("but you are very close to the correct number");
			} else {
				System.out.println("your guess is less  than half the correct number");
			}

		}

	}

	String calc() {
		String s = "";
		if (numFromGuesser == numFromPlayer1) {
			s = s + "1";
		} else {
			s = s + "0";
		}
		if (numFromGuesser == numFromPlayer2) {
			s = s + "1";
		} else {
			s = s + "0";
		}
		if (numFromGuesser == numFromPlayer3) {
			s = s + "1";
		} else {
			s = s + "0";
		}

		return s;
	}

	void compare() {
		String result = calc();

		for (int i = 1; i <= 3; i++) {
			if (result.charAt(i - 1) == '1') {
				System.out.println("----------------------------");
				System.out.println("player " + i + " won");
				System.out.println("----------------------------");
			} else {
				System.out.println("player " + i + " lost");
				if (i == 1) {
					offBy(g.guessNum, p1.guessNum);
					System.out.println("----------------------------");

				} else if (i == 2) {
					offBy(g.guessNum, p2.guessNum);
					System.out.println("----------------------------");

				} else {
					offBy(g.guessNum, p3.guessNum);
					System.out.println("----------------------------");

				}

			}

		}

	}

}

public class Guessergame {

	public static void main(String[] args) {

		Umpire u = new Umpire();
		System.out.println("This is modified guesser game");
		System.out.println("total 4 players can play this game");
		System.out.println("one player will enter the number to guess only once");
		System.out.println("other three will try to guess it");
		u.collectNumFromGuesser();
		System.out.println("Now the three players will try to guess");
		u.collectNumFromPlayers();
		u.compare();
		System.out.println("Use the hints and try again");
		u.collectNumFromPlayers();
		u.compare();
		

	}

}
