package main.easy.happy_number_202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber0 extends HappyNumber
{
    /**
     * Brute force.
     *
     *  Runtime: 1ms, 84.19%
     *
     *  Has to go through as many iterations as there are numbers until sum of squares == 1
     *
     *  Space: 36.8mb, 6.06%
     *
     *  Stores a new number in the set for each number we encounter, so 'n' is as big as the maximum loop size 'm'
     *  ... O(m)
     *
     * calculate the sum of the squares of the number, storing each value we have found in a set
     * .. if we find a number that we have already encountered, it will loop endlessly, so return false
     * .. if we get 1, return true
     *
     * @param input
     * @return
     */
    public boolean isHappy(int input)
    {
        Set<Integer>    encounteredNumbers = new HashSet<>();

        int             sumOfSquares = input;

        while (true)
        {
            sumOfSquares = getSumOfSquares(sumOfSquares);

            if (sumOfSquares == 1)
            {
                return true;
            }

            if (encounteredNumbers.contains(sumOfSquares))
            {
                return false;
            }
            else
            {
                encounteredNumbers.add(sumOfSquares);
            }
        }
    }

    public int getSumOfSquares(int value)
    {
        int     sumOfSquares = 0;

        while (value > 0)
        {
            int     lastDigit = value % 10;

            sumOfSquares = sumOfSquares + lastDigit * lastDigit;

            value /= 10;
        }

        return sumOfSquares;
    }
}
