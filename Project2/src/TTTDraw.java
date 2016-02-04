
public class TTTDraw {
	
	public static String[][] board;
	public static String turn;
	public static int tCount, r, c;
	public static boolean win;
	
	public TTTDraw() {
		board = new String[4][4];
		for (int i=1;i<4;i++) {
			for (int j=1;j<4;j++) {
				board[i][j] = " ";
			}
		}
		turn = "X";
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
				StdOut.println("Tic Tac Toe:");
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
	
	public void board() {
		//clears screen and draws board
		StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.clear(StdDraw.BLACK);
        StdDraw.line(0.2, 0.6, 0.8, 0.6);
        StdDraw.line(0.2, 0.4, 0.8, 0.4);
        StdDraw.line(0.4, 0.8, 0.4, 0.2);
        StdDraw.line(0.6, 0.8, 0.6, 0.2);
        for (int i=1;i<4;i++) {
        	for (int j=1;j<4;j++) {
        		placeMove(i,j);
        	}
        }
	}
	
	public void getMove() {
		//player inputs row and column of play and the board[][] value is accordingly changed
		int tempR=0, tempC=0;
		while (true) {
			if (StdDraw.mousePressed()) {
				if ((StdDraw.mouseY() > 0.2) && (StdDraw.mouseY() < 0.8) && (StdDraw.mouseX() > 0.2) && (StdDraw.mouseX() < 0.8)) {
					
					if (StdDraw.mouseY() < 0.4) {	tempR=1;	}
					else if (StdDraw.mouseY() < 0.6) {	tempR=2;	}
					else {	tempR=3;	}
					
					if (StdDraw.mouseX() < 0.4) {	tempC=1;	}
					else if (StdDraw.mouseX() < 0.6) {	tempC=2;	}
					else {	tempC=3;	}
					
					if (board[tempR][tempC].equals(" ")) {
						StdOut.println("Turn " + tCount);
						r = tempR; c = tempC;
						board[r][c] = turn;
						return;
					} else if (!(r==tempR) && !(c==tempC)) {
						StdOut.println(board[r][c] + "\n r=" + r + "\n c=" + c);
						StdOut.println("That spot is filled.");
					}
				}
			}
		}
	}
	
	public void placeMove(double col, double row) {
		if (board[(int) row][(int) col].equals("X")) {
			StdDraw.line((col*2+0.5)/10, (row*2+1.5)/10, (col*2+1.5)/10, (row*2+0.5)/10);
			StdDraw.line((col*2+0.5)/10, (row*2+0.5)/10, (col*2+1.5)/10, (row*2+1.5)/10);
			StdOut.println("placed 'X': " + "col " + col + ", row " + row);
		} else if (board[(int) row][(int) col].equals("O")) {
			StdDraw.circle((col*2+1)/10, (row*2+1)/10, 0.06);
			StdOut.println("placed 'O': " + "col " + col + ", row " + row);
		}
	}
	
	public boolean checkWin() {
		double col=c,row=r;
		if (board[r][1].equals(turn) && board[r][2].equals(turn) && board[r][3].equals(turn)) {
			if (win==true) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.line(0.23, (row*2+1)/10, 0.78, (row*2+1)/10);
			}
			return true;
		}
		if (board[1][c].equals(turn) && board[2][c].equals(turn) && board[3][c].equals(turn)) {
			if (win==true) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.line((col*2+1)/10, 0.23, (col*2+1)/10, 0.78);
			}
			return true;
		}
		if (board[1][1].equals(turn) && board[2][2].equals(turn) && board[3][3].equals(turn)) {
			if (win==true) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.line(0.23, 0.23, 0.78, 0.78);
			}
			return true;
		}
		if (board[1][3].equals(turn) && board[2][2].equals(turn) && board[3][1].equals(turn)) {
			if (win==true) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.line(0.2, 0.8, 0.8, 0.2);
			}
			return true;
		}
		return false;
	}
	
	public void play() {
        board();
        
		while (tCount<=9) {
			
        	board();
        	if (win==true) {
        		StdDraw.text(0.5, 0.85, turn + "s WIN!!!");
        		checkWin();
        		StdDraw.show();
        		return;
        	}
        	
        	// checks whose turn it is
        	if (tCount%2 == 0) {	turn = "O";	}
        	else {	turn = "X";	}
        	
            StdDraw.text(0.1, 0.9, turn + "'s Turn:");
        	getMove();
        	win = checkWin();
        	tCount++;
        }
    	board();
		StdDraw.text(0.4, 0.9, "DRAW");
	}

	public static void main(String[] args) {
		
		TTTDraw game = new TTTDraw();
        game.play();

	}

}
