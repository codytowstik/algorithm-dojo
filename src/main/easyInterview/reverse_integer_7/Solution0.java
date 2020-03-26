package main.easyInterview.reverse_integer_7;

import main.utils.Solution;

class Solution0 extends Solution
{
    public Object execute(Object input) {
        return reverseInteger((int) input);
    }

    /**
     * Reverse Integer.
     *
     * Example:
     *  123 == 321
     * -123 == -321
     *  120 == 21
     *
     * Strategy:
     * Use the strategy we saw in `palindrome_9`.
     * Take the mod 10 remainder of the value, make that your start.
     *
     * Divide the value by 10, and set the reversed = reversed * 10 + new remainder
     *
     * @param x 32-bit signed integer (or smaller)
     * @return the input reversed
     */
    public int reverseInteger(long x )
    {
        if (x > Integer.MAX_VALUE)
        {
            return 0;
        }

        long     currentNumber = (long) Math.abs(x);
        long     reversed = 0;

        while ( currentNumber > 0 )
        {
            // 123 -> 3
            // 12  -> 2
            // 1   -> 1
            long remainder = currentNumber % 10;

            // 0 * 10 + 3 = 3
            // 3 * 10 + 2 = 32
            // 1 * 10 + 1 = 321
            reversed = (reversed * 10) + remainder;

            if (reversed > Integer.MAX_VALUE)
            {
                return 0;
            }

            currentNumber /= 10;
        }

        return (x > 0) ? (int) reversed : (int) (reversed * -1);
    }
}
