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

            output += tree.GetValue() + " ";

            if (tree.GetLeft() != null)
                output += PreOrderHelper(tree.GetLeft());

            if (tree.GetRight() != null)
                output += PreOrderHelper(tree.GetRight());

            return output;
        }

		public string InOrder<T>(IBinaryTree<T> tree)
		{
            return InOrderHelper(tree).Trim();
		}

        private string InOrderHelper<T>(IBinaryTree<T> tree)
        {
            string output = "";

            if (tree.GetLeft() != null)
                output += InOrderHelper(tree.GetLeft());

            output += tree.GetValue() + " ";

            if (tree.GetRight() != null)
                output += InOrderHelper(tree.GetRight());

            return output;
        }

		public string PostOrder<T>(IBinaryTree<T> tree)
		{
            return PostOrderHelper(tree).Trim();
		}

        public string PostOrderHelper<T>(IBinaryTree<T> tree)
        {
            string output = "";

            if (tree.GetLeft() != null)
                output += PostOrderHelper(tree.GetLeft());

            if (tree.GetRight() != null)
                output += PostOrderHelper(tree.GetRight());

            output += tree.GetValue() + " ";

            return output;
        }
    }
}
