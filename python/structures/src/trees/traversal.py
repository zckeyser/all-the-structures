def _preorderHelper(node):
    output = ''

    output += str(node.value) + ' '

    if node.left != None:
        output += _preorderHelper(node.left)

    if node.right != None:
        output += _preorderHelper(node.right)

    return output

def preorder(node):
    return _preorderHelper(node).strip()

def _inorderHelper(node):
    output = ''

    if node.left != None:
        output += _inorderHelper(node.left)

    output += str(node.value) + ' '

    if node.right != None:
        output += _inorderHelper(node.right)

    return output

def inorder(node):
    return _inorderHelper(node).strip()

def _postorderHelper(node):
    output = ''

    if node.left != None:
        output += _postorderHelper(node.left)

    if node.right != None:
        output += _postorderHelper(node.right)

    output += str(node.value) + ' '

    return output

def postorder(node):
    return _postorderHelper(node).strip()

# prettier view which displays the tree as trees are commonly drawn
# TODO pretty-print logic
def treeview(node):
    print(node.value)
