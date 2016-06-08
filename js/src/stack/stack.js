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
