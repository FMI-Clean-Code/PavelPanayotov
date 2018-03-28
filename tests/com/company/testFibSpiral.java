package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class testFibSpiral {
    private FibonacciSpiral fibonacciSpiral;
    private int matrix[][];

    @Before
    public void init(){
        matrix= new int[2][2];
        matrix[0][0]=1;
        matrix[0][1]=1;
        matrix[1][1]=2;
        matrix[1][0]=3;
        fibonacciSpiral =new FibonacciSpiral(matrix);

    }
    @Test
    public void testContour(){

        ArrayList<Integer> contour=new ArrayList<>();
        contour.add(1);
        contour.add(1);
        contour.add(2);
        contour.add(3);
        Assert.assertArrayEquals(contour.toArray(), fibonacciSpiral.getContour(0,0,2).toArray());
    }
    @Test
    public void testHasContourSpiral(){
        ArrayList<Integer> contour=new ArrayList<>();
      //intentionally 1 1 3 2 ( not 1 1 2 3)
        contour.add(1);
        contour.add(1);
        contour.add(3);
        contour.add(2);
        Assert.assertTrue(fibonacciSpiral.hasContourSpiral(contour));
    }
    @Test
    public void testHasFibonacciSpiral(){
        Assert.assertTrue(fibonacciSpiral.hasFibSpiral());
    }
    @Test
    public void testDoesntHaveFibonacciSpiral(){
        matrix[0][0]=9;
        Assert.assertFalse(fibonacciSpiral.hasFibSpiral());
    }

}
