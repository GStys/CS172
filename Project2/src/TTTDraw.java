
public class TTTDraw {
	
	public static void board() {
		//Draw Board
        StdDraw.line(0.2, 0.6, 0.8, 0.6);
        StdDraw.line(0.2, 0.4, 0.8, 0.4);
        StdDraw.line(0.4, 0.8, 0.4, 0.2);
        StdDraw.line(0.6, 0.8, 0.6, 0.2);
	}
	
	public static void drawX(double col, double row) {
		StdDraw.line((col*2+0.5)/10, (row*2+1.5)/10, (col*2+1.5)/10, (row*2+0.5)/10);
		StdDraw.line((col*2+0.5)/10, (row*2+0.5)/10, (col*2+1.5)/10, (row*2+1.5)/10);
	}

	public static void main(String[] args) {
		
		StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLACK);
        board();
        drawX(1,1);
        
        

	}

}
