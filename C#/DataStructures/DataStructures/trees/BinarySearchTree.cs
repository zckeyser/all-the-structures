using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures.trees
{
	public class BinarySearchTree<T> where T : IComparable
	{
		private T value;
		private int count;
		private BinarySearchTree<T> left;
		private BinarySearchTree<T> right;
		private BinarySearchTree<T> parent; 

		public BinarySearchTree(BinarySearchTree<T> parent, T value)
		{
			this.parent = parent;
			this.value = value;
			this.count = 1;
		}

		public BinarySearchTree<T> Insert(T val)
		{
			var compareValue = val.CompareTo(value);

			if (compareValue > 0)
			{
				if (right == null)
				{
					right = new BinarySearchTree<T>(this, val);

					return right;
				}
				else
				{
					return right.Insert(val);
				}
			}
			else if (compareValue < 0)
			{
				if (left == null)
				{
					left = new BinarySearchTree<T>(this, val);

					return left;
				}
				else
				{
					return right.Insert(val);
				}
			}
			else
			{
				count++;
				return this;
			}
		}

		public void Remove(T val)
		{
			if (!Contains(val))
			{
				throw new ArgumentException(string.Format("Value {0} attempted to be removed from a tree which does not contain it", val));
			}

			var compareVal = val.CompareTo(value);

			if (compareVal < 0)
			{
				left.Remove(val);
			}
			else if (compareVal > 0)
			{
				right.Remove(val);
			}
			else
			{
				if (IsLeaf())
				{

				}
				else if (HasSingleChild())
				{

				}
				else
				{
					
				}
			}
		}

		private void ReplaceChild(T val, BinarySearchTree<T> replacement)
		{
			if (left != null && left.value.CompareTo(val) == 0)
			{
				left = replacement;
				return;
			}
			else if (right != null && right.value.CompareTo(val) == 0)
			{
				right = replacement;
				return;
			}

			throw new ArgumentException("attempt to replace child that does not exist", "val");
		}

		private bool IsLeaf()
		{
			return left == null && right == null;
		}

		private bool HasSingleChild()
		{
			// ^ is XOR
			return left != null ^ right != null;
		}

		private BinarySearchTree<T> GreatestChild()
		{
			return right != null ? right.GreatestChild() : this;
		}

		public bool Contains(T val)
		{
			
		}
	}
}
