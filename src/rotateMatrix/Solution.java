package rotateMatrix;

/**
 * Created by adib on 5/25/16.
 */
public class Solution {

    /**
     * This function rotates the matrix counter clockwise by 90
     * @param matrix
     */
    public void rotateMatrix(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        int originIndex = 0;
        int matrixRowLength = matrix.length;
        if(matrixRowLength == 0) {
            return;
        }
        int matrixColLength = matrix[0].length;
        //Assert is a square matrix
        assert matrixRowLength == matrixColLength;

        rotateMatrixRecursiveHelper(matrix, matrixRowLength, originIndex);
    }

    private void rotateMatrixRecursiveHelper(int[][] matrix, int matrixSize, int originIndex) {
        //Cannot rotate a matrix of size of 1 or 0
        if(matrixSize == 1 || matrixSize == 0) {
            return;
        }
        int matrixLastIndex = originIndex + matrixSize - 1;
//        System.out.println("At the originIndex " + originIndex);
//        TestCaseRunner.printMatrix(matrix);
        for(int x = 0; x < matrixSize - 1 ; x++) {
            //swap all the four items on each of the edges of the square.
            // {originIndex + x , originIndex} , {originIndex, matrixLastIndex - x} , {matrixLastIndex - x , matrixLastIndex} , {matrixLastIndex, originIndex + x}
            swap(matrix, originIndex + x , originIndex, originIndex, matrixLastIndex - x);
            swap(matrix, originIndex, matrixLastIndex - x, matrixLastIndex - x , matrixLastIndex);
            swap(matrix, matrixLastIndex - x , matrixLastIndex, matrixLastIndex, originIndex + x);
        }
        rotateMatrixRecursiveHelper(matrix, matrixSize - 2, originIndex + 1);
    }

    private void swap(int[][]matrix , int aR, int aC, int bR, int bC) {
        int temp = matrix[aR][aC];
        matrix[aR][aC] = matrix[bR][bC];
        matrix[bR][bC] = temp;
    }

    /**
     * Creates a thread for each cell rotation in a square.
     * So for 4*4 matrix will create 3 threads.
     * @param matrix
     */
    public void threadedRotateMatrix(int[][] matrix) {
    //TODO Compelete this.
    }
}
