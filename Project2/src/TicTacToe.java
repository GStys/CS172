
public class TicTacToe {

	public static void main(String[] args) {
		
		String[][] board = new String[4][4];
		for (int i=1;i<4;i++) {
			for (int j=1;j<4;j++) {
				board[i][j] = "  ";
			}
		}
		
		while (true) {
			StdOut.println();
			StdOut.println("Would you like to play a game?");
			String answer = StdIn.readString();
			if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				StdOut.println();
				StdOut.println("Well... fuck off then.");
				return;
			}
			else if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
				StdOut.println();
				StdOut.println("Time To Tic Tac Toe");
				StdOut.println();
				break;
			}
			else {
				StdOut.println();
				StdOut.println("'yes' or 'no', dumbass.");
				StdOut.println("Lets try this again...");
			}
		}
		

		// prints the current board
		StdOut.println(board[1][1] + " | " + board[1][2] + "| " + board[1][3]);
		StdOut.println("---|---|---");
		StdOut.println(board[2][1] + " | " + board[2][2] + "| " + board[2][3]);
		StdOut.println("---|---|---");
		StdOut.println(board[3][1] + " | " + board[3][2] + "| " + board[3][3]);
		StdOut.println();
		
		for (int tcount=1;tcount<=9;tcount++) {
			
			// prints which turn it is
			if (tcount%2 == 0) {	StdOut.println("X's Turn:");	}
			else {	StdOut.println("O's Turn:");	}
			
			while (true) {
				//player inputs row and column of play and the board[][] value is accordingly changed
				StdOut.println("Which row?");
				int r = StdIn.readInt();
				StdOut.println("Which column?");
				int c = StdIn.readInt();
				if (board[r][c].equals(" O") || board[r][c].equals(" X")) {
					StdOut.println("That spot is filled.");
					StdOut.println("Try again when you figure out how to count to three.");
					continue;
				}
				if (tcount%2 == 0) { board[r][c] = " X";	}
				else {	board[r][c] = " O";	}
				break;
			}

			// prints the current board
			StdOut.println();
			StdOut.println(board[1][1] + " |" + board[1][2] + " |" + board[1][3]);
			StdOut.println("---|---|---");
			StdOut.println(board[2][1] + " |" + board[2][2] + " |" + board[2][3]);
			StdOut.println("---|---|---");
			StdOut.println(board[3][1] + " |" + board[3][2] + " |" + board[3][3]);
			StdOut.println();
			
			//checks for win
			for (int i=1;i<4;i++) {
				if (board[1][i].equals(" X") && board[2][i].equals(" X") && board[3][i].equals(" X")) {
					StdOut.println("X's win!");
					return;
				} else if (board[i][1].equals(" X") && board[i][2].equals(" X") && board[i][3].equals(" X")) {
					StdOut.println("X's win!");
					return;
				} else if (board[1][i].equals(" O") && board[2][i].equals(" O") && board[3][i].equals(" O")) {
					StdOut.println("O's win!");
					return;
				} else if (board[i][1].equals(" O") && board[i][2].equals(" O") && board[i][3].equals(" O")) {
					StdOut.println("O's win!");
					return;
				} else if (board[1][1].equals(" X") && board[2][2].equals(" X") && board[3][3].equals(" X")) {
					StdOut.println("X's win!");
					return;
				} else if (board[1][3].equals(" X") && board[2][2].equals(" X") && board[3][1].equals(" X")) {
					StdOut.println("X's win!");
					return;
				} else if (board[1][1].equals(" O") && board[2][2].equals(" O") && board[3][3].equals(" O")) {
					StdOut.println("O's win!");
					return;
				} else if (board[1][3].equals(" O") && board[2][2].equals(" O") && board[3][1].equals(" O")) {
					StdOut.println("O's win!");
					return;
				}
			}
		}
		
		StdOut.println("Draw");
	}
}
