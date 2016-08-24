namespace DataStructures.trees
{
	public interface IBinaryTree<T>
	{
		IBinaryTree<T> GetLeft();
		IBinaryTree<T> GetRight();
		T GetValue();
	}
}
