package main.practice.shopping_cart_raffle;

import java.util.List;

/**
 * Practice for Amazon.
 *
 * Broken:
 * - if the beginning of a later sequence is matched, but isn't correct, but the correct sequence appears later,
 * it incorrectly increments index and fails. e.g. test 8
 * - if sequence starts with any, it will try to match the next item with no fallback, related to problem 1
 *
 * Room for improvement:
 * - It's weird to check if cartIndex == shoppingCart.size() every iteration
 * - edge case if winning sequence starts with one or more "any"
 * - We should separate out logic into functions because this gets kind of hard to follow
 */
public class ShoppingCartRaffle1
{
    public static int isWinner(List<String> shoppingCart, List<List<String>> codeList)
    {
        System.out.println("\nChecking winner status... ");

        // initialize cartIndex to 0

        // for each raffle sequence
            // find the first occurrence of the first item of the raffle sequence in the shopping cart
            // .. starting at the current cart index
                // check if the rest of the sequence is contiguously found in the cart
                    // if yes
                        // add length of sequence to cart index
                        // continue to next sequence

                    // if no,
                        // increment cart index by 1
                        // if cartIndex == cartLength, loser!
                        // keep looking for next occurrence of first item in sequence

            // if not found, loser!

        // found all raffle sequences, winner!

        return 1;
    }
}
