function BinaryTreeTraverser() { }

BinaryTreeTraverser.prototype = (function() {
  function preOrder(node) {
    return preOrderHelper(node).trim();
  }

  function preOrderHelper(node) {
    var output = '';

    output += node.value + ' ';

    if(node.left) {
      output += preOrderHelper(node.left);
    }

    if(node.right) {
      output += preOrderHelper(node.right);
    }

    return output;
  }

  function inOrder(node) {
    return inOrderHelper(node).trim();
  }

  function inOrderHelper(node) {
    var output = '';

    if(node.left) {
      output += inOrderHelper(node.left);
    }

    output += node.value + ' ';

    if(node.right) {
      output += inOrderHelper(node.right);
    }

    return output;
  }

  function postOrder(node) {
    return postOrderHelper(node).trim();
  }

  function postOrderHelper(node) {
    var output = '';

    if(node.left) {
      output += postOrderHelper(node.left);
    }

    if(node.right) {
      output += postOrderHelper(node.right);
    }

    output += node.value + ' ';

    return output;
  }

  return {
    preOrder: preOrder,
    inOrder: inOrder,
    postOrder: postOrder
  }
}.call(this))
