package dictionary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class DictionaryTest {
    private Dictionary<String, Integer> dict;
    private Random rand = new Random();

    @Before
    public void setUp() {
        dict = new Dictionary<>();
    }

    @Test
    public void Dictionary_SingleSet() {
        dict.set("foo", 10);

        Assert.assertEquals("single set/get", (Integer)10, dict.get("foo"));
    }

    @Test
    public void Dictionary_ManySet() {
        List<Tuple<String, Integer>> inserted = new ArrayList<>();

        for(int i = 0; i < 10000; i++) {
            String key = randomString();
            Integer value = rand.nextInt();

            inserted.add(new Tuple<>(key, value));

            dict.set(key, value);
        }

        for (Tuple<String, Integer> pair : inserted) {
            Assert.assertEquals(pair.value, dict.get(pair.key));
        }
    }

    @Test
    public void Dictionary_ContainsKey_Positive() {
        dict.set("foo", 10);

        Assert.assertTrue(dict.containsKey("foo"));
    }

    @Test
    public void Dictionary_ContainsKey_Negative() {
        dict.set("foo", 10);

        Assert.assertFalse(dict.containsKey("bar"));
    }

    @Test
    public void Dictionary_Remove() {
        dict.set("foo", 10);
        dict.set("bar", 20);

        dict.remove("foo");

        Assert.assertFalse(dict.containsKey("foo"));
        Assert.assertTrue(dict.containsKey("bar"));
    }

    private String randomString() {
        char cc[] = new char[10];

        for(int i = 0; i < cc.length; i++) {
            cc[i] = (char) ((rand.nextInt() % 26) + 97); // set to a random lowercase letter
        }

        return new String(cc);
    }

    private class Tuple<TKey, TValue> {
        Tuple(TKey key, TValue value) {
            this.key = key;
            this.value = value;
        }

        TKey key;
        TValue value;
    }
}
