package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSpiral {
    private ArrayList<Integer> buffer;
    private int matrix[][];
    private  int matrixSize;
    public FibonacciSpiral(int[][] matrix){
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
        int maxElemAtIndex=0;
        for (int i = 1; i <contour.size() ; i++) {
            if(contour.get(i)>contour.get(maxElemAtIndex)){
                maxElemAtIndex=i;
            }
        }
        int maxFibIndex=binarySearchFib(contour.get(maxElemAtIndex));
        if(maxFibIndex==-1)return false;
        int i;
        for (i = 1; i < contour.size(); i++) {

            if(!contour.get((maxElemAtIndex+i)%contour.size()).equals(buffer.get(maxFibIndex-i)))break;
        }
        if(i==1){
            int j;
            for (j = 1; j <contour.size() ; j++) {
                if(!contour.get((contour.size()+maxElemAtIndex-j)%contour.size()).equals(buffer.get(maxFibIndex-j)))return false;

            }
            return j==contour.size();
        }
        return i==contour.size();
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
    private int binarySearchFib(int candidate){
        if(candidate>buffer.get(buffer.size()-1)) fillBuffer(candidate);
        int start =0;
        int end= buffer.size()-1;
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(candidate== buffer.get(mid))return mid;
            else if (candidate < buffer.get(mid)) {
                end = mid-1;
            }
            else start=mid+1;
        }
        return -1;
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
                buffer.add(
                        buffer.get(buffer.size()-1) +
                                buffer.get(buffer.size()-2));
            }
        }
    }

