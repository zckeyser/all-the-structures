def __preorderHelper(node):
    output = ''

    output += str(node.value) + ' '

    if node.left != None:
        output += __preorderHelper(node.left)

    if node.right != None:
        output += __preorderHelper(node.right)

    return output

def preorder(node):
    return __preorderHelper(node).strip()

def __inorderHelper(node):
    output = ''

    if node.left != None:
        output += __inorderHelper(node.left)

    output += str(node.value) + ' '

    if node.right != None:
        output += __inorderHelper(node.right)

    return output

def inorder(node):
    return __inorderHelper(node).strip()

def __postorderHelper(node):
    output = ''

    if node.left != None:
        output += __postorderHelper(node.left)

    if node.right != None:
        output += __postorderHelper(node.right)

    output += str(node.value) + ' '

    return output

def postorder(node):
    return __postorderHelper(node).strip()

# prettier view which displays the tree as trees are commonly drawn
def treeview(node):
    print node.value
