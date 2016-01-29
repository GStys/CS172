//Griffin Styslinger

public class HelloWorld {
	
	//2. Two of each primitive data type (byte, short, int, long, float, double, boolean, char)
	public static byte frank = 17, freddy = -98;
	public static short carl = -2, paul = 29956;
	public static int orange = 71, kevin = 10;
	public static long feng = 123456789, drop = -43;
	public static float rootbeer = 1.234567f, pi = 3.141592f;
	public static double scoop = 1.23456789012345, betterPi = 3.14159265358979;
	public static boolean quest = true, dead = false;
	public static char one = 'a', two = 'b';
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		//3. Change scoop to twice the value of betterPi
		scoop = 2*betterPi;
		
		//4. print scoop (should be ~6.283185)
		System.out.println(scoop);
		
		//5. use explicit type cast to convert the long feng into a double (should be 123456789.0)
		System.out.println((double) feng);
		
		//6. use explicit type cast to convert the double betterPi into a long (should be 3)
		System.out.println((long) betterPi);
		
		//7. code something that functions uniquely in java (parse a string to an int)
		kevin = Integer.parseInt("11");

		//8. copy-paste code from another program; this came from Quadratic.java (1.2.3 in the book)
		double b = (double) frank;
        double c = (double) orange;

        double discriminant = b*b - 4.0*c;
        double sqroot =  Math.sqrt(discriminant);

        double root1 = (-b + sqroot) / 2.0;
        double root2 = (-b - sqroot) / 2.0;

        System.out.println(root1);
        System.out.println(root2);
	}
}
