using System.Collections;
using System.Collections.Generic;

namespace DataStructures.stack
{
    public class Stack<T> : IEnumerable<T>
    {
        private List<T> values = new List<T>();

        public int Size { get { return values.Count; } }
        public bool Empty { get { return values.Count == 0; } }

        public void Push(T val)
        {
            values.Add(val);
        }

        public T Pop()
        {
            T retval = values[values.Count - 1];
            values.RemoveAt(values.Count - 1);

            return retval;
        }

        public IEnumerator<T> GetEnumerator()
        {
            while (!Empty)
                yield return Pop();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            while (!Empty)
                yield return Pop();
        }
    }
}
