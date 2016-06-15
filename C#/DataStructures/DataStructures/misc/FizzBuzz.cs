using System.Text;

namespace DataStructures.misc
{
    /// <summary>
    /// The classic "FizzBuzz" interview algorithm
    /// There's no test for this because 
    /// A) It's very simple and 
    /// B) Building the resulting string by hand is a pain
    /// </summary>
    public static class FizzBuzz
    {
        public static string Run()
        {
            StringBuilder sb = new StringBuilder();

            for(var i = 0; i < 100; i++)
            {
                if (i % 3 == 0)
                    sb.Append("Fizz");
                if (i % 5 == 0)
                    sb.Append("Buzz");
                if (!(i % 3 == 0 || i % 5 == 0))
                    sb.Append(i);

                sb.AppendLine();
            }

            return sb.ToString();
        }
    }
}
