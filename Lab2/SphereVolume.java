import java.util.Scanner;

public class SphereVolume {
	public static void main(String[] args) {
		// Variables
		Scanner scanner = new Scanner(System.in);
		double diameter;
		double volume;
		double radius;
		
		// Tutorial
		System.out.println("Below you will be prompted to enter a few details, so that this program can calculate the volume of a sphere.");
		
		// Diameter
		System.out.println("Please enter the diameter of your sphere: ");
		diameter = scanner.nextDouble();
		
		// Radius
		radius = (diameter > 0) ? diameter / 2 : 0;
		
		// Volume
		volume = (diameter > 0 && radius > 0) ? (float)(4.0 / 3) * Math.PI * Math.pow(radius, 3) : 0;
		
		// Output
		System.out.println("Calculated volume is " + volume);
	}
}
