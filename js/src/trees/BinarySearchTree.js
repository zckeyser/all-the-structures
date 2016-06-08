function BinarySearchTreeNode(parent, val) {
  this.parent = parent;
  this.value = val;
  this.count = 1; // # of times this value has been inserted into the tree
  this.left = null;
  this.right = null;
}

// BST implementation
// I attempt to prevent invalid values from entering the tree
// by type-checking during insertion, but since I can't hide
// the instance variables it's possible to corrupt this if
// you access them directly instead of using the given functions
// to handle the tree
BinarySearchTreeNode.prototype = (function() {
  // insert given value into the tree, maintaining BST properties
  function insert(n) {
    if(typeof(n) !== 'number') {
      console.log('non-number value passed into BinarySearchTreeNode.insert()');
      return null;
    };

    if(n !== 0 && !n) {
      console.log('invalid value passed into BinarySearchTreeNode.insert(): ' + n);
      return null;
    }

    // if we already have this value in the tree, up the count on its node
    if(n === this.value) {
      this.count++;
      return this;
    }

    if(n < this.value) {
      if(this.left) {
        // if we have a left subtree, insert it into that subtree
        this.left.insert(n);
      } else {
        // if we don't, this is our new left child
        this.left = new BinarySearchTreeNode(this, n);
      }
    } else {
      if(this.right) {
        // if we have a right subtree, insert it into that subtree
        this.right.insert(n);
      } else {
        // if we don't, this is our new right child
        this.right = new BinarySearchTreeNode(this, n);
      }
    }
  }

  // remove node with value n from the tree, maintaining BST properties
  // if there are multiple, will remove the first found in an in-order traversal
  // returns a boolean representing whether the removal was successful
  function remove(n) {
    if(typeof(n) !== 'number') {
      console.log('non-number value passed into BinarySearchTreeNode.remove()');
      return false;
    };

    if(n != 0 && !n) {
      console.log('invalid value passed into BinarySearchTreeNode.remove(): ' + n);
      return false;
    }

    // if we've found the value
    if(n === this.value) {
      if(this.count > 1) {
        // if there's multiple of the value, remove one
        this.count--;
      } else {
        // otherwise get rid of the node entirely
        deleteNode(this);
      }
    } else if (n < this.value) {
      if(n.left) {
        // if it's in the left subtree, remove it from that
        n.left.remove(n);
      } else {
        // if it's less than this node's value but there's no left subtree, we don't have it
        console.log('value ' + n + ' was attempted to be removed from a tree that does not contain it');
        return false;
      }
    } else {
      if(n.right) {
        // if it's in the right subtree, remove it from that
        n.right.remove(n);
      } else {
        // if it's greater than this node's value but there's no right subtree, we don't have it
        console.log('value ' + n + ' was attempted to be removed from a tree that does not contain it');
        return false;
      }
    }

    return true;
  }

  // deletes the node it's called from
  // since we're not managing the memory ourselves,
  // this just means handling this node's children
  // and un-referencing it from the parent
  function deleteNode(node) {
    if(!node.left && !node.right) {
      // if this is a leaf we can just un-reference it

      // figure out which child of the parent this is
      // then remove it
      if(node.parent.value < node.value) {
        node.parent.right = null;
      } else {
        node.parent.left = null;
      }
    } else if((node.left || node.right) && !(node.left && node.right)) {
      // if this has only one child, take the value closest to the current and use that instead
      var descendant = node.left ? node.left.getLargestDescendant() : node.right.getSmallestDescendant();

      // move the descendant node here and
      // delete the old copy
      node.value = descendant.value;
      node.count = descendant.count;
      deleteNode(descendant);
    } else {
      // if we have two children, take the greatest valued node
      // from the left subtree and use that here
      var descendant = getLargestDescendant(node.left);

      // move the descendant node here and
      // delete the old copy
      node.value = descendant.value;
      node.count = descendant.count;
      deleteNode(descendant);
    }
  }

  function getSmallestDescendant(node) {
    return node.left ? node.left.getSmallestDescendant() : node;
  }

  function getLargestDescendant(node) {
    return node.right ? node.right.getLargestDescendant() : node;
  }

  function contains(i) {
    return findNode(this, i) == true;
  }

  function findNode(curr, i) {
    if(i === curr.value) {
      return curr;
    } else if(i < curr.value) {
      return curr.left ? curr.left.findNode(i) : null;
    } else {
      return curr.right ? curr.right.findNode(i) : null;
    }
  }

  // the height of a tree from node N is
  // the greatest of N's children's heights plus 1 for N itself
  function height() {
    var childHeight = 0;

    if(this.left) {
      childHeight = this.left.height();
    }

    if(this.right) {
      childHeight = Math.max(childHeight, this.right.height());
    }

    return childHeight + 1;
  }

  return {
    insert: insert,
    remove: remove,
    contains: contains,
    height: height
  }
}.call(this))
