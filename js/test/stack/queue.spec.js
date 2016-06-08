describe('Queue', function() {
  describe('push/pop', function() {
    it('should return null if there are no items in it', function() {
      var queue = new Queue();

      expect(queue.pop()).toBeNull();
    })

    it('should retrieve the first item pushed into it', function() {
      var queue = new Queue();

      queue.push(0);
      expect(queue.pop()).toBe(0);

      queue.push(1);
      queue.push(2);
      expect(queue.pop()).toBe(1);
    })
  })

  describe('size', function() {
    it('should have size 0 on initialization', function() {
      var queue = new Queue();

      expect(queue.size()).toBe(0);
    })

    it('should accurately reflect added items', function() {
      var queue = new Queue();

      queue.push(0);
      expect(queue.size()).toBe(1);

      queue.push(0)
      expect(queue.size()).toBe(2);

      queue.pop()
      expect(queue.size()).toBe(1);

      queue.pop()
      expect(queue.size()).toBe(0);
    })
  })
})
