package com.company;

public class MatrixInitialize {
    private int sizeOfMatrix;
    int[][] matrix;


    public MatrixInitialize(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;

        matrix = new int[5][5];
        int counter = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                matrix[i][j] = ++counter;
            }
        }
    }

    private static void initializeMatrix() {
        MatrixInitialize m = new MatrixInitialize(5);
        m.printMatrix();
        System.out.println();
        m.spiralSearch2();
    }

    public void printMatrix() {
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void spiralSearch(int startIndex, int endIndex) {

    int startCol = 0;
    int startRow = 0;

    int endCol = endIndex-1;
    int endRow = endIndex-1;

       for (int i=startCol; i<endCol ;i++){
           System.out.print(matrix[startCol][i] + " ");
       }

       for(int i = startRow; i<=endRow; i++){
           System.out.print(matrix[i][endRow] + " ");
       }

       for(int i=endCol-1; i>=startCol; i--){
           System.out.print(matrix[endRow][i] + " ");
       }
       for(int i=endRow-1; i>=startRow+1; i--){
           System.out.print(matrix[i][startCol] + " ");
       }

    }

    public  void spiralSearch2(){
        for(int i=0; i<sizeOfMatrix; i++){
            for(int j=0; j<sizeOfMatrix; j++){
                spiralSearch(i+1,j+1);
                System.out.println();
            }
            System.out.println();
        }
       // spiralSearch(1,4);
    }

    public static void main(String[] args) {
        initializeMatrix();

    }

}
