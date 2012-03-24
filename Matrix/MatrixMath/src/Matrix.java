/**
 * 
 */

/**
 * 
 * @author Donald Brown
 * @course	COSC519:Operating Systems
 * @professor Dr. Ziying Tang
 *
 */

import java.util.Random;

public class Matrix {

	/**
	 * 
	 */
	public Matrix() {
		// TODO Auto-generated constructor stub

	}

	public int[][] constructMatrix(int r, int c) {
		int[][] mtrx = new int[r][c];
		Random gen = new Random(System.currentTimeMillis());

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mtrx[i][j] = gen.nextInt(10);
			}
		}

		return mtrx;
	}

	public void displayMatrix(int[][] M) {
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j] + "\t");
			}
			System.out.print("\n");
		}

	}

	public int[][] multiplyMatrix(int[][] A, int[][] B) {
		int[][] C = new int[1][1];

		if (A[1].length == B.length) {
			System.out.println("Matrix Product:");
			C = new int[A.length][B[0].length];
			// int count = 0;
			// long sTime = System.nanoTime();
			for (int i = 0; i < C.length; i++) {
				for (int j = 0; j < C[0].length; j++) {
					/*
					 * for (int k = 0; k < B.length; k++) { C[i][j] = C[i][j] +
					 * A[i][k] * B[k][j]; }
					 */

					Thread thrd = new Thread(new WorkerThread(i, j, A, B, C));
					thrd.start();
					try {
						thrd.join();
						// System.out.println("Matrix Product:");
					} catch (InterruptedException ie) {
					}

					// count++;
				}
			}
			// long eTime = System.nanoTime();
			// System.out.println("Count: " + count);
			// System.out.println("Total Calculation Time: " + (eTime - sTime +
			// " ns"));

		} else {
			System.out.print("The input matrices cannot be multiplied.");
			return null;
		}

		return C;

	}

}
