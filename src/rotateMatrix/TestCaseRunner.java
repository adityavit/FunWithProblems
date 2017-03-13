package rotateMatrix;

/**
 * Created by adib on 5/26/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int test1Matrix[][] = {{42}};
        System.out.println("Matrix before the rotate--");
        printMatrix(test1Matrix);
        sol.rotateMatrix(test1Matrix);
        System.out.println("Matrix after the rotate--");
        printMatrix(test1Matrix);

        int test2Matrix[][] = {{1,2},{3,4}};
        System.out.println("Matrix before the rotate--");
        printMatrix(test2Matrix);
        sol.rotateMatrix(test2Matrix);
        System.out.println("Matrix after the rotate--");
        printMatrix(test2Matrix);

        int test4Matrix[][] = {{1,2,3,4}, {5 , 6, 7, 8} ,{9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("Matrix before the rotate--");
        printMatrix(test4Matrix);
        sol.rotateMatrix(test4Matrix);
        System.out.println("Matrix after the rotate--");
        printMatrix(test4Matrix);

        int test5Matrix[][] = {{1,2,3,4,5}, {6, 7, 8, 9, 10} ,{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        System.out.println("Matrix before the rotate--");
        printMatrix(test5Matrix);
        sol.rotateMatrix(test5Matrix);
        System.out.println("Matrix after the rotate--");
        printMatrix(test5Matrix);
    }


    public static void printMatrix(int matrix[][]) {
        int matrixRowSize = matrix.length;
        int matrixColSize = 1;
        if(matrixRowSize > 0)
            matrixColSize = matrix[0].length;

        for(int i = 0; i < matrixRowSize; i++) {
            for(int j = 0; j < matrixColSize; j++) {
                System.out.print(matrix[i][j]+ ",");
            }
            System.out.println("");
        }
    }
}
