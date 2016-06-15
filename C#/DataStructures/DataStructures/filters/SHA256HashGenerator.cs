using System;
using System.IO;
using System.Reflection;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Security.Cryptography;
using System.Text;

namespace DataStructures.Filters
{
    /// <summary>
    /// Class to generate a SHA256 key from a given object
    /// slight modification of the MD5 Hash code found here:
    /// http://www.codeproject.com/Articles/21312/Generating-MD-Hash-out-of-C-Objects
    /// </summary>
    class SHA256HashGenerator
    {
        public static string GenerateKey(object sourceObject)
        {
            string hashString;

            //Catch unuseful parameter values
            if (sourceObject == null)
            {
                throw new ArgumentNullException("Null as parameter is not allowed");
            }
            else
            {
                //We determine if the passed object is really serializable.
                try
                {
                    //Now we begin to do the real work.
                    hashString = ComputeHash(ObjectToByteArray(sourceObject));
                    return hashString;
                }
                catch (AmbiguousMatchException ame)
                {
                    throw new ApplicationException("Could not definitely decide if object is serializable. Message:" + ame.Message);
                }
            }
        }

        private static string ComputeHash(byte[] objectAsBytes)
        {
            SHA256 sha256 = new SHA256CryptoServiceProvider();
            try
            {
                byte[] result = sha256.ComputeHash(objectAsBytes);

                // Build the final string by converting each byte
                // into hex and appending it to a StringBuilder
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < result.Length; i++)
                {
                    sb.Append(result[i].ToString("X2"));
                }

                // And return it
                return sb.ToString();
            }
            catch (ArgumentNullException e)
            {
                // If something occurred during serialization, 
                // this method is called with a null argument. 
                Console.WriteLine("Hash has not been generated.");
                return null;
            }
        }

        private static readonly object locker = new object();

        /// <summary>
        /// Converts an object to a byte array
        /// this is necessary so we can pass it
        /// into the hashing function
        /// </summary>
        private static byte[] ObjectToByteArray(object objectToSerialize)
        {
            using (var fs = new MemoryStream())
            {
                try
                {
                    BinaryFormatter formatter = new BinaryFormatter();

                    //Here's the core functionality! One Line!
                    //To be thread-safe we lock the object
                    lock (locker)
                    {
                        formatter.Serialize(fs, objectToSerialize);
                    }

                    return fs.ToArray();
                }
                catch (SerializationException se)
                {
                    Console.WriteLine("Error occurred during serialization. Message: {0}", se.Message);
                    return null;
                }
            }
        }
    }
}
