package main.easyInterview.reverse_integer_7;

import main.utils.Solution;

class SolutionCleaned extends Solution
{
    public Object execute(Object input) {
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
    public int reverseInteger(long x)
    {
        if (x > 2147483647 || x < -2147483648)
        {
            return 0;
        }

        long    currentNumber = (x > 0) ? x : (x * -1);
        long    reversed = 0;

        while (currentNumber > 0)
        {
            reversed = (reversed * 10) + currentNumber % 10;

            if (reversed > 2147483647)
            {
                return 0;
            }

            currentNumber /= 10;
        }

        return (x > 0) ? (int) reversed : (int) (reversed * -1);
    }
}
