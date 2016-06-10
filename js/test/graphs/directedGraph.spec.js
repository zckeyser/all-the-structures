describe('Directed Graph', function() {
  describe('equals', function() {
    it('should correctly compare equal neighborless nodes', function() {
      var n1 = new DirectedGraphNode(50);
      var n2 = new DirectedGraphNode(50);

      expect(n1.equals(n2)).toBe(true);
    })

    it('should correctly compare equal neighborless nodes', function() {
      var n1 = new DirectedGraphNode(50);
      var n2 = new DirectedGraphNode(100);

      expect(n1.equals(n2)).not.toBe(true);
    })

    it('should use strict equality for comparing values', function() {
      var n1 = new DirectedGraphNode(50);
      var n2 = new DirectedGraphNode('50');

      expect(n1.equals(n2)).not.toBe(true);
    })

    it('should recursively compare neighbor nodes when equal', function() {
      var n1 = new DirectedGraphNode(50);
      var n2 = new DirectedGraphNode(50);
      var n3 = new DirectedGraphNode(80);

      n1.addNeighbor(n3);
      n2.addNeighbor(n3);

      expect(n1.equals(n2)).toBe(true);
    })

    it('should recursively compare neighbor nodes when not equal', function() {
      var n1 = new DirectedGraphNode(50);
      var n2 = new DirectedGraphNode(50);
      var n3 = new DirectedGraphNode(80);
      var n4 = new DirectedGraphNode(100);

      n1.addNeighbor(n3);
      n2.addNeighbor(n4);

      expect(n1.equals(n2)).not.toBe(true);
    })
  })
})
