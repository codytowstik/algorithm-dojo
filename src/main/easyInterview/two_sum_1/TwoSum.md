# Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

## Approach 1 - Brute Force

Runtime: O(n^2)

For each element (n) we iterate over all (n) numbers to see if any give us our target. => n * n

Space: O(1)

We don't store anything.

## Approach 2 - Two Pass

Runtime: O(n)

For each element (n), we store the value and index in a hash table(1).
For each element (n), we check if there is a pair in the map that would give us our target (1).
=> n + n => 2n => O(n)

Space: O(n)

We store each value in the hash table.

## Approach 3 - One Pass

For each element (n), we check if a hash table has our required value(1), return if we do, else add the value to our table (1).
=> n * (1 + 1) => 2n => O(n)





