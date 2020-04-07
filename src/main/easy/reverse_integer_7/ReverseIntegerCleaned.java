package main.easy.reverse_integer_7;

import main.utils.Solution;

class ReverseIntegerCleaned extends ReverseInteger
{
    /**
     * Reverse Integer.
     *
     * Example:
     * 123 == 321
     * -123 == -321
     * 120 == 21
     *
     * Strategy: Solution0
     *
     * @param x 32-bit signed integer (or smaller)
     * @return the input reversed
     */
    public int reverseInteger(int x)
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
