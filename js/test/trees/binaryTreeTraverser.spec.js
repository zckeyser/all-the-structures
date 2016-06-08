describe('Binary Tree Traversal', function() {
  var root;
  var traverser;

  beforeAll(function() {
    traverser = new BinaryTreeTraverser();
    root = new BinarySearchTreeNode(null, 50);

    // left side
    root.insert(40);
    root.insert(35);
    root.insert(45);
    root.insert(48);

    // right side
    root.insert(60);
    root.insert(65);
    root.insert(55);
    root.insert(70);
  })

  it('should correctly perform pre-order', function() {
    var expected = '50 40 35 45 48 60 55 65 70';

    var result = traverser.preOrder(root);

    expect(result).toBe(expected);
  })

  it('should correctly perform in-order', function() {
    var expected = '35 40 45 48 50 55 60 65 70';

    var result = traverser.inOrder(root);

    expect(result).toBe(expected);
  })

  it('should correctly perform post-order', function() {
    var expected = '35 48 45 40 55 70 65 60 50';

    var result = traverser.postOrder(root);

    expect(result).toBe(expected);
  })
})
