package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private int sizeOfMatrix;
    int[][] matrix;


    public Main(int sizeOfMatrix) {
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
        Main m = new Main(5);
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
        FibChecker fibChecker=new FibChecker();
        System.out.println(fibChecker.hasSpiral());
    }

}
