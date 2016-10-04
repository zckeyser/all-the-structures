package dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * generic dictionary implemented using chaining for collision handling
 */
 public class Dictionary<TKey, TValue> {
    private final int DEFAULT_ARRAY_SIZE = 1024;
    private List<KeyValuePair<TKey, TValue>> values;

    public Dictionary() {
        values = new ArrayList<>();

        for(int i = 0; i < DEFAULT_ARRAY_SIZE; i++)
            values.add(null);
    }

    // just for testing
    public Dictionary(int arraySize) {
        values = new ArrayList<>();

        for(int i = 0; i < arraySize; i++)
            values.add(null);
    }

    public void set(TKey key, TValue value) {
        int index = Math.abs(key.hashCode()) % values.size();

        KeyValuePair<TKey, TValue> pair = new KeyValuePair<>(key, value);

        if(values.get(index) == null || values.get(index).getKey().equals(key)) {
            values.set(index, pair);
        } else {
            // add to the end of the linked list in this bucket
            KeyValuePair<TKey, TValue> curr = values.get(index);

            while(curr.getNext() != null)
                curr = curr.getNext();

            curr.setNext(pair);
        }
    }

    public TValue get(TKey key) {
        int index = Math.abs(key.hashCode()) % values.size();

        if(values.get(index) == null) {
            // its bucket is empty, we don't have it
            return null;
        } else {
            // check for it in the relevant bucket
            KeyValuePair<TKey, TValue> curr = values.get(index);

            while(curr != null) {
                if(curr.getKey().equals(key))
                    return curr.getValue();
                else
                    curr = curr.getNext();
            }

            // wasn't in the bucket
            return null;
        }
    }

    public void remove(TKey key) {
        int index = Math.abs(key.hashCode()) % values.size();

        if(values.get(index) != null) {
            KeyValuePair<TKey, TValue> curr = values.get(index);

            if(curr.getKey().equals(key)) {
                // move this bucket up a node
                // such that the second element is now the first
                // and the first is de-referenced
                values.set(index, curr.getNext());
            } else {
                while(curr.getNext() != null) {
                    if(curr.getNext().getKey().equals(key)) {
                        // remove the key from the chain
                        KeyValuePair<TKey, TValue> next = curr.getNext().getNext();
                        curr.setNext(next);
                        return;
                    }
                }
            }
        }
    }

    public boolean containsKey(TKey key) {
        int index = Math.abs(key.hashCode()) % values.size();

        if(values.get(index) != null) {
            KeyValuePair<TKey, TValue> curr = values.get(index);

            while(curr != null) {
                if(curr.getKey().equals(key))
                    return true;
                else
                    curr = curr.getNext();
            }
        }

        return false;
    }

    private class KeyValuePair<UKey, UValue> {
        private UKey key;
        private UValue value;
        private KeyValuePair<UKey, UValue> next;

        KeyValuePair(UKey key, UValue value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        UKey getKey() {
            return key;
        }

        UValue getValue() {
            return value;
        }

        KeyValuePair<UKey, UValue> getNext() { return next; }

        void setKey(UKey key) {
            this.key = key;
        }

        void setValue(UValue value) { this.value = value; }

        void setNext(KeyValuePair<UKey, UValue> next) { this.next = next; }
    }
}
