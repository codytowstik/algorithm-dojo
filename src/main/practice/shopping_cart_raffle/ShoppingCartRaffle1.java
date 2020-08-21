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
        int cartIndex = 0;

        // for each raffle sequence
        for (List<String> raffleSequence : codeList)
        {
            boolean isSequenceFound = false;

            while(!isSequenceFound)
            {
                // find the first occurrence of the first item of the raffle sequence in the shopping cart
                // .. starting at the current cart index
                int firstSequenceItemIndex = findItemStartingAtIndex(raffleSequence.get(0), cartIndex, shoppingCart);

                // if not found, loser!
                if (firstSequenceItemIndex == -1)
                {
                    System.out.println("first item not found, loser");
                    return 0;
                }

                // check if the rest of the sequence is contiguously found in the cart
                isSequenceFound = isContiguousSequenceFound(shoppingCart, cartIndex, raffleSequence);

                if (isSequenceFound)
                {
                    // add length of sequence to cart index
                    cartIndex += raffleSequence.size();
                }
                else
                {
                    // increment cart index by 1
                    ++cartIndex;
                    // if cartIndex == cartLength, loser!
                    if (cartIndex == shoppingCart.size())
                    {
                        System.out.println("cart length exceeded, loser");
                        return 0;
                    }
                    // keep looking for next occurrence of first item in sequence
                }
            }
        }
        // found all raffle sequences, winner!

        return 1;
    }

    private static int findItemStartingAtIndex(String itemToFind, int startIndex, List<String> shoppingCart)
    {
        if (itemToFind.equals("any"))
        {
            return startIndex;
        }
        else
        {
            return shoppingCart.subList(startIndex, shoppingCart.size()).indexOf(itemToFind);
        }
    }

    private static boolean isContiguousSequenceFound(List<String> shoppingCart, int startIndex, List<String> raffleSequence)
    {
        int raffleSequenceLength = raffleSequence.size();

        for (int i = 1; i < raffleSequenceLength; i++)
        {
            int currentCartIndex = startIndex + i;

            String raffleSequenceItem = raffleSequence.get(i);

            if (currentCartIndex < shoppingCart.size() &&
                    (raffleSequenceItem.equals("any") || raffleSequenceItem.equals(shoppingCart.get(currentCartIndex))))
            {
                continue;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
