using System;
using DataStructures.trees;

namespace DataStructures.Trees
{
	public class BinarySearchTree<T> : IBinarySearchTree<T> where T : IComparable
	{
		private T value;
		private int count;
		private BinarySearchTree<T> left;
		private BinarySearchTree<T> right;
		private readonly BinarySearchTree<T> parent; 

		public BinarySearchTree(BinarySearchTree<T> parent, T value)
		{
			this.parent = parent;
			this.value = value;
			count = 1;
		}

        /// <summary>
        /// insert value T into the tree, maintaining correct order
        /// </summary>
		public IBinarySearchTree<T> Insert(T toInsert)
		{
			var compareValue = toInsert.CompareTo(value);

			if (compareValue > 0)
			{
				// toInsert > value
				// put it in the right subtree
				if (right == null)
				{
					// if we don't have a right subtree,
					// make one starting with toInsert
					right = new BinarySearchTree<T>(this, toInsert);

					return right;
				}
				else
				{
					// if we have a right subtree, insert into that
					return right.Insert(toInsert);
				}
			}
			else if (compareValue < 0)
			{
				// toInsert < value
				// put it in the left subtree
				if (left == null)
				{
					// if we don't have a left subtree,
					// make one starting with toInsert
					left = new BinarySearchTree<T>(this, toInsert);

					return left;
				}
				else
				{
					// if we have a left subtree, insert into that
					return left.Insert(toInsert);
				}
			}
			else
			{
				// toInsert == value
				// if we already have an instance of toInsert in the tree,
				// increment the counter for the value's node
				count++;
				return this;
			}
		}

        /// <summary>
        /// remove the node with value toRemove from the tree
        /// 
        /// if the node has multiple occurrences (count > 1), 
        /// just decrement its count
        /// </summary>
        /// <param name="toRemove"></param>
		public void Remove(T toRemove)
		{
			if (!Contains(toRemove))
			{
				throw new ArgumentException(string.Format("Value {0} attempted to be removed from a tree which does not contain it", toRemove));
			}

			var compareVal = toRemove.CompareTo(value);

			if (compareVal < 0)
			{
				// toRemove < value
				// the value must be in the left subtree -- remove it from there
				left.Remove(toRemove);
			}
			else if (compareVal > 0)
			{
				// toRemove > value
				// the value must be in the right subtree -- remove it from there
				right.Remove(toRemove);
			}
			else
			{
				// toRemove is equal to value
				if (count > 1)
				{
					// remove an instance from this node
					count--;
				}
				else
				{
					// remove the current node
					if (IsLeaf())
					{
						// if this is a leaf, we can just remove its reference
						parent.ReplaceChild(value, null);
					}
					else
					{
						// find the closest descendant
						var desc = left != null ? left.GreatestDescendant() : right.SmallestDescendant();

						// replace this node's values with that node's values, and remove it
						value = desc.value;
						count = desc.count;

						// get rid of the old copy of the descendant node
						desc.Remove(desc.value);
					}
				}
			}
		}

		private void ReplaceChild(T val, BinarySearchTree<T> replacement)
		{
			if (left != null && left.value.CompareTo(val) == 0)
				left = replacement;
			else if (right != null && right.value.CompareTo(val) == 0)
				right = replacement;
			else
				throw new ArgumentException("attempt to replace child that does not exist", "val");
		}

		private bool IsLeaf()
		{
			return left == null && right == null;
		}

		private BinarySearchTree<T> GreatestDescendant()
		{
			return right != null ? right.GreatestDescendant() : this;
		}

		private BinarySearchTree<T> SmallestDescendant()
		{
			return left != null ? left.SmallestDescendant() : this;
		} 

		public bool Contains(T target)
		{
			var compareVal = target.CompareTo(value);

			if (compareVal == 0)
				return true;
			else if (compareVal < 0 && left != null)
				return left.Contains(target);
			else if (compareVal > 0 && right != null)
				return right.Contains(target);
			else
				return false;
		}

		public IBinaryTree<T> GetLeft()
		{
			return left;
		}

		public IBinaryTree<T> GetRight()
		{
			return right;
		}

		public T GetValue()
		{
			return value;
		}
	}
}
