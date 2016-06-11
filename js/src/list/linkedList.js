function LinkedList(value) {
    this.next = null;
    this.value = value !== undefined ? value : null; // set the value to null if none is passed in
}

LinkedList.prototype = (function() {
    function add(value, index) {
        if(this.value === null) {
            this.value = value;
        } else if(index !== 0 && !index) {
            if(this.next) {
                this.next.add(value);
            } else {
                this.next = new LinkedList(value);
            }
        } else {
            if(invalidIndex(index, this.length())) {
                console.log('warning: invalid index ' + index + ' passed to LinkedListNode.add()');
                console.log(length());
                return;
            }

            if(index === 0) {
                if(this.next != null) {
                    var tmp = this.next;
                    this.next = new LinkedList(value);
                    this.next.next = tmp;
                } else {
                    this.next = new LinkedList(value);
                }
            } else {
                this.next.add(value, index - 1);
            }
        }
    }

    function get(index) {
        if(invalidIndex(index, this.length())) {
            console.log('warning: invalid index ' + index + ' passed to LinkedListNode.get()');
            return null;
        } else if(index === 0) {
            return this.value;
        } else {
            return this.next.get(index - 1);
        }
    }

    function set(index, value) {
        if(invalidIndex(index, this.length())) {
            console.log('warning: invalid index ' + index + ' passed to LinkedListNode.set()');
        } else if(index === 0) {
            this.value = value;
        } else {
            this.next.set(index - 1, value);
        }
    }

    function remove(index) {
        if(invalidIndex(index, this.length())) {
            console.log('warning: invalid index ' + index + ' passed to LinkedListNode.remove()');
        } else if(index === 0) {
            this.value = this.next.value;
            this.next = this.next.next;
        } else {
            if(index === 1) {
                this.next = this.next.next;
            } else {
                this.next.remove(index - 1);
            }
        }
    }

    function length() {
        // null value is how we show an empty list
        if(this.value === null) {
            return 0;
        } else if(this.next) {
            return this.next.length() + 1;
        } else {
            return 1;
        }
    }

    function contains(target, comparator) {
        if(this.equals(target, comparator)) {
            return true;
        } else if (this.next) {
            return this.next.contains(target, comparator);
        } else {
            return false;
        }
    }

    function indexOf(target, comparator) {
        if(this.equals(target, comparator)) {
            return 0;
        } else if(this.next) {
            var index = this.next.indexOf(target, comparator);
            return index === -1 ? index : index + 1; // if it isn't found, just return -1
        } else {
            return -1;
        }
    }

    function equals(value, comparator) {
        return (comparator && comparator(this.value, value)) || (!comparator && this.value === value);
    }

    function invalidIndex(index, len) {
        return typeof(index) !== 'number' || index < 0 || index >= len;
    }

    return {
        add: add,
        get: get,
        set: set,
        remove: remove,
        length: length,
        contains: contains,
        indexOf: indexOf,
        equals: equals
    }
}.call(this))
