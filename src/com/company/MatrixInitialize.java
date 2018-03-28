package com.company;

public class MatrixInitialize {
    private int sizeOfMatrix;
    int[][] matrix;


    public MatrixInitialize(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;

        matrix = new int[5][5];
        int counter = 0;
        for(int i=0 ;i< sizeOfMatrix; i++){
            for(int j=0; j<sizeOfMatrix; j++){
                matrix[i][j] = ++counter;
            }
        }
    }

    private static void initializeMatrix() {
        MatrixInitialize m = new MatrixInitialize(5);
        m.printMatrix();
    }

   public void printMatrix(){
       for(int i=0 ;i< sizeOfMatrix; i++){
           for(int j=0; j<sizeOfMatrix; j++){
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }

    public static void main(String[] args) {
        initializeMatrix();
    }
    
}
