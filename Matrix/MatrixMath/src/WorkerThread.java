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
public class WorkerThread implements Runnable {

	/**
	 * 
	 */
	private int row;
	private int col;
	private int[][] A;
	private int[][] B;
	private int[][] C;

	public WorkerThread(int row, int col, int[][] A, int[][] B, int[][] C) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col = col;
		this.A = A;
		this.B = B;
		this.C = C;
	}

	public void run() {
		// calculate the matrix product in C[row] [col]
		for (int k = 0; k < B.length; k++) {
			C[row][col] = C[row][col] + A[row][k] * B[k][col];
		}

	}

}
