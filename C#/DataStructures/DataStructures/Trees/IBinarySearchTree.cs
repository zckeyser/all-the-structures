using System;
using DataStructures.trees;

namespace DataStructures.Trees
{
	public interface IBinarySearchTree<T> : IBinaryTree<T> where T : IComparable
	{
		IBinarySearchTree<T> Insert(T toInsert);
		void Remove(T toRemove);
		bool Contains(T target);
	}
}
