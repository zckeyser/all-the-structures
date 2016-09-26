using System;
using System.Collections;
using System.Collections.Generic;

namespace DataStructures.dictionary
{
    public class Dict<TKey, TValue> : IEnumerable<System.Collections.Generic.KeyValuePair<TKey, TValue>>
    {
        private const int DEFAULT_BUCKET_COUNT = 1024;

        #region KeyValuePair
        /// <summary>
        /// class used to represent the key-value pairs in buckets,
        /// which use the linked list strategy for collisions (as opposed to rollover)
        /// </summary>
        private class KeyValuePair<UKey, UValue>
        {
            public UKey Key { get; set; }
            public UValue Value { get; set; }
            public KeyValuePair<UKey, UValue> Next { get; set; }

            public KeyValuePair(UKey key, UValue value)
            {
                Key = key;
                Value = value;
            }
        }
        #endregion

        private KeyValuePair<TKey, TValue>[] Data { get; set; }

        public int Size
        {
            get
            {
                int size = 0;

                for(int i = 0; i < Data.Length; i++)
                {
                    var curr = Data[i];

                    // sum size of bucket
                    while (curr != null)
                    {
                        size++;
                        curr = curr.Next;
                    }
                }

                return size;
            }
        }

        public Dict()
        {
            Data = new KeyValuePair<TKey, TValue>[DEFAULT_BUCKET_COUNT];
        }

        public TValue this[TKey key]
        {
            get
            {
                return Get(key);
            }
            set
            {
                Set(key, value);
            }
        }

        private void Set(TKey key, TValue value)
        {
            int index = System.Math.Abs(key.GetHashCode() % Data.Length);

            if (Data[index] == null || Data[index].Key.Equals(key))
                Data[index] = new KeyValuePair<TKey, TValue>(key, value);
            else
            {
                // collision -- try to find the value in the list to 
                // override or else add it to the end of the bucket
                var curr = Data[index];

                while(curr.Next != null)
                {
                    // overwrite the existing value if this key is already in the dict
                    if(curr.Next.Key.Equals(key))
                    {
                        curr.Next.Value = value;
                        return;
                    }

                    curr = curr.Next;
                }

                // we didn't find this key, so we'll add it
                curr.Next = new KeyValuePair<TKey, TValue>(key, value);
            }
        }

        private TValue Get(TKey key)
        {
            var index = System.Math.Abs(key.GetHashCode() % Data.Length);

            if (Data[index] == null)
                throw new ArgumentException(string.Format("Key %s was not found in Dict on Get", key.ToString()));
            else
            {
                // try to find it in the bucket

                var curr = Data[index];

                while(curr != null)
                {
                    if (curr.Key.Equals(key))
                        return curr.Value;

                    curr = curr.Next;
                }

                // we couldn't find it
                throw new ArgumentException(string.Format("Key %s was not found in Dict on Get", key.ToString()));
            }
        }

        public bool ContainsKey(TKey key)
        {
            var index = System.Math.Abs(key.GetHashCode() % Data.Length);

            if (Data[index] == null)
                return false;
            else if (Data[index].Key.Equals(key))
                return true;
            else
            {
                // it's a collision -- we'll need to try 
                // to find it in the bucket

                var curr = Data[index].Next;

                while (curr != null)
                {
                    if (curr.Key.Equals(key))
                        return true;

                    curr = curr.Next;
                }

                // we couldn't find it
                return false;
            }
        }

        /// <summary>
        /// clear all key-value pairs from the Dict
        /// </summary>
        public void Clear()
        {
            for (int i = 0; i < Data.Length; i++)
                Data[i] = null;
        }

        IEnumerator<System.Collections.Generic.KeyValuePair<TKey, TValue>> IEnumerable<System.Collections.Generic.KeyValuePair<TKey, TValue>>.GetEnumerator()
        {
            foreach(var bucket in Data)
            {
                var curr = bucket;

                while(curr != null)
                {
                    yield return new System.Collections.Generic.KeyValuePair<TKey, TValue>(curr.Key, curr.Value);
                    curr = curr.Next;
                }
            }
        }

        public IEnumerator GetEnumerator()
        {
            foreach (var bucket in Data)
            {
                var curr = bucket;

                while (curr != null)
                {
                    yield return new System.Collections.Generic.KeyValuePair<TKey, TValue>(curr.Key, curr.Value);
                    curr = curr.Next;
                }
            }
        }
    }
}
