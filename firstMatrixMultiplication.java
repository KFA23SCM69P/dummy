package CS402;
import java.util.Random;
public class firstMatrixMultiplication {
	  public static void main(String[] args) {
	        int rowsA = 1000;
	        int colsA = 1000;
	        int colsB = 1000;

	        int[][] matrixA = generateRandomIntMatrix(rowsA, colsA);
	        int[][] matrixB = generateRandomIntMatrix(colsA, colsB);

	        long startTime = System.nanoTime();
	        int[][] resultInt = multiplyIntMatrices(matrixA, matrixB);
	        long endTime = System.nanoTime();

	        double durationInt = (endTime - startTime)/1000000000.0;
	        System.out.println("Integer Matrix Multiplication Time Is : " + durationInt + " seconds");

	        double[][] matrixADouble = generateRandomDoubleMatrix(rowsA, colsA);
	        double[][] matrixBDouble = generateRandomDoubleMatrix(colsA, colsB);

	        startTime = System.nanoTime();
	        double[][] resultDouble = multiplyDoubleMatrices(matrixADouble, matrixBDouble);
	        endTime = System.nanoTime();

	        double durationDouble = (endTime - startTime)/1000000000.0;
	        System.out.println("Double Matrix Multiplication Time Is: " + durationDouble + " seconds");
	    }

	    

	    public static double[][] generateRandomDoubleMatrix(int rows, int cols) {
	        Random random = new Random();
	        double[][] matrix = new double[rows][cols];
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                matrix[i][j] = random.nextDouble() * 1000.0; // Change range as needed
	            }
	        }
	        return matrix;
	    }


	    public static double[][] multiplyDoubleMatrices(double[][] A, double[][] B) {
	        int rowsA = A.length;
	        int colsA = A[0].length;
	        int colsB = B[0].length;
	        double[][] result = new double[rowsA][colsB];

	        for (int i = 0; i < rowsA; i++) {
	            for (int j = 0; j < colsB; j++) {
	                for (int k = 0; k < colsA; k++) {
	                    result[i][j] += A[i][k] * B[k][j];
	                }
	            }
	        }

	        return result;
	    }
	    public static int[][] multiplyIntMatrices(int[][] A, int[][] B) {
	        int rowsA = A.length;
	        int colsA = A[0].length;
	        int colsB = B[0].length;
	        int[][] result = new int[rowsA][colsB];

	        for (int i = 0; i < rowsA; i++) {
	            for (int j = 0; j < colsB; j++) {
	                for (int k = 0; k < colsA; k++) {
	                    result[i][j] += A[i][k] * B[k][j];
	                }
	            }
	        }

	        return result;
	    }
	    public static int[][] generateRandomIntMatrix(int rows, int cols) {
	        Random random = new Random();
	        int[][] matrix = new int[rows][cols];
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                matrix[i][j] = random.nextInt(1000); // Change range as needed
	            }
	        }
	        return matrix;
	    }

}
