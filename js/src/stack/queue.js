function Queue() {
  this.values = [];
}

// simple queue implementation (First In, First Out)
Queue.prototype = (function() {
  function push(val) {
      this.values.push(val);
  }

  function pop() {
      return this.values.length > 0 ? this.values.shift() : null;
  }

  function size() {
      return this.values.length;
  }

  function contains(target, comparator) {
      var compareWith = util.partial(comparator, target);

      return comparator ? util.findIndex(this.values, compareWith) !== -1
                        : util.indexOf(this.values, target) !== -1;
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
