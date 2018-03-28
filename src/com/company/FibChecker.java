package com.company;

import java.util.ArrayList;

public class FibChecker {
    private ArrayList<Integer> fibonaccis;
    private int sizeOfMatrix;
    private int startX,startY;
    private int currentIndex;
    private int[][] matrix;
    FibChecker(){
        startX=0;
        startY=0;
        fibonaccis=new ArrayList<>();
        fibonaccis.add(1);
        fibonaccis.add(1);
        matrix = new int[2][2];
        matrix[0][0]=2;
        matrix[0][1]=3;
        matrix[1][1]=5;
        matrix[1][0]=8;
        currentIndex=binarySearchFib(matrix[startX][startY]);
//        int counter = 0;
//        for(int i=0 ;i< sizeOfMatrix; i++){
//            for(int j=0; j<sizeOfMatrix; j++){
//                matrix[i][j] = ++counter;
//            }
        }

    public boolean legalIndexes(int x,int y){
        return x<sizeOfMatrix&&y<sizeOfMatrix&&x>=0&&y>=0&&((x==0||x==sizeOfMatrix-1)||(y==0||y==sizeOfMatrix-1));
    }
    private boolean isFinalStep(int indexX,int indexY){
      return  (indexX==startX&&Math.abs(indexY-startY)==1)||(indexY==startY&&Math.abs(indexY-startY)==1);
    }
    public boolean hasSpiral(){
    return hasSpiral(startX,startY);}
    private boolean hasSpiral(int indexX, int indexY){
            addFibs(matrix[indexX][indexY]);
            if(isFinalStep(indexX,indexY)) return true;
            int temp=currentIndex;
            if(legalIndexes(indexX+1,indexY)&&matrix[indexX+1][indexY]==fibonaccis.get(currentIndex+1)){
                currentIndex++;
                if(hasSpiral(indexX+1,indexY))return true;
                else currentIndex=temp;
                }
             if(legalIndexes(indexX-1,indexY)&&matrix[indexX-1][indexY]==fibonaccis.get(currentIndex+1)){
                currentIndex++;
                if(hasSpiral(indexX-1,indexY))return true;
                else currentIndex=temp;
                }
            if(legalIndexes(indexX,indexY+1)&&matrix[indexX][indexY+1]==fibonaccis.get(currentIndex+1)){
                currentIndex++;
                if(hasSpiral(indexX,indexY+1))return true;
                else currentIndex=temp;
            }
            if(legalIndexes(indexX,indexY-1)&&matrix[indexX][indexY-1]==fibonaccis.get(currentIndex+1)){
                currentIndex++;
                if(hasSpiral(indexX,indexY-1))return true;
                else currentIndex=temp;
            }
            return false;
    }
    private int binarySearchFib(int candidate){
        int start =0;
        int end= fibonaccis.size()-1;
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(candidate==fibonaccis.get(mid))return mid;
            else if (candidate < fibonaccis.get(mid)) {
                end = mid-1;
            }
            else start=mid+1;
        }
        return -1;
    }
    public void addFibs(int fibCandidate){

        if(fibCandidate>=fibonaccis.get(fibonaccis.size()-1))
            while(fibCandidate>=fibonaccis.get(fibonaccis.size()-1)){
                fibonaccis.add(
                        fibonaccis.get(fibonaccis.size()-1) +
                                fibonaccis.get(fibonaccis.size()-1));
            }
        }
    }

