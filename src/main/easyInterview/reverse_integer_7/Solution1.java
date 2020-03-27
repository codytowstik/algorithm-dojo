package main.easyInterview.reverse_integer_7;

import main.utils.Solution;

class Solution1 extends Solution
{
    public Object execute(Object input)
    {
        return reverseInteger((int) input);
    }

    /**
     * Reverse Integer.
     * <p>
     * Example:
     * 123 == 321
     * -123 == -321
     * 120 == 21
     * <p>
     * Strategy:
     * Use the strategy we saw in `palindrome_9`.
     * Take the mod 10 remainder of the value, make that your start.
     * <p>
     * Divide the value by 10, and set the reversed = reversed * 10 + new remainder
     *
     * @param x 32-bit signed integer (or smaller)
     * @return the input reversed
     */
    public int reverseInteger(int x)
    {
        int reversed = 0;
        int remainder;

        while ( x != 0 )
        {
            // 123 -> 3
            // 12  -> 2
            // 1   -> 1
            remainder = x % 10;

            if ( ( reversed > (Integer.MAX_VALUE / 10) || ( reversed == Integer.MAX_VALUE / 10 ) && (remainder > 8) ) ||
                 ( reversed < (Integer.MIN_VALUE / 10) || ( reversed == Integer.MIN_VALUE / 10 ) && (remainder < -7) ) )
            {
                return 0;
            }

            // 0 * 10 + 3 = 3
            // 3 * 10 + 2 = 32
            // 1 * 10 + 1 = 321
            reversed = (reversed * 10) + remainder;

            x /= 10;
        }

        return reversed;
    }
}
