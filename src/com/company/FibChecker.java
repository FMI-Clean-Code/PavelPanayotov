package com.company;

import java.util.ArrayList;

public class FibChecker {
    private ArrayList<Integer> fibonaccis;
    FibChecker(){
        fibonaccis=new ArrayList<>();
        fibonaccis.add(1);
        fibonaccis.add(1);

    }
    private boolean binarySearchFib(int candidate){
        int start =0;
        int end= fibonaccis.size()-1;
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(candidate==fibonaccis.get(mid))return true;
            else if (candidate < fibonaccis.get(mid)) {
                end = mid-1;
            }
            else start=mid+1;
        }
        return false;
    }
    public boolean isFib(int fibCandidate){
        if(fibonaccis.get(fibonaccis.size()-1)>fibCandidate){
            return binarySearchFib(fibCandidate);
        }
        else {
            while(fibonaccis.get(fibonaccis.size()-1)<fibCandidate){
                fibonaccis.add(
                        fibonaccis.get(fibonaccis.size()-1) +
                                fibonaccis.get(fibonaccis.size()-1));
            }
            return fibonaccis.get(fibonaccis.size()-1)==fibCandidate;
        }
    }

}
