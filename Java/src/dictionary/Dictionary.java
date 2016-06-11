// generic dictionary implemented using the bucket method
// for collision handling. What that means is that
// each entry in the internal array is a linked list, and
// when there is a collision (two keys that have the same hash index)
// the new entry is simply added to the list
public class Dictionary<TKey, TValue> {
    private const int DEFAULT_ARRAY_SIZE = 10000;
    private LinkedListNode<KeyValuePair<TKey, TValue>>[] values;

    public Dictionary<TKey, TValue>() {
        values = new LinkedListNode<KeyValuePair<TKey, TValue>>[DEFAULT_ARRAY_SIZE];
    }

    // just for testing
    public Dictionary<TKey, TValue>(int arraySize) {
        values = new LinkedListNode<KeyValuePair<TKey, TValue>>[arraySize];
    }

    public void add(TKey key, TValue value) {
        int index = value.hashCode() % values.length;
        KeyValuePair<TKey, TValue> pair = new KeyValuePair<TKey, TValue>(key, value);

        if(values[index] == null) {
            values[index] = new LinkedListNode<KeyValuePair<TKey, TValue>>(pair);
        } else {
            int subIndex = findInBucket(index, key);

            if(subIndex == -1) {
                values[index].add(value);
            } else {
                values[index].set(pair, subIndex);
            }
        }
    }

    public TValue get(TKey key) {
        int index = value.hashCode() % values.length;

        if(values[index] == null) {
            return null;
        } else {
            int subIndex = findInBucket(index, key);

            return subIndex != -1 ? values[index].get(subIndex).getValue() : null;
        }
    }

    public void remove(TKey key) {
        int index = value.hashCode() % values.length;

        if(values[index] == null) {
            return null;
        } else {
            int subIndex = findInBucket(index, key);

            if(subIndex != -1) {
                values[index].remove(subIndex);
            }
        }
    }

    private int findInBucket(int index, TKey key) {
        int listLength = values[index].length();

        for(int i = 0; i < listLength; i++) {
            // iterate until we find the right value
            if(values[index].get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }
}
