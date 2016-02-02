
public class Gomoku {

	public static void main(String[] args) {
		
		String[][] board = new String[5][5];
		for (int i=1;i<5;i++) {
			for (int j=1;j<5;j++) {
				board[i][j] = " ";
			}
		}
		
		// prints the current board
		StdOut.println("Col: 1   2   3   4  \nRow");
		StdOut.println(" 1   " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4]);
		StdOut.println("    ---|---|---|---");
		StdOut.println(" 2   " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4]);
		StdOut.println("    ---|---|---|---");
		StdOut.println(" 3   " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4]);
		StdOut.println("    ---|---|---|---");
		StdOut.println(" 4   " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4]);
		StdOut.println();
		
		for (int tCount=1;tCount<=16;tCount++) {

			int r,c;
			String turn;
			if (tCount%2 == 0) {	turn = "X";	}
			else {	turn = "O";	}
			
			// prints which turn it is
			StdOut.println(turn + "'s turn:");
			
			while (true) {
				//player inputs row and column of play and the board[][] value is accordingly changed
				StdOut.println("Which row?");
				StdOut.println();
				r = StdIn.readInt();
				StdOut.println("Which column?");
				StdOut.println();
				c = StdIn.readInt();
				if (!board[r][c].equals(" ")) {
					StdOut.println("That spot is filled.");
					StdOut.println("Try again when you figure out how to count to four.");
					continue;
				}
				board[r][c] = turn;
				break;
			}
			
			// prints the current board
			StdOut.println();
			StdOut.println();
			StdOut.println("Col: 1   2   3   4  \nRow");
			StdOut.println(" 1   " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4]);
			StdOut.println("    ---|---|---|---");
			StdOut.println(" 2   " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4]);
			StdOut.println("    ---|---|---|---");
			StdOut.println(" 3   " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4]);
			StdOut.println("    ---|---|---|---");
			StdOut.println(" 4   " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4]);
			StdOut.println();
			StdOut.println();
			StdOut.println();
			
			// checks for win
			if (board[1][c].equals(turn) && board[2][c].equals(turn) && board[3][c].equals(turn) && board[4][c].equals(turn)) {
				StdOut.println(turn + "s WIN!!!");
				return;
			} else if (board[r][1].equals(turn) && board[r][2].equals(turn) && board[r][3].equals(turn) && board[r][4].equals(turn)) {
				StdOut.println(turn + "s WIN!!!");
				return;
			} else if (board[1][1].equals(turn) && board[2][2].equals(turn) && board[3][3].equals(turn) && board[4][4].equals(turn)) {
				StdOut.println(turn + "s WIN!!!");
				return;
			} else if (board[1][4].equals(turn) && board[2][3].equals(turn) && board[3][2].equals(turn) && board[4][1].equals(turn)) {
				StdOut.println(turn + "s WIN!!!");
				return;
			}
			
		}
		StdOut.println("DRAW");

	}

}
