describe('Stack', function() {
  describe('push/pop', function() {
    it('should return null if there are no items on it', function() {
      var stack = new Stack();
      
      expect(stack.pop()).toBeNull();
    })

    it('should retrieve the last item pushed onto it', function() {
      var stack = new Stack();

      stack.push(0);
      expect(stack.pop()).toBe(0);

      stack.push(1);
      stack.push(2);
      expect(stack.pop()).toBe(2);
    })
  })

  describe('size', function() {
    it('should have size 0 on initialization', function() {
      var stack = new Stack();

      expect(stack.size()).toBe(0);
    })

    it('should accurately reflect added items', function() {
      var stack = new Stack();

      stack.push(0);
      expect(stack.size()).toBe(1);

      stack.push(0)
      expect(stack.size()).toBe(2);

      stack.pop()
      expect(stack.size()).toBe(1);

      stack.pop()
      expect(stack.size()).toBe(0);
    })
  })
})
