// generic dictionary implemented using rollover for collision handling
// such that on collision, the value is placed in the next empty bucket
public class Dictionary<TKey, TValue> {
    private const int DEFAULT_ARRAY_SIZE = 64;
    private KeyValuePair<TKey, TValue>[] values;

    public Dictionary<TKey, TValue>() {
        values = new KeyValuePair<TKey, TValue>[DEFAULT_ARRAY_SIZE];
    }

    // just for testing
    public Dictionary<TKey, TValue>(int arraySize) {
        values = new LinkedListNode<KeyValuePair<TKey, TValue>>[arraySize];
    }

    public void add(TKey key, TValue value) {
        int index = value.hashCode() % values.length;

        KeyValuePair<TKey, TValue> pair = new KeyValuePair<TKey, TValue>(key, value);

        if(values[index] == null || values[index].getKey().equals(key)) {
            values[index] = pair;
        } else {
            int i = index + 1;

            while(i != index && values[i] != null) {
                i++;

                // roll back to beginning
                if(i == values.length) {
                    i = 0;
                }
            }

            // there were no open buckets -- we need to expand
            if(i == index) {
                expand();

                // try again now that we've expanded
                add(key, value);
            } else {
                // we found an open bucket to roll into
                values[index] = pair;
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

    // expand the internal array to double its current size,
    // reindexing all of the items currently inside
    private void expand() {
        int newSize = values.length * 2;
        KeyValuePair[] oldValues = values;

        values = new KeyValuePair[newSize];

        // re-index all the old items
        for(int i = 0; i < oldValues.length; i++) {
            // using a normal for-loop for speed, since it's more efficient than foreach
            add(oldValues[i].getKey(), oldValues[i].getValue());
        }
    }
}
