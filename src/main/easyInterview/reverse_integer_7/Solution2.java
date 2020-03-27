package main.easyInterview.reverse_integer_7;

import main.utils.Solution;

class Solution2 extends Solution
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
        if ( x == Integer.MIN_VALUE ) return 0;

        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));

        final long result = Long.parseLong(sb.reverse().toString());

        if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return (x < 0) ? (int) result * -1 : (int) result;
    }
}
