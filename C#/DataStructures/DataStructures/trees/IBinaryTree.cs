namespace DataStructures.trees
{
	public interface IBinaryTree<T>
	{
		IBinaryTree<T> Left { get; }
		IBinaryTree<T> Right { get; }
		T Value { get; }
	}
}
