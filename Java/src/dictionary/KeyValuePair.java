public class KeyValuePair<TKey, TValue> {
    private TKey key;
    private TValue value;

    public KeyValuePair<TKey, TValue>(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    public TKey getKey() {
        return key;
    }

    public TValue getValue() {
        return value;
    }

    public void setKey(TKey key) {
        this.key = key;
    }

    public void setValue(TValue value) {
        this.value = value;
    }
}
