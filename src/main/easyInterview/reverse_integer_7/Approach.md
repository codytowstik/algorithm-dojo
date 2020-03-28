# Approach

Reverse an integer. Assume the integer is limited to a signed 32 bit value.

    Example:
     123 == 321
    -123 == -321
     120 == 21

## Final Approach

Time Complexity: **On**

Space Complexity: **O1**

Since we know the value is limited to the size of an `int` we can use `long` values when computing
the reversal and not have to worry about any overflow.







