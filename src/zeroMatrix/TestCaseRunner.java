package zeroMatrix;
/**
 * Created by adib on 5/30/16.
 */
public class TestCaseRunner {

    public static void main(String args[]) {
        Solution sol = new Solution();
        int[][] test2Matrix = {{1,3},{2,0}};
        int[][] test2MatrixResult = {{1,0},{0,0}};
        sol.makeZeroMatrix(test2Matrix);
        rotateMatrix.TestCaseRunner.printMatrix(test2Matrix);
        assert isMatrixEqual(test2Matrix, test2MatrixResult);

        int test4Matrix[][] = {{1,0, 2, 6}, {3, 0, 0, 7} ,{0, 4, 15, 8}, {13, 14, 15, 16}};
        sol.makeZeroMatrix(test4Matrix);
        rotateMatrix.TestCaseRunner.printMatrix(test4Matrix);

        int[][] a = new int[0][3];

        rotateMatrix.TestCaseRunner.printMatrix(a);
    }

    private static boolean isMatrixEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null && matrix2 == null)
            return true;
        if (matrix1 == null || matrix2 == null)
            return false;

        if (matrix1.length != matrix2.length)
            return false;
        if (matrix1[0] != null && matrix2[0] != null) {
            if (matrix1[0].length != matrix2[0].length) {
                return false;
            }
        }
        int rowSize = matrix1.length;
        int colSize = matrix1[0].length;

        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix1[i][j] != matrix2[i][j])
                    return false;
            }
        }

        return true;
    }
}
