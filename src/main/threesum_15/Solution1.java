package main.threesum_15;

class Solution1
{
    public boolean isPalindrome( int x )
    {
        if ( x < 0 || ( x != 0 && x % 10 == 0) )
        {
            return false;
        }

        if ( x == 0 )
        {
            return true;
        }

        int     reversed = 0;
        int     numToCheck = x;

        // if the current un-reversed number is smaller than the number we are checking .. we are done
        // since we mutiply reversed number by 10 and divide number we are checking by 10

        while ( ( numToCheck > 0 ) && ( ( reversed / numToCheck ) < 1 ) )
        {
            // get the digit on the right

            int     remainder = numToCheck % 10;

            //  1       12          121
            // multiply by 10 to make sure digit goes in to correct place

            reversed = reversed * 10 + remainder;

            numToCheck /= 10;    // get next digit
        }

        // 13531 13 13.5
        // 1331 13 13
        return ( reversed == numToCheck ) || ( reversed / 10 == numToCheck );
    }
}
