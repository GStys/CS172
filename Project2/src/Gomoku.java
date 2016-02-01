
public class Gomoku {

	public static void main(String[] args) {
		
		String[][] board = new String[5][5];
		for (int i=1;i<5;i++) {
			for (int j=1;j<5;j++) {
				board[i][j] = "  ";
			}
		}
		
		// prints the current board
				StdOut.println("Col: 1   2   3   4  Row");
				StdOut.println("    " + board[1][1] + " | " + board[1][2] + "| " + board[1][3] + "| " + board[1][4] + "  1");
				StdOut.println("    " + "---|---|---|---");
				StdOut.println("    " + board[2][1] + " | " + board[2][2] + "| " + board[2][3] + "| " + board[2][4] + "  2");
				StdOut.println("    " + "---|---|---|---");
				StdOut.println("    " + board[3][1] + " | " + board[3][2] + "| " + board[3][3] + "| " + board[3][4] + "  3");
				StdOut.println("    " + "---|---|---|---");
				StdOut.println("    " + board[4][1] + " | " + board[4][2] + "| " + board[4][3] + "| " + board[4][4] + "  4");
				StdOut.println();
				
				for (int tCount=1;tCount<=16;tCount++) {
					
					// prints which turn it is
					if (tCount%2 == 0) {	StdOut.println("X's Turn:");	}
					else {	StdOut.println("O's Turn:");	}
					
					while (true) {
						//player inputs row and column of play and the board[][] value is accordingly changed
						StdOut.println("Which row?");
						int r = StdIn.readInt();
						StdOut.println("Which column?");
						int c = StdIn.readInt();
						if (board[r][c].equals("O") || board[r][c].equals("X")) {
							StdOut.println("That spot is filled.");
							StdOut.println("Try again when you figure out how to count to four.");
							continue;
						}
						if (tCount%2 == 0) { board[r][c] = "X";	}
						else {	board[r][c] = "O";	}
						break;
					}
					
					// prints the current board
					StdOut.println("Col: 1   2   3   4  Row");
					StdOut.println("    " + board[1][1] + " | " + board[1][2] + "| " + board[1][3] + "| " + board[1][4] + "  1");
					StdOut.println("    " + "---|---|---|---");
					StdOut.println("    " + board[2][1] + " | " + board[2][2] + "| " + board[2][3] + "| " + board[2][4] + "  2");
					StdOut.println("    " + "---|---|---|---");
					StdOut.println("    " + board[3][1] + " | " + board[3][2] + "| " + board[3][3] + "| " + board[3][4] + "  3");
					StdOut.println("    " + "---|---|---|---");
					StdOut.println("    " + board[4][1] + " | " + board[4][2] + "| " + board[4][3] + "| " + board[4][4] + "  4");
					StdOut.println();
					
				}

	}

}
