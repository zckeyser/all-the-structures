package dictionary;

class KeyValuePair<TKey, TValue> {
    private TKey key;
    private TValue value;
    private KeyValuePair<TKey, TValue> next;

    public KeyValuePair(TKey key, TValue value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public TKey getKey() {
        return key;
    }

    public TValue getValue() {
        return value;
    }

    public KeyValuePair<TKey, TValue> getNext() { return next; }

    public void setKey(TKey key) {
        this.key = key;
    }

    public void setValue(TValue value) { this.value = value; }

    public void setNext(KeyValuePair<TKey, TValue> next) { this.next = next; }
}
