package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSpiral {
    private ArrayList<Integer> buffer;
    private int matrix[][];
    private  int matrixSize;
    FibonacciSpiral(int[][] matrix){
        this.matrix=matrix;
        matrixSize=matrix.length;
        buffer=new ArrayList<>();
        buffer.add(1);
        buffer.add(1);
    }
    public FibonacciSpiral(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter matrix size :");
        int matrixSize=scanner.nextInt();
        matrix= new int[matrixSize][matrixSize];
        for (int i = 0; i <matrixSize ; i++) {
            for (int j = 0; j <matrixSize ; j++) {
                System.out.print("Enter matrix["+i+"]["+j+"] :");
                matrix[i][j]=scanner.nextInt();
            }
        }
        buffer=new ArrayList<>();
        buffer.add(1);
        buffer.add(1);
    }
    boolean hasContourSpiral(ArrayList<Integer> contour){
        int maxElemContourIndex=0;
        for (int i = 1; i <contour.size() ; i++) {
            if(contour.get(i)>contour.get(maxElemContourIndex)){
                maxElemContourIndex=i;
            }
        }
        int maxElemFibBufferIndex= binarySearchFibonacciBuffer(contour.get(maxElemContourIndex));
        if(maxElemFibBufferIndex==-1)return false;
        int clockwiseIteration;
        for (clockwiseIteration = 1; clockwiseIteration < contour.size(); clockwiseIteration++) {

            if(!contour.get((maxElemContourIndex+clockwiseIteration)%contour.size()).equals(buffer.get(maxElemFibBufferIndex-clockwiseIteration)))break;
        }
        //if clockwiseIteration >1 then there won't be full fibonaci sequence iterated counter clockwise
        if(clockwiseIteration==1){
            int counterClockwiseIteration;
            for (counterClockwiseIteration = 1; counterClockwiseIteration <contour.size() ; counterClockwiseIteration++) {
                if(!contour.get((contour.size()+maxElemContourIndex-counterClockwiseIteration)%contour.size()).equals(buffer.get(maxElemFibBufferIndex-counterClockwiseIteration)))return false;

            }
            return counterClockwiseIteration==contour.size();
        }
        return clockwiseIteration==contour.size();
    }
    ArrayList<Integer> getContour(int startX, int startY, int subMatrixSize){
        ArrayList<Integer> contour=new ArrayList<>();
        //adds all top part contour elements of the submatrix
        for (int i = startY; i <startY+subMatrixSize ; i++) {
            contour.add(matrix[startX][i]);
        }
        //adds all right part contour elements of the submatrix
        for (int i = startX+1; i <startX+subMatrixSize ; i++) {
            contour.add(matrix[i][startY+subMatrixSize-1]);
        }
        //adds all bottom contour elements of the submatrix in opposite order
        for (int i = startY+subMatrixSize-2; i >=0 ; i--) {
            contour.add(matrix[startX+subMatrixSize-1][i]);
        }
        //adds all bottom contour elements of the submatrix in opposite order
        for (int i = startX+subMatrixSize-2; i >0 ; i--) {
            contour.add(matrix[i][startY]);
        }
        return contour;
    }
    private int binarySearchFibonacciBuffer(int candidate){
        if(candidate>buffer.get(buffer.size()-1)) fillBuffer(candidate);
        int start =0;
        int end= buffer.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(candidate== buffer.get(mid))return mid;
            else if (candidate < buffer.get(mid)) {
                end = mid-1;
            }
            else start=mid+1;
        }
        return -1;//if not found
    }
    boolean hasFibSpiral(){
        if(matrixSize<2)return false;
        for (int i = 0; i <matrixSize-1; i++) {
            for (int j = 0; j <matrixSize-1 ; j++) {
                int maxQuadraticSubMatrixSize=Math.min(matrixSize-i,matrixSize-j);
                for (int k = 2; k <=maxQuadraticSubMatrixSize ; k++) {

                    if(hasContourSpiral(getContour(i,j,k))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void fillBuffer(int upperBound){

        if(upperBound>= buffer.get(buffer.size()-1))
            while(upperBound>= buffer.get(buffer.size()-1)){
                int previousFibonacciNumber=buffer.get(buffer.size()-2);
                int currentFibonacciNumber=buffer.get(buffer.size()-1);
//                buffer.add(
//                        buffer.get(buffer.size()-1) +
//                                buffer.get(buffer.size()-2));
                buffer.add(previousFibonacciNumber+currentFibonacciNumber);
            }
        }
    }

