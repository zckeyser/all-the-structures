using System;

namespace DataStructures.Trees
{
	public interface IBinarySearchTree<in T> where T : IComparable
	{
		IBinarySearchTree<T> Insert(T toInsert);
		void Remove(T toRemove);
		bool Contains(T target);
	}
}
