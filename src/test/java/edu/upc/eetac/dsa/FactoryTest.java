package edu.upc.eetac.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryTest {


    //Let's instantiate the class Command
    Command c;

    //We erase the content of the Command c
    @After
    public void tearDown(){
        c = null;
    }

    //In this test we try if loads the classes properly
    @Test
    public void testFactory() {
        //First we use the class loader
        c = Factory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", c.execute());

        //Once we have it in the HashMap, we only have to pick up in the cache
        c = Factory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", c.execute());

        //What we expect for the class C2 and class C3 is the same as class C1

        c = Factory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", c.execute());

        c = Factory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", c.execute());

        c = Factory.getInstance().getCommand("C3");
        Assert.assertEquals("C3", c.execute());

        c = Factory.getInstance().getCommand("C3");
        Assert.assertEquals("C3", c.execute());

        //We verify that at the second time and so on, they will continue using the cache memory
        c = Factory.getInstance().getCommand("C3");
        Assert.assertEquals("C3", c.execute());
    }

}
