public class SegundoMetodo {

    public static void llenarMatrix(int[][] matrix, int rows, int columns){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 999);
            }
        }
    }

    public static void multiplicarNaivOnArray(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Result[i][j] = 0;
                for (int k = 0; k < P; k++) {
                    Result[i][j] += A[i][k] * B[k][j];
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
        multiplicarNaivOnArray(a,b,result,rows,p,columns);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + (elapsedTime / 1000000) + " milisegundos");


    }
}