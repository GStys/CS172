
public class C4Draw {
	
	public String[][] board;
	public String turn;
	public int tCount, r, c;
	public boolean win;
	public double x,y;
	public double winX1,winX2,winY1,winY2;

	public C4Draw() {
		board = new String[7][8];
		for (int i=0;i<7;i++) {
			for (int j=0;j<8;j++) {
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
		if (!win) {	StdDraw.text(0.2, 0.8, turn + "'s turn:");	}
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
		if (win==true) {
			StdDraw.text(0.4, 0.8, turn + " WINS!!!");
			StdDraw.setPenColor(StdDraw.YELLOW);
			if (board[r][c] == "RED") {
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.filledCircle((double) (c+1)/10, (double) (r+0.5)/10, 0.02);
			} else if (board[r][c] == "BLUE") {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledCircle((double) (c+1)/10, (double) (r+0.5)/10, 0.02);
			}
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.line(winX1, winY1, winX2, winY2);
			return;
		}
	}
	
	public void getMove() {
		//player inputs column and board[][] value accordingly changed
		while (true) {
			if (StdDraw.mousePressed()==false) break;
		}
		while (true) {
			int col=0;
			if (StdDraw.mousePressed()) {
				x = StdDraw.mouseX();
				y = StdDraw.mouseY();
				if (x>0.15 && x<0.85 && y>0.1 && y<0.7) {
					if (x<0.25) {	col=1;	}
					else if (x<0.35) {	col=2;	}
					else if (x<0.45) {	col=3;	}
					else if (x<0.55) {	col=4;	}
					else if (x<0.65) {	col=5;	}
					else if (x<0.75) {	col=6;	}
					else {	col=7;	}
				}
				if (col>0 && !(board[6][col].equals(" "))) {
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
	}
	
	public void checkWin() {
		//vertical win check
		if (r>=4) {
			if (board[r][c].equals(turn) && board[r-1][c].equals(turn) && board[r-2][c].equals(turn) && board[r-3][c].equals(turn)) {
				winX1=(double) (c+1)/10; winY1=(double) (r+0.75)/10; winX2=(double) (c+1)/10; winY2=(double) (r-2.75)/10;
				win = true;
				return;
			}
		}
		
		//horizontal win check
		for (int col=1;col<=4;col++) {
			if (board[r][col].equals(turn) && board[r][col+1].equals(turn) && board[r][col+2].equals(turn) && board[r][col+3].equals(turn)) {
				winX1=(double) (col+0.75)/10; winY1=(double) (r+0.5)/10; winX2=(double) (col+4.25)/10; winY2=(double) (r+0.5)/10;
				win = true;
				return;
			}
		}

		// diagonal win checks
		for (int col=1;col<=4;col++) {
			for (int row=1;row<=3;row++) {
				if (board[row][col].equals(turn) && board[row+1][col+1].equals(turn) && board[row+2][col+2].equals(turn) && board[row+3][col+3].equals(turn)) {
					winX1=(double) (col+0.75)/10; winY1=(double) (row+0.25)/10; winX2=(double) (col+4.25)/10; winY2=(double) (row+3.75)/10;
					win = true;
					return;
				}
			}
			for (int row=4;row<=6;row++) {
				if (board[row][col].equals(turn) && board[row-1][col+1].equals(turn) && board[row-2][col+2].equals(turn) && board[row-3][col+3].equals(turn)) {
					winX1=(double) (col+0.75)/10; winY1=(double) (row+0.75)/10; winX2=(double) (col+4.25)/10; winY2=(double) (row-2.75)/10;
					win = true;
					return;
				} 
			}
		}
	}
	
	public void play() {
		drawBoard();
		while (tCount<=42) {
			if (tCount%2 == 0) {	turn="BLUE";	}
			else {	turn="RED";	}
			StdOut.println("\nTurn " + tCount);
			StdOut.println(turn + "'s turn:");
			
			getMove();
			checkWin();
			drawBoard();
			if (win==true) break;
			tCount++;
		}
		drawBoard();
	}

	public static void main(String[] args) {
		C4Draw game = new C4Draw();
		game.play();
	}

}
