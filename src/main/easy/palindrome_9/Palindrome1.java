package main.easy.palindrome_9;

public class Palindrome1 extends Palindrome
{
    public boolean isPalindrome( int input )
    {
        if ( input < 0 || ( input != 0 && input % 10 == 0) )
        {
            return false;
        }

        if ( input == 0 )
        {
            return true;
        }

        int     reversed = 0;
        int     numToCheck = input;

        // if the current un-reversed number is smaller than the number we are checking .. we are done
        // since we multiply reversed number by 10 and divide number we are checking by 10

        // 12321
        // remainder: 1; reversed: 0*10 + 1
        // 1232.1
        // remainder: 2; reversed: (1 * 10) + 2 = 12
        // 123.21
        // remainder: 3; reversed: (12 * 10) + 3 = 123

        // 3223
        // remainder: 3; reversed: 0*10 + 3
        // 322.3
        // remainder: 2; reversed: (3 * 10) + 2 = 32
        // 32.23
        // remainder: 2; reversed: (32 * 10) + 2 = 322

        while ( ( numToCheck > 0 ) && ( ( reversed / numToCheck ) < 1 ) )
        {
            // get the digit on the right

            int     remainder = numToCheck % 10;

            //  1       12          121
            // multiply by 10 to make sure digit goes in to correct place

            reversed = reversed * 10 + remainder;

            numToCheck /= 10;    // get next digit
        }

        // 0 and negatives will automatically evaluate true and false
        // divide reversed by 10 to handle results crossing for even length numbers
        return ( reversed == numToCheck ) || ( reversed / 10 == numToCheck );
    }
}
