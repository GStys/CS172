
public class Exercises {

	public Exercises() {
		// TODO Auto-generated constructor stub
	}
	
	public static void circleDiagonals(int N, double p, boolean s) {
		/*
		 * 1.5.19:
		 * 		Write a program that takes, as command-line arguments, an 
		 * 		integer N, and a double value p (between 0 and 1), plots N 
		 * 		equally spaced points of size on the circumference of a 
		 * 		circle, and then, with probability p for each pair of 
		 * 		points, draws a gray line connecting them.
		 * 		
		 * 		-- dotted circle centered at (0.5, 0.5) with radius 0.2
		 */
		
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.00001);
		
		double spin = 0;
		
		while (StdDraw.mousePressed() == false) {
			StdDraw.clear(StdDraw.BLACK);
			for (int i=0;i<N;i++) {
				double ix = 0.5 + (0.45*Math.cos(spin + 2*Math.PI*i/N));
				double iy = 0.5 + (0.45*Math.sin(spin + 2*Math.PI*i/N));
				if (p<1) {	StdDraw.filledCircle(ix, iy, 0.005);	}
				for (int j=i;j<N;j++) {
					if ((Math.random()*100) < (p*100)) {
						double jx = 0.5 + (0.45*Math.cos(-spin + 2*Math.PI*j/N));
						double jy = 0.5 + (0.45*Math.sin(-spin + 2*Math.PI*j/N));
						StdDraw.line(ix, iy, jx, jy);
					}
				}
			}
			if (s) {	spin += Math.PI/32;	}
			StdDraw.show(20);
		}
	}
	
	public static void bouncingBallGrav() {
		/*
		 * 1.5.35: Bouncing ball with gravity
		 * 		Modify BouncingBall to incorporate gravity in the vertical 
		 * 		direction. Add calls to StdAudio.play() to add one sound 
		 * 		effect when the ball hits a wall and a different one when 
		 * 		it hits the floor.
		 * 
		 * 		note: ball bounces in a vacuum world with no friction
		 */
		
		// set the scale of the coordinate system
		StdDraw.setCanvasSize(1500, 1000);
        StdDraw.setXscale(-1.0, 2);
        StdDraw.setYscale(-1.0, 1.0);

        // initial values
        double rx = -0.480, ry = -0.160;     // position
        double vx = 0.025, vy = 0.023;     // velocity
        double radius = 0.075;              // radius
        double spin = 0;

        // main animation loop
        while (true) {
            // bounce off wall according to law of elastic collision
            if ((rx < -0.96 + radius) || (rx > 1.96 - radius)) {	vx = -vx; spin = 0;	}
            if (Math.abs(ry) > 0.9 - radius) {	vy = -vy;	}
            else {
                /*
                 * update vertical velocity based on:
                 * g == -9.81 m/s/s and 1.0 == 1 m and t == 0.02 s
                 * V(final) == V(initial) + g*t
                 */
                vy = vy - (9.81*0.02*0.02);
            }
            
            if (vx > 0) {	spin -= vx/radius;	}
            else {	spin += vx/radius;	}

            // update position
            rx = rx + vx; 
            ry = ry + vy; 

            // clear the background
            StdDraw.clear(StdDraw.BLACK);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.WHITE); 
            //StdDraw.filledCircle(rx, ry, radius); 
            StdDraw.setPenRadius(0.002);
    		
    		for (int i=0;i<8;i++) {
    			double ix = rx + (radius*Math.cos(spin + (2*Math.PI*i/8)));
    			double iy = ry + (radius*Math.sin(spin + (2*Math.PI*i/8)));
    			//StdDraw.filledCircle(ix, iy, 0.05);
    			for (int j=i;j<8;j++) {
					double jx = rx + (radius*Math.cos(spin + (2*Math.PI*j/8)));
					double jy = ry + (radius*Math.sin(spin + (2*Math.PI*j/8)));
					StdDraw.line(ix, iy, jx, jy);
    			}
    		}

            // display and pause for 20 ms
            StdDraw.show(20); 
        }
        
	}

	public static void main(String[] args) {
		
		circleDiagonals(StdIn.readInt(), 1, true);
		bouncingBallGrav();
		
	}

}
