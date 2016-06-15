using System;

namespace DataStructures.Trees
{
	public class AVLTree<T> : IBinarySearchTree<T> where T : IComparable
	{
		private T value;
		private int count;
		private int height;
		private AVLTree<T> left;
		private AVLTree<T> right;
		private AVLTree<T> parent; 

		public AVLTree(AVLTree<T> parent, T value)
		{
			this.parent = parent;
			this.value = value;
			count = 1;
			height = parent != null ? parent.height + 1 : 1;
		}

		#region Modified BST Methods
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
					right = new AVLTree<T>(this, toInsert);

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
					left = new AVLTree<T>(this, toInsert);

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
		#endregion

		#region AVL Methods
		private AVLTree<T> RotateRight()
		{
			// get nodes involved in rotation
			var leftTmp = left;
			var leftChildTmp = left.right;

			// perform rotation
			left = leftChildTmp;
			leftTmp.right = this;

			// update heights
			leftTmp.height = System.Math.Max(leftTmp.left.height, leftTmp.right.height) + 1;
			leftChildTmp.height = System.Math.Max(leftChildTmp.left.height, leftChildTmp.right.height) + 1;

			return leftTmp;
		}

		private AVLTree<T> RotateLeft()
		{
			// get nodes involved in rotation
			var rightTmp = right;
			var rightChildTmp = right.left;

			// perform rotation
			right = rightChildTmp;
			rightTmp.left = this;

			// update heights
			rightTmp.height = System.Math.Max(rightTmp.left.height, rightTmp.right.height) + 1;
			rightChildTmp.height = System.Math.Max(rightChildTmp.left.height, rightChildTmp.right.height) + 1;

			return rightTmp;
		}

		private int BalanceFactor()
		{
			var leftHeight = left != null ? left.height : 0;
			var rightHeight = right != null ? right.height : 0;

			return leftHeight - rightHeight;
		}
		#endregion

		#region BST Methods
		private void ReplaceChild(T val, AVLTree<T> replacement)
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

		private AVLTree<T> GreatestDescendant()
		{
			return right != null ? right.GreatestDescendant() : this;
		}

		private AVLTree<T> SmallestDescendant()
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
		#endregion
	}
}
