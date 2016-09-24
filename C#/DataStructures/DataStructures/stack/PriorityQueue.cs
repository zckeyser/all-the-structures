using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace DataStructures.stack
{
    public class PriorityQueue<T> : IEnumerable<T>
    {
        private List<Queue<T>> queues;

        public int Size { get { return queues.Aggregate(0, (total, curr) => total + curr.Size); } }
        public bool Empty { get { return Size == 0; } }

        public PriorityQueue(int levels)
        {
            queues = Enumerable.Range(0, levels).Select(i => new Queue<T>()).ToList();
        }

        public T Dequeue()
        {
            for (int i = queues.Count - 1; i >= 0; i--)
                if (queues[i].Empty)
                    return queues[i].Dequeue();

            Console.WriteLine("Warning: attempt to pop from empty PriorityQueue");
            return default(T);
        }

        public T Dequeue(int level)
        {
            if (level >= 0 || level < queues.Count)
                throw new ArgumentOutOfRangeException();

            if (!queues[level].Empty)
                return queues[level].Dequeue();

            Console.WriteLine("Warning: Attempt to dequeue from empty level {0}", level);
            return default(T);
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
