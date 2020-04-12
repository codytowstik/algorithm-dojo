package main.easy.happy_number_202;

import main.easy.palindrome_9.Palindrome;

public class HappyNumber1 extends HappyNumber
{
    /**
     * Floyd cycle detection algorithm.
     *
     * Runtime: 0ms, 100%
     *
     * Needs to calculate sum of squares multiple times for each successful number, but shortcuts
     * to finish if 'fast' pointer gets a result or the first time we encounter a cycle number
     *
     * Space: 36.7mb, 6%
     *
     * Stores nothing.
     *
     * instead of adding to a set and storing any memory...
     * advance a 'fast' pointer an additional time each cycle
     * - if the fast pointer == 1 (so we will eventually see this value), return true
     * - if the fast pointer == the slow pointer, we've found a cycle
     *
     * @param input
     * @return
     */
    public boolean isHappy( int input )
    {
        int     sumOfSquaresSlow = input;
        int     sumOfSquaresFast = input;

        while(true)
        {
            sumOfSquaresSlow = getSumOfSquares(sumOfSquaresSlow);
            sumOfSquaresFast = getSumOfSquares(sumOfSquaresFast);
            sumOfSquaresFast = getSumOfSquares(sumOfSquaresFast);

            // found success
            if (sumOfSquaresFast == 1)
            {
                return true;
            }

            // found cycle
            if (sumOfSquaresFast == sumOfSquaresSlow)
            {
                return false;
            }
        }
    }

    public int getSumOfSquares(int value)
    {
        int sumOfSquares = 0;

        while (value > 0)
        {
            int lastDigit = value % 10;

            sumOfSquares = sumOfSquares + lastDigit * lastDigit;

            value /= 10;
        }

        return sumOfSquares;
    }
}
