using System;

namespace DataStructures.filters
{
    public class BloomFilter
    {
        private bool[] filter = new bool[10000];
        
        public void Add(object o)
        {
            // set the bool referring to this object as true
            filter[DefaultHash(o)] = true;
            filter[AlternateHash(o)] = true;
        }

        /// <summary>
        /// since the bloom filter requires multiple hashes, 
        /// this is an alternate function for hashing an object
        /// 
        /// we first hash the object using the SHA256 algorithm, 
        /// then hash the resulting string into an int using
        /// the default system algorithm
        /// </summary>
        private int AlternateHash(object o)
        {
            return Math.Abs(SHA256HashGenerator.GenerateKey(o).GetHashCode() % (filter.Length - 1));
        }

        private int DefaultHash(object o)
        {
            // use the default system hash implementation
            // ensure it's in the array using modulo
            return Math.Abs(o.GetHashCode() % (filter.Length - 1));
        }

        public bool DoesNotContain(object o)
        {
            // if both of the given objects hashes aren't in the array
            // we know it hasn't been added
            // otherwise it MIGHT have been added
            return !(filter[DefaultHash(o)] && filter[AlternateHash(o)]);
        }
    }
}
