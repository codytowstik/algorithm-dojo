package main.easy.palindrome_9;

public class Palindrome0 extends Palindrome
{
    public boolean isPalindrome( int input )
    {
        if ( input < 0 )
        {
            return false;
        }

        if ( input < 10 )
        {
            return true;
        }

        int     orderOfMagnitude = (int) Math.floor(Math.log10( input ));

        // number n with magnitude m can only have ( m + 1 ) digits .. 100, mag 2, digits 3

        // get the digit pairs, checking on each pair if it is a matching pair
        // 1234 / 1 % 10 == 4               (n) 4
        // 1234 / 1000 = 1 % 10 = 1     (0) 1

        // 1234 / 10 == 123.4 % 10 = 3  (n-1) 3
        // 1234 / 100 == 12.34 % 10 = 2 (n-2) 2

        // get n-1

        // 1234 has magnitude 3, 10^3 = 1000

        int     rightDivisor = 1;
        int     leftDivisor = (int) Math.pow( 10, orderOfMagnitude);

        // 121 (2) == 2, 1221 (3), == 4, 12321(4) = 4, 123321(5) = 6, 1234321(6) = 6
        int     maxDigitsToCheck = ( orderOfMagnitude + 1 ) / 2;

        for( int digitIndex = 0; digitIndex < maxDigitsToCheck; digitIndex++ )
        {
            // x divided by 10^digitIndex .. result mod by 10 to get number

            // right == digitIndex == 0
            // left == orderOfMagnitude == 3

            // 1234 / 1             1234 / 10^0
            // 1234 / 1000          1234 / 10^3

                        ////// if it continued:
                        // right == digitIndex == 1
                        // left == orderOfMagnitude - digitIndex = 2

                        // 1234 / 10            1234 / 10^1
                        // 1234 / 100           1234 / 10^2

            // 1234/1 = 1234
            int         numScaledRight = ( input / rightDivisor );

            // 1234/1000 = 1.234 (int floors)
            int         numScaledLeft = ( input / leftDivisor );

            // 1234 % 10 = 4
            int         rightDigit = ( numScaledRight % 10 );

            // 1 % 10 = 1
            int         leftDigit = ( numScaledLeft % 10 );

            if ( rightDigit != leftDigit )
            {
                return false;
            }

            // increment

            rightDivisor *= 10;
            leftDivisor /= 10;
        }

        return true;
    }
}
