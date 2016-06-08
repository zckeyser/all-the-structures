describe('Binary Search Tree', function() {
  var root;

  beforeEach(function() {
    root = new BinarySearchTreeNode(null, 50);
  })

  describe('initialization', function() {
    it('should have no children on initialization', function() {
      expect(root.left === null && root.right === null).toBe(true);
    })
  })

  describe('insert', function() {
    it('should insert a lesser value as the left child of a leaf', function() {
      root.insert(30);

      expect(root.left.value).toBe(30);
    })

    it('should insert a greater value as the right child of a leaf', function() {
      root.insert(70);

      expect(root.right.value).toBe(70);
    })

    it('should insert values into both children when applicable', function() {
      root.insert(30);
      root.insert(70);

      expect(root.left.value).toBe(30);
      expect(root.right.value).toBe(70);
    })

    it('should insert values into the left sub-tree correctly', function() {
      root.insert(30);
      root.insert(20);
      root.insert(40);

      expect(root.left.left.value).toBe(20);
      expect(root.left.right.value).toBe(40);
    })

    it('should insert values into the right sub-tree correctly', function() {
      root.insert(70);
      root.insert(80);
      root.insert(60);

      expect(root.right.left.value).toBe(60);
      expect(root.right.right.value).toBe(80);
    })

    it('should insert in an unbalanced manner correctly', function() {
      root.insert(30);
      root.insert(70);
      root.insert(60);
      root.insert(65);
      root.insert(67);

      expect(root.left.value).toBe(30);
      expect(root.right.value).toBe(70);
      expect(root.right.left.value).toBe(60);
      expect(root.right.left.right.value).toBe(65);
      expect(root.right.left.right.right.value).toBe(67);
    })
  })
})
