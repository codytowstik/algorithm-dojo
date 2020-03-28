# Approach

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

## Final Approach

Time Complexity: **On**

Space Complexity: **O1**

This approach focused building up the left half, then comparing it to
 the right half all in one go .. with a an early exit strategy. Since we multiply
 the reversed value by 10 and divide the original value by 10 (each time) .. we know
 that at some point the values will cross.
 
 At some point for an odd number of digits value, like 1335331, we will have the numbers
 be offset by an order of magnitude, like 1335 and 133. It doesn't matter which value
 has the extra digit .. so we can exit out.
 
 If we exit out in this manner, we check for equal values
 
    1331 -> 13 == 13
    
    1335331 -> 133 != 1335 .. 133 == (1335/10)

So .. we know:

    number n with magnitude m can only have ( m + 1 ) digits .. 100, mag 2, digits 3
    
    1234 / 1 % 10 == 4           (n) 4
    1234 / 1000 = 1 % 10 = 1     (0) 1
    
    1234 / 10 == 123.4 % 10 = 3  (n-1) 3
    1234 / 100 == 12.34 % 10 = 2 (n-2) 2
    
    1234 has magnitude 3, 10^3 = 1000

    
So we check each end, see if it is equal .. if not we exit out.

How is this fast?

    - We only need to build up half of the number to see if it is a palindrome
    - We can exit early

How is this slow?

    - We have to build up the entire half of the number to see if it is a palindrome

## Approach 1

Time Complexity: **On**

Space Complexity: **O1**

My first approach focused on early exit strategies, trying to compare the first and last digits,
then returning false if they weren't equal. If at the end none of them are unequal, we have found
a palindrome.

We know:

    number n with magnitude m can only have ( m + 1 ) digits .. 100, magnitude 2, digits 3
    
    1234 / 1 % 10 == 4           (n) 4
    1234 / 1000 = 1 % 10 = 1     (0) 1
    
    1234 / 10 == 123.4 % 10 = 3  (n-1) 3
    1234 / 100 == 12.34 % 10 = 2 (n-2) 2
    
    1234 has magnitude 3, 10^3 = 1000

    
So we check each end, see if it is equal .. if not we exit out.

How is this fast?

    - If it is a long Number, we exit out early

How is this slow?

    - If it is a palindrome (or isn't but the non-pairs appear closer to the center)
    then we won't gain any time in exiting out early
    
    - We incremement/decrememnt the left and right divisors rather than the number itself
    so it is a lot of large-number operations.
    
    - We do repeat operations and aren't efficient with our calculations





