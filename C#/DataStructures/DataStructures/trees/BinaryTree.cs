namespace DataStructures.Trees
{
	public class BinaryTree<T>
	{
		private T value;
		private BinaryTree<T> left;
		private BinaryTree<T> right;

		public BinaryTree(T value)
		{
			this.value = value;
		}

		public void SetLeft(BinaryTree<T> left)
		{
			this.left = left;
		}

		public BinaryTree<T> GetLeft()
		{
			return left;
		}

		public void SetRight(BinaryTree<T> right)
		{
			this.right = right;
		}

		public BinaryTree<T> GetRight()
		{
			return right;
		}

		public void SetValue(T value)
		{
			this.value = value;
		}

		public T GetValue()
		{
			return value;
		}
	}
}
