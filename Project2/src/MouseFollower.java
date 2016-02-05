/******************************************************************************
 *  Compilation:  javac MouseFollower.java
 *  Execution:    java MouseFollower
 *  Dependencies: StdDraw.java
 *
 *  Draw a blue filled circle wherever the mouse is, in cyan if the
 *  mouse is pressed.
 *
 *
 *  % java MouseFollower
 *
 *  Credits:  Jeff Traer-Bernstein
 *
 ******************************************************************************/


public class MouseFollower {
    public static void main(String[] args) {
        while (true) {

            // mouse click
            if (StdDraw.mousePressed()) StdDraw.setPenColor(StdDraw.CYAN);
            else                        StdDraw.setPenColor(StdDraw.BLUE);

            // mouse location
            StdDraw.clear();
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            if (StdDraw.getPenColor() == StdDraw.CYAN) {
            	for (double i=0.01;i<=0.05;i+=0.01) {
            		StdDraw.circle(x, y, i);
            		StdDraw.show(30);
            	}
            }
            else {
                StdDraw.circle(x, y, .05);
            }
            StdDraw.show(10);
        }
    }
}
