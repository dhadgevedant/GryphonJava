public class MatrixArithmatic {

    // Matrix Addition
    public static int[][] add(int[][] matrixA, int[][] matrixB) {
        int[][] sumMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sumMatrix;
    }

    // Matrix Subtraction
    public static int[][] subtract(int[][] matrixA, int[][] matrixB) {
        int[][] diffMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                diffMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return diffMatrix;
    }

    // Matrix Multiplication
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] productMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return productMatrix;
    }

    // Display Matrix
    public static void printMatrix(int[][] matrix, String label) {
        System.out.println(label);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] sumMatrix = add(matrixA, matrixB);
        int[][] diffMatrix = subtract(matrixA, matrixB);
        int[][] productMatrix = multiply(matrixA, matrixB);

        printMatrix(sumMatrix, "Sum of Matrix A and B:");
        printMatrix(diffMatrix, "Difference of Matrix A and B:");
        printMatrix(productMatrix, "Product of Matrix A and B:");
    }
}
