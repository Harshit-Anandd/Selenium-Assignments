import java.util.Scanner;

class MatrixOperations {

    // Method to add two matrices
    static void add(int[][] a, int[][] b, int n) {

        int[][] c = new int[n][n];

        // Adding corresponding elements
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = a[i][j] + b[i][j];

        print(c);
    }

    // Method to subtract matrices
    static void subtract(int[][] a, int[][] b, int n) {

        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = a[i][j] - b[i][j];

        print(c);
    }

    // Method to multiply matrices
    static void multiply(int[][] a, int[][] b, int n) {

        int[][] c = new int[n][n];

        // Matrix multiplication logic
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    c[i][j] += a[i][k] * b[k][j];

        print(c);
    }

    // Method to find transpose of matrix
    static void transpose(int[][] a, int n) {

        // Rows become columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[j][i] + " ");
            System.out.println();
        }
    }

    // Method to check identity matrix
    static boolean isIdentity(int[][] a, int n) {

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0))
                    return false;

        return true;
    }

    // Method to check diagonal matrix
    static boolean isDiagonal(int[][] a, int n) {

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && a[i][j] != 0)
                    return false;

        return true;
    }

    // Method to print matrix
    static void print(int[][] a) {

        for (int[] row : a) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Reading order of matrix
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];

        // Reading first matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        // Reading second matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[i][j] = sc.nextInt();

        add(a, b, n);
        subtract(a, b, n);
        multiply(a, b, n);
        transpose(a, n);

        System.out.println("Identity: " + isIdentity(a, n));
        System.out.println("Diagonal: " + isDiagonal(a, n));
    }
}