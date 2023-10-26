public class CuartoMetodo {

    public static void llenarMatrix(int[][] matrix, int rows, int columns){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 999);
            }
        }
    }

    public static void multiplicarNaivLoopUnrollingTwo(int[][] A, int[][] B, int[][] Result, int N, int P, int M)
    {
        int i, j, k;
        int aux;
        if (P % 2 == 0) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < P; k += 2) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j];
                    }
                    Result[i][j] = aux;
                }
            }
        } else {
            int PP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 2) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j];
                }
            }
        }
    }

//    public static void printMatrix(int[][] matrix) {
//        for (int[] row : matrix) {
//            for (int num : row) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        int rows = 4096;
        int columns = 4096;
        int p = rows;
        int[][] a = new int[rows][columns];
        int[][] b = new int[rows][columns] ;
        int[][] result = new int[rows][columns];


        llenarMatrix(a,rows,columns);
        llenarMatrix(b,rows,columns);

//        System.out.println("\nMatrix A:\n");
//        printMatrix(a);
//        System.out.println("\nMatrix B:\n");
//        printMatrix(b);

        long startTime = System.nanoTime();
        multiplicarNaivLoopUnrollingTwo(a,b,result,rows,p,columns);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + (elapsedTime / 1000000) + " milisegundos");
    }
}
