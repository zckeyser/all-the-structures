package list;

/**
 * Generic singly linked list implementation
 *
 * Uses a flag to handle the list being empty, since it's
 * safer than using a null check on value
 *
 * This implementation uses recursion
 * instead of iterative approaches to various methods
 */
public class LinkedList<T> {
    private T value;
    private LinkedList<T> next;
    private boolean empty;

    public LinkedList() { empty = true; }

    private LinkedList(T value) {
        this.empty = false;
        this.value = value;
    }

    public int length() {
        if(empty) {
            return 0;
        } else if(next == null) {
            return 1;
        } else {
            return 1 + next.length();
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    /**
     * get the value at the given index
     */
    public T get(int index) {
        if(index < 0 || index > this.length() - 1) {
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            return this.value;
        } else {
            return next.get(index - 1);
        }
    }

    /**
     * append a value to the list
     */
    public void add(T value) {
        if(empty) {
            this.value = value;
            empty = false;
        } else if(next == null) {
            next = new LinkedList<>(value);
        } else {
            next.add(value);
        }
    }

    /**
     * insert a value before the given index
     */
    public void add(T value, int index) {
        if(index < 0 || index > this.length()) {
            throw new IndexOutOfBoundsException();
        } else if(index == 0){
            this.value = value;
            empty = false; // in case this was the first insert
        } else if(index == 1) {
            LinkedList<T> tmp = next;
            next = new LinkedList<>(value);
            next.next = tmp;
        } else {
            next.add(value, index - 1);
        }
    }

    /**
     * set the value at the given index
     */
    public void set(T value, int index) {
        if(index < 0 || index > this.length() - 1) {
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            this.value = value;
        } else {
            next.set(value, index - 1);
        }
    }

    /**
     * get the index of the given value, -1 if not found
     */
    public int indexOf(T target) {
        if(!this.contains(target)) {
            return -1;
        } else if(this.value.equals(target)) {
            return 0;
        } else {
            return next.indexOf(target) + 1;
        }
    }

    /**
     * check if the given value is contained in the list
     */
    public boolean contains(T target) {
        return this.value.equals(target) || (this.next != null && this.next.contains(target));
    }
}
