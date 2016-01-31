
public class ConnectFour {

	public static void main(String[] args) {
		
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
				StdOut.println("Connect Four:");
				StdOut.println();
				break;
			}
			else {
				StdOut.println();
				StdOut.println("'yes' or 'no', dumbass.");
				StdOut.println("Lets try this again...");
			}
		}
		
		String[][] board = new String[7][8];
		for (int i=1;i<7;i++) {
			for (int j=1;j<8;j++) {
				board[i][j] = " ";
			}
		}
		
		// prints the current board
		StdOut.println("Col:  1   2   3   4   5   6   7");
		StdOut.println("    |---|---|---|---|---|---|---|");
		for (int i=1;i<7;i++) {
			StdOut.print("    | ");
			for (int j=1;j<8;j++) {
				StdOut.print(board[i][j] + " | ");
			}
			StdOut.println();
			StdOut.println("    |---|---|---|---|---|---|---|");
		}
		StdOut.println();
		
		for (int tCount=1;tCount<=42;tCount++) {
			// prints which turn it is
			if (tCount%2 == 0) {	StdOut.println("X's Turn:");	}
			else {	StdOut.println("O's Turn:");	}
			
			//player inputs column and board[][] value accordingly changed
			while (true) {
				StdOut.println("Which column?");
				int col = StdIn.readInt();
				if (!(board[1][col].equals(" "))) {
					StdOut.println("That column is filled.");
					StdOut.println("Lets try this again.\n");
					continue;
				}
				for (int row=6;row>=1;row--) {
					if (board[row][col].equals(" ")) {
						if (tCount%2 == 0) {
							board[row][col] = "X";
							break;
						} else {
							board[row][col] = "O";
							break;
						}
					}
				}
				break;
			}
			
			// prints the current board
			StdOut.println("Col:  1   2   3   4   5   6   7");
			StdOut.println("    |---|---|---|---|---|---|---|");
			for (int i=1;i<7;i++) {
				StdOut.print("    | ");
				for (int j=1;j<8;j++) {
					StdOut.print(board[i][j] + " | ");
				}
				StdOut.println();
				StdOut.println("    |---|---|---|---|---|---|---|");
			}
			StdOut.println();
			
			// checks for win
			String win = " ";
			// horizontal win checks
			for (int row=1;row<7;row++) {
				if (!(win.equals(" "))) {	break;	}
				for (int col=1;col<=4;col++) {
					if (!(win.equals(" "))) {	break;	}
					if (board[row][col].equals("X") && board[row][col+1].equals("X") && board[row][col+2].equals("X") && board[row][col+3].equals("X")) {
						win = "X";
					} else if (board[row][col].equals("O") && board[row][col+1].equals("O") && board[row][col+2].equals("O") && board[row][col+3].equals("O")) {
						win = "O";
					}
				}
			}
			//vertical win checks
			for (int col=1;col<8;col++) {
				if (!(win.equals(" "))) {	break;	}
				for (int row=1;row<=3;row++) {
					if (!(win.equals(" "))) {	break;	}
					if (board[row][col].equals("X") && board[row+1][col].equals("X") && board[row+2][col].equals("X") && board[row+3][col].equals("X")) {
						win = "X";
					} else if (board[row][col].equals("O") && board[row+1][col].equals("O") && board[row+2][col].equals("O") && board[row+3][col].equals("O")) {
						win = "O";
					}
				}
			}
			// diagonal win checks
			for (int col=1;col<=4;col++) {
				if (!(win.equals(" "))) {	break;	}
				for (int row=1;row<=3;row++) {
					if (!(win.equals(" "))) {	break;	}
					if (board[row][col].equals("X") && board[row+1][col+1].equals("X") && board[row+2][col+2].equals("X") && board[row+3][col+3].equals("X")) {
						win = "X";
					} else if (board[row][col].equals("O") && board[row+1][col+1].equals("O") && board[row+2][col+2].equals("O") && board[row+3][col+3].equals("O")) {
						win = "O";
					}
				}
				for (int row=4;row<=6;row++) {
					if (!(win.equals(" "))) {	break;	}
					if (board[row][col].equals("X") && board[row-1][col+1].equals("X") && board[row-2][col+2].equals("X") && board[row-3][col+3].equals("X")) {
						win = "X";
					} else if (board[row][col].equals("O") && board[row-1][col+1].equals("O") && board[row-2][col+2].equals("O") && board[row-3][col+3].equals("O")) {
						win = "O";
					}
				}
			}
			if (win.equals("X")) {
				StdOut.println("X's WIN!");
				return;
			}
			if (win.equals("O")) {
				StdOut.println("O's WIN");
				return;
			}
			
		}
		StdOut.println("DRAW");
		
	}

}
