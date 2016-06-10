function Stack() {
  this.values = [];
}

// simple stack implementation (Last In, First Out)
Stack.prototype = (function() {
  function push(val) {
    this.values.push(val);
  }

  function pop() {
    return this.values.length > 0 ? this.values.pop() : null;
  }

  function size() {
    return this.values.length;
  }

  function contains(target, comparator) {
    return comparator ? _.findIndex(this.values, target, comparator) !== -1
                      : _.indexOf(this.values, target) !== -1;
  }

  function empty() {
    return this.values.length === 0;
  }

  function clear() {
    values = [];
  }

  return {
    push: push,
    pop: pop,
    size: size,
    contains: contains,
    empty: empty,
    clear: clear
  }
}.call(this))
