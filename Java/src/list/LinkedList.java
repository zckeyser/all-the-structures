public class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode<T>(T value) {
        this.value = value;
    }

    public int length() {
        if(next == null) {
            return 1;
        } else {
            return 1 + next.length();
        }
    }

    public T get(int index) {
        if(index < 0 || index > this.length() - 1) {
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            return this;
        } else {
            return next.get(index - 1);
        }
    }

    public void add(T value) {
        if(next == null) {
            next = new LinkedListNode<T> value;
        } else {
            next.add(value);
        }
    }

    public void add(T value, int index) {
        if(index < 0 || index > this.length() - 1) {
            throw new IndexOutOfBoundsException();
        } else if(index == 1) {
            LinkedListNode<T> tmp = next;
            next = new LinkedListNode<T>(value);
            next.next = tmp;
        } else {
            next.add(value, index - 1);
        }
    }

    public void set(T value, int index) {
        if(index < 0 || index > this.length() - 1) {
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            this.value = value;
        } else {
            next.set(value, index - 1);
        }
    }

    public int indexOf(T target) {
        if(!this.contains(target)) {
            return -1;
        } else if(this.value.equals(target)) {
            return 0;
        } else {
            return next.indexOf(target) + 1;
        }
    }

    public boolean contains(T target) {
        if(this.value.equals(target)) {
            return true;
        } else {
            return this.next != null && this.next.contains(target);
        }
    }
}
