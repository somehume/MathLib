/**
 * 
 */

/**
 * 
 * @author Donald Brown
 * @course	COSC519:Operating Systems
 * @professor Dr. Ziying Tang
 */
import java.util.Scanner;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] A, B, C;
		int test = 0;
		int ar = test, ac = test, br = test, bc = test;
		Scanner sc = new Scanner(System.in);
		

		Matrix m = new Matrix();

		System.out.println("MATRIX MULTIPLIER \n     Donald Brown\n");

		System.out.println("Matrix A\nHow many rows?");
		ar = sc.nextInt();
		System.out.println("Matrix A\nHow many columns?");
		ac = sc.nextInt();
		System.out.println("Matrix B\nHow many rows?");
		br = sc.nextInt();
		System.out.println("Matrix B\nHow many columns?");
		bc = sc.nextInt();

		//long sTime = System.nanoTime();
		A = new int[ar][ac];
		B = new int[br][bc];

		A = m.constructMatrix(ar, ac);
		B = m.constructMatrix(br, bc);
		
		long sTime = System.nanoTime();
		C = m.multiplyMatrix(A, B);
		long eTime = System.nanoTime();
		

		if (C != null)
			m.displayMatrix(C);
		System.out.println("Total Calculation Time: " + (eTime - sTime + " ns"));
		//long eTime = System.nanoTime();


	}

}
