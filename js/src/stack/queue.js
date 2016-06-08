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

  function clear() {
    values = [];
  }

  return {
    push: push,
    pop: pop,
    size: size,
    clear: clear
  }
}.call(this))
