namespace DataStructures.trees
{
	public class BinaryTreeTraverser
	{
		public string PreOrder<T>(IBinaryTree<T> tree)
		{
			string output = "";

			output += tree.GetValue() + " ";

			if (tree.GetLeft() != null)
			{
				output += PreOrder(tree.GetLeft());
			}

			if (tree.GetRight() != null)
			{
				output += PreOrder(tree.GetRight());
			}

			return output;
		}

		public string InOrder<T>(IBinaryTree<T> tree)
		{
			string output = "";

			if (tree.GetLeft() != null)
			{
				output += InOrder(tree.GetLeft());
			}

			output += tree.GetValue() + " ";

			if (tree.GetRight() != null)
			{
				output += InOrder(tree.GetRight());
			}

			return output;
		}

		public string PostOrder<T>(IBinaryTree<T> tree)
		{
			string output = "";

			if (tree.GetLeft() != null)
			{
				output += PostOrder(tree.GetLeft());
			}

			output += tree.GetValue() + " ";

			if (tree.GetRight() != null)
			{
				output += PostOrder(tree.GetRight());
			}

			return output;
		}
	}
}
