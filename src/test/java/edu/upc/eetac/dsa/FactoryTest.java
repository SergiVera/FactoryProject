package edu.upc.eetac.dsa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryTest {

    @Before
    public void setUp(){


    }

    @Test
    public void testFactory() {
        Command c = Factory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", c.execute());

        c = Factory.getInstance().getCommand("C1");
        Assert.assertEquals("C1", c.execute());

        c = Factory.getInstance().getCommand("C2");
        Assert.assertEquals("C2", c.execute());



    }

}
