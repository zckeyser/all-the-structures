namespace DataStructures.trees
{
	public class BinaryTree<T> : IBinaryTree<T>
	{
		private IBinaryTree<T> left;
		private IBinaryTree<T> right;

		public BinaryTree(T value)
		{
			this.Value = value;
		}

		public IBinaryTree<T> Left { get; set; }
		public IBinaryTree<T> Right { get; set; }
		public T Value { get; set; }
	}
}
