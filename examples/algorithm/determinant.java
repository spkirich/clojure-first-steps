// Определитель матрицы с помощью метода Гаусса

public class Matrix {
    private static double EPS = 1e-6;

    private static double[][] swap_row(double[][] matrix, int row1, int row2) {
        double[] tmp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tmp;
        return matrix;
    }

    private static int pivot_row(double[][] matrix, int i) {
        int pivot_row = i;
        for (int row = i + 1; row < matrix.length; ++row)
            if (Math.abs(matrix[row][i]) > Math.abs(matrix[pivot_row][i]))
            pivot_row = row;
        return pivot_row;
    }

    public static double determinant(double[][] matrix) {
        int len = matrix.length;
        double det = 1;

        for (int i = 0; i < len; ++i) {
            int pivot_row = pivot_row(matrix, i);

            if (Math.abs(matrix[pivot_row][i]) < EPS) {
                det = 0;
                break;
            }

            if (i != pivot_row) {
                matrix = swap_row(matrix, i, pivot_row);
                det *= -1.0;
            }
            det *= matrix[i][i];

            double pivot =  matrix[i][i];
            for (int j = i + 1; j < len; ++j)
                matrix[i][j] /= pivot;

            for (int row = 0; row < len; ++row)
                if (row != i && Math.abs(matrix[row][i]) > EPS)
                    for (int col = i + 1; col < len; ++col)
                        matrix[row][col] -= matrix[row][i] * matrix[i][col];
        }

        return det;
    }
}
