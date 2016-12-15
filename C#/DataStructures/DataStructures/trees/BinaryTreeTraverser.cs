namespace DataStructures.trees
{
	public class BinaryTreeTraverser
	{
		public string PreOrder<T>(IBinaryTree<T> tree)
		{
            return PreOrderHelper(tree).Trim();
		}

        private string PreOrderHelper<T>(IBinaryTree<T> tree)
        {
            string output = "";

            output += tree.Value + " ";

            if (tree.Left != null)
                output += PreOrderHelper(tree.Left);

            if (tree.Right != null)
                output += PreOrderHelper(tree.Right);

            return output;
        }

		public string InOrder<T>(IBinaryTree<T> tree)
		{
            return InOrderHelper(tree).Trim();
		}

        private string InOrderHelper<T>(IBinaryTree<T> tree)
        {
            string output = "";

            if (tree.Left != null)
                output += InOrderHelper(tree.Left);

            output += tree.Value + " ";

            if (tree.Right != null)
                output += InOrderHelper(tree.Right);

            return output;
        }

		public string PostOrder<T>(IBinaryTree<T> tree)
		{
            return PostOrderHelper(tree).Trim();
		}

        public string PostOrderHelper<T>(IBinaryTree<T> tree)
        {
            string output = "";

            if (tree.Left != null)
                output += PostOrderHelper(tree.Left);

            if (tree.Right != null)
                output += PostOrderHelper(tree.Right);

            output += tree.Value + " ";

            return output;
        }
    }
}
