package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class TestGearBox {
    @Test
    public void testNoShift(){
        GearBox gearBox = new GearBox();
        gearBox.gear = GearBox.MIN_GEAR + 1;
        gearBox.shiftGear(GearBox.LOWER_RPM_BOUND);
        Assert.assertEquals(GearBox.MIN_GEAR + 1,gearBox.gear);
        gearBox.shiftGear(GearBox.UPPER_RPM_BOUND);
        Assert.assertEquals(GearBox.MIN_GEAR + 1,gearBox.gear);
    }
    @Test
    public void testShiftUp(){
        GearBox gearBox = new GearBox();
        gearBox.gear = GearBox.MAX_GEAR-1;
        gearBox.shiftGear(GearBox.UPPER_RPM_BOUND+1);
        Assert.assertEquals(GearBox.MAX_GEAR,gearBox.gear);
    }
    @Test
    public void testShiftDown(){
        GearBox gearBox = new GearBox();
        gearBox.gear = GearBox.MAX_GEAR;
        gearBox.shiftGear(GearBox.LOWER_RPM_BOUND-1);
        Assert.assertEquals(GearBox.MAX_GEAR-1,gearBox.gear);
    }
    @Test
    public void testNoShiftUpInGear6(){
        GearBox gearBox = new GearBox();
        gearBox.gear = GearBox.MAX_GEAR;
        gearBox.shiftGear(GearBox.UPPER_RPM_BOUND+1);
        Assert.assertEquals(GearBox.MAX_GEAR,gearBox.gear);
    }
    @Test
    public void testNoShiftDownInGear1(){
        GearBox gearBox = new GearBox();
        gearBox.gear = GearBox.MIN_GEAR;
        gearBox.shiftGear(GearBox.LOWER_RPM_BOUND-1);
        Assert.assertEquals(GearBox.MIN_GEAR,gearBox.gear);
    }
    @Test
    public void testNoShiftInNeutral(){
        GearBox gearBox = new GearBox();
        gearBox.gear = 0;

        gearBox.shiftGear(GearBox.LOWER_RPM_BOUND-1);
        Assert.assertEquals(0,gearBox.gear);

        gearBox.shiftGear(GearBox.UPPER_RPM_BOUND+1);
        Assert.assertEquals(0,gearBox.gear);
    }
    @Test
    public void testNoShiftInReverse(){
        GearBox gearBox = new GearBox();
        gearBox.gear = -1;

        gearBox.shiftGear(GearBox.LOWER_RPM_BOUND-1);
        Assert.assertEquals(-1,gearBox.gear);

        gearBox.shiftGear(GearBox.UPPER_RPM_BOUND+1);
        Assert.assertEquals(-1,gearBox.gear);
    }
}
