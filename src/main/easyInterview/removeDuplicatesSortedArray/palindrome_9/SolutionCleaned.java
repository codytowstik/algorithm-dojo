package main.easyInterview.removeDuplicatesSortedArray.palindrome_9;

class SolutionCleaned
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

        int     a = 0, b = x;

        while ( ( b > 0 ) && ( ( a / b ) < 1 ) )
        {
            int     r = b % 10;

            a = a * 10 + r;

            b /= 10;
        }

        return ( a == b ) || ( a / 10 == b );
    }
}
