package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class LinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void LinkedList_Initialization() {
        Assert.assertTrue("list initializes as empty", list.isEmpty());

        Assert.assertEquals("list initializes with length 0", 0, list.length());
    }

    @Test
    public void LinkedList_Add_Initial() {
        list.add(10);

        Assert.assertEquals("index 0 after initial add", (Integer) 10, list.get(0));
        Assert.assertEquals("length after initial add", 1, list.length());
    }

    @Test
    public void LinkedList_Add_Multiple() {
        list.add(10);
        list.add(20);

        Assert.assertEquals("index 0 after multiple adds", (Integer) 10, list.get(0));
        Assert.assertEquals("index 1 after multiple adds", (Integer) 20, list.get(1));
        Assert.assertEquals("length after multiple adds", 2, list.length());
    }

    @Test
    public void LinkedList_Add_AtIndex() {
        list.add(10);
        list.add(20);
        list.add(30, 1);

        Assert.assertEquals("index 0 after insert", (Integer) 10, list.get(0));
        Assert.assertEquals("index 1 after insert", (Integer) 30, list.get(1));
        Assert.assertEquals("index 2 after insert", (Integer) 20, list.get(2));
        Assert.assertEquals("length after insert", 3, list.length());
    }

    @Test
    public void LinkedList_Set() {
        list.add(10);
        list.add(20);
        list.set(30, 1);

        Assert.assertEquals("index 0 after set", (Integer) 10, list.get(0));
        Assert.assertEquals("index 1 after set", (Integer) 30, list.get(1));
        Assert.assertEquals("length after set", 2, list.length());
    }

    @Test
    public void LinkedList_IndexOf_Positive() {
        populateForContains();

        Assert.assertEquals("Index of contained element", 2, list.indexOf(30));
    }

    @Test
    public void LinkedList_IndexOf_Negative() {
        populateForContains();

        Assert.assertEquals("Index of uncontained element", -1, list.indexOf(35));
    }

    @Test
    public void LinkedList_Contains_Positive() {
        populateForContains();

        Assert.assertTrue("Index of contained element", list.contains(30));
    }

    @Test
    public void LinkedList_Contains_Negative() {
        populateForContains();

        Assert.assertFalse("Index of uncontained element", list.contains(35));
    }

    private void populateForContains() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
    }
}
