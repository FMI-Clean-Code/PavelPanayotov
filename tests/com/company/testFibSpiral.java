package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class testFibSpiral {
    @Test
    public void testContour(){
        int matrix[][]= new int[2][2];
        matrix[0][0]=1;
        matrix[0][1]=1;
        matrix[1][1]=2;
        matrix[1][0]=3;
        ArrayList<Integer> contour=new ArrayList<>();
        contour.add(1);
        contour.add(1);
        contour.add(2);
        contour.add(3);
        FibChecker fibChecker=new FibChecker(matrix);
        Assert.assertArrayEquals(contour.toArray(),fibChecker.getContour(0,0,2).toArray());
    }

}
