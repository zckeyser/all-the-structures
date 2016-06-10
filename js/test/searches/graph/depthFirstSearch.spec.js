describe('Depth First Search', function() {
  var root;
  var dfs = new DepthFirstSearch();

  beforeEach(function() {
    root = new DirectedGraphNode(20);

    var n1 = new DirectedGraphNode(10);
    var n2 = new DirectedGraphNode(30);

    root.addNeighbor(n1);
    root.addNeighbor(n2);

    var n3 = new DirectedGraphNode(7);
    var n4 = new DirectedGraphNode(13);
    n1.addNeighbor(n3);
    n1.addNeighbor(n4);

    var n5 = new DirectedGraphNode(80);
    var n6 = new DirectedGraphNode(130);
    var n7 = new DirectedGraphNode(49);
    n3.addNeighbor(n5);
    n3.addNeighbor(n6);
    n3.addNeighbor(n7);
    n3.addNeighbor(n4);

    var n8 = new DirectedGraphNode(77);
    var n9 = new DirectedGraphNode(35);
    var n10 = new DirectedGraphNode(165);
    var n11 = new DirectedGraphNode(100);
    n2.addNeighbor(n8);
    n2.addNeighbor(n9);
    n2.addNeighbor(n10);
    n2.addNeighbor(n11);
    n2.addNeighbor(n7);
  })

  it('should correctly traverse the graph', function() {
    var expected = '20 30 49 100 165 35 77 10 13 7 130 80';
    var result = dfs.traverse(root);

    expect(result).toBe(expected);
  });
})
