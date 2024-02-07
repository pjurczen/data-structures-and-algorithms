package com.pjurczen;

public class MatrixMultiplication {

    public int[][] multiply(int[][] X, int[][] Y) {
        int n = X.length;
        if (n == 1) {
            return new int[][]{{X[0][0] * Y[0][0]}};
        } else {
            int[][] A = subMatrix(X, 0, n / 2, 0, n / 2);
            int[][] B = subMatrix(X, 0, n / 2, n / 2, n);
            int[][] C = subMatrix(X, n / 2, n, 0, n / 2);
            int[][] D = subMatrix(X, n / 2, n, n / 2, n);

            int[][] E = subMatrix(Y, 0, n / 2, 0, n / 2);
            int[][] F = subMatrix(Y, 0, n / 2, n / 2, n);
            int[][] G = subMatrix(Y, n / 2, n, 0, n / 2);
            int[][] H = subMatrix(Y, n / 2, n, n / 2, n);

            var P1 = multiply(A, subtract(F, H));
            var P2 = multiply(add(A, B), H);
            var P3 = multiply(add(C, D), E);
            var P4 = multiply(D, subtract(G, E));
            var P5 = multiply(add(A, D), add(E, H));
            var P6 = multiply(subtract(B, D), add(G, H));
            var P7 = multiply(subtract(A, C), add(E, F));

            int[][] leftUpper = add(subtract(add(P5, P4), P2), P6);
            int[][] rightUpper = add(P1, P2);
            var horizontalPart1 = joinHorizontally(leftUpper, rightUpper);
            int[][] leftLower = add(P3, P4);
            int[][] rightLower = subtract(subtract(add(P1, P5), P3), P7);
            var horizontalPart2 = joinHorizontally(leftLower, rightLower);
            return joinVertically(horizontalPart1, horizontalPart2);
        }
    }

    public int[][] subMatrix(int[][] input, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        final int[][] result = new int[rowEnd - rowStart][columnEnd - columnStart];
        for (int i = rowStart, r = 0; i < rowEnd; i++, r++) {
            for (int j = columnStart, c = 0; j < columnEnd; j++, c++) {
                result[r][c] = input[i][j];
            }
        }
        return result;
    }

    private int[][] subtract(int[][] X, int[][] Y) {
        int n = X.length;
        final int[][] result = new int[n][Y.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = X[i][j] - Y[i][j];
            }
        }
        return result;
    }

    private int[][] add(int[][] X, int[][] Y) {
        int n = X.length;
        final int[][] result = new int[n][Y.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = X[i][j] + Y[i][j];
            }
        }
        return result;
    }

    private int[][] joinHorizontally(int[][] X, int[][] Y) {
        int n = X.length;
        int[][] result = new int[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = X[i][j];
            }
            for (int j = n, c = 0; j < 2 * n; j++, c++) {
                result[i][j] = Y[i][c];
            }
        }
        return result;
    }

    private int[][] joinVertically(int[][] X, int[][] Y) {
        int xColumns = X[0].length;
        int xRows = X.length;
        int[][] result = new int[2 * xRows][xColumns];
        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < xColumns; j++) {
                result[i][j] = X[i][j];
            }
        }
        int yColumns = Y[0].length;
        int yRows = Y.length;
        for (int i = xRows, r = 0; r < yRows; i++, r++) {
            for (int j = 0; j < yColumns; j++) {
                result[i][j] = Y[r][j];
            }
        }
        return result;
    }
}
