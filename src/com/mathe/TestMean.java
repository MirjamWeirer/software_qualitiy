package com.mathe;

import org.junit.Assert;
import org.junit.Test;

public class TestMean {
    @Test
    public void testWithOutRound(){
        Mean mean = new Mean();
        Assert.assertEquals(3,mean.mean(4,2));
    }
    @Test
    public void testWithRound(){
        Mean mean = new Mean();
        Assert.assertEquals(3,mean.mean(2,5));
    }
    @Test
    public void testMeanOverflow(){
        Mean mean = new Mean();
        int result =  mean.mean(Integer.MAX_VALUE-1,Integer.MAX_VALUE);
        Assert.assertEquals(Integer.MAX_VALUE-1,result);
    }

}
