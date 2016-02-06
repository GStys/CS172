
public class C4Draw {
	
	public String[][] board;
	public String turn;
	public int tCount, r, c;
	public boolean win;

	public C4Draw() {
		board = new String[7][8];
		for (int i=1;i<7;i++) {
			for (int j=1;j<8;j++) {
				board[i][j] = " ";
			}
		}
		turn = "RED";
		tCount = 1;
		win = false;
	}
	
	public static boolean gameStart() {
		while (true) {
			StdOut.println();
			StdOut.println("Would you like to play a game?");
			String answer = StdIn.readString();
			if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				StdOut.println();
				StdOut.println("Well... fuck off then.");
				return false;
			}
			else if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
				StdOut.println();
				StdOut.println("Connect Four:");
				StdOut.println();
				return true;
			}
			else {
				StdOut.println();
				StdOut.println("'yes' or 'no', dumbass.");
				StdOut.println("Lets try this again...");
			}
		}
	}
	
	public void drawBoard() {
		//clears screen and draws board
		StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.clear(StdDraw.BLACK);
		for (double i=0.15;i<0.85;i+=0.1) {
			StdDraw.line(i, 0.1, i, 0.7);
		}
		for (double j=0.1;j<=0.7;j+=0.1) {
			StdDraw.line(0.15, j, 0.85, j);
		}
		for (int row=1;row<7;row++) {
			for (int col=1;col<8;col++) {
				if (board[row][col] == "RED") {
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledCircle((double) (col+1)/10, (double) (row+0.5)/10, 0.02);
				} else if (board[row][col] == "BLUE") {
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.filledCircle((double) (col+1)/10, (double) (row+0.5)/10, 0.02);
				}
			}
		}
	}
	
	public void getMove() {
		//player inputs column and board[][] value accordingly changed
		while (true) {
			StdOut.println("Which column?");
			int col = StdIn.readInt();
			if (!(board[6][col].equals(" "))) {
				StdOut.println("That column is filled.");
				StdOut.println("Lets try this again.\n");
				continue;
			}
			for (int row=1;row<7;row++) {
				if (board[row][col].equals(" ")) {
					r=row; c=col;
					board[r][c] = turn;
					return;
				}
			}
		}
	}
	
	public boolean checkWin() {
		//vertical win check
		if (r>=4) {
			if (board[r][c].equals(turn) && board[r-1][c].equals(turn) && board[r-2][c].equals(turn) && board[r-3][c].equals(turn)) {
				return true;
			}
		}
		
		//horizontal win check
		for (int col=1;col<=4;col++) {
			if (board[r][col].equals(turn) && board[r][col+1].equals(turn) && board[r][col+2].equals(turn) && board[r][col+3].equals(turn)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void play() {
		while (tCount<=42) {
			if (tCount%2 == 0) {	turn="BLUE";	}
			else {	turn="RED";	}
			StdOut.println(turn + "'s turn:");
			
			drawBoard();
			getMove();
			tCount++;
		}
	}

	public static void main(String[] args) {
		C4Draw game = new C4Draw();
		game.play();
	}

}
