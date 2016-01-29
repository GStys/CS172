
public class TicTacToe {

	public static void main(String[] args) {
		String[][] board = new String[4][4];
		for (int i=1;i<4;i++) {
			for (int j=1;j<4;j++) {
				board[i][j] = "[]";
			}
		}
		System.out.println(board[1][1] + " | " + board[1][2] + " | " + board[1][3]);
		System.out.println("---|----|-----");
		System.out.println(board[2][1] + " | " + board[2][2] + " | " + board[2][3]);
		System.out.println("---|----|-----");
		System.out.println(board[3][1] + " | " + board[3][2] + " | " + board[3][3]);

	}

}
