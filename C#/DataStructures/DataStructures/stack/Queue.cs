using System;
using System.Collections;
using System.Collections.Generic;

namespace DataStructures.stack
{
    public class Queue<T> : IEnumerable<T>
    {
        private List<T> values = new List<T>();

        public int Size { get { return values.Count; } }
        public bool Empty { get { return values.Count == 0; } }

        public void Enqueue(T val)
        {
            values.Add(val);
        }

        public T Dequeue()
        {
            if(Empty)
            {
                Console.WriteLine("Warning: Attempt to dequeue from empty queue");
                return default(T);
            }

            T retval = values[0];
            values.RemoveAt(0);

            return retval;
        }

        public IEnumerator<T> GetEnumerator()
        {
            while (!Empty)
                yield return Dequeue();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            while (!Empty)
                yield return Dequeue();
        }
    }
}
