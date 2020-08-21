package main.practice.shopping_cart_raffle;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice for Amazon.
 *
 * Room for improvement:
 * - It's weird to check if cartIndex == shoppingCart.size() every iteration
 * - edge case if winning sequence starts with one or more "any"
 * - We should separate out logic into functions because this gets kind of hard to follow
 */
public class ShoppingCartRaffle0
{
    public static int isWinner(List<String> shoppingCart, List<List<String>> codeList)
    {
        System.out.println("\nChecking winner status... ");
        int cartIndex = 0;

        // for each group
        for (List<String> group : codeList)
        {
            String firstGroupItem = group.get(0);

            // find first instance of that fruit
            // for each item (i=0) in shopping cart (starting at current fruit index)
            for (; cartIndex <= shoppingCart.size(); cartIndex++)
            {
                if (cartIndex == shoppingCart.size())
                {
                    //
                    System.out.println("Loser, no match found");
                    return 0;
                }
                else if ((shoppingCart.get(cartIndex).equals(firstGroupItem) || firstGroupItem.equals("any")))
                {
                    // match! increment
                    ++cartIndex;

                    // if group is of size one, for loop skips and we continue on to the next group
                    for (int groupIndex = 1; groupIndex < group.size(); groupIndex++)
                    {
                        if (cartIndex == shoppingCart.size())
                        {
                            // loser, no cart left to match
                            System.out.println("loser, no cart left to match");
                            return 0;
                        }
                        else
                        {
                            String currentCartItem = shoppingCart.get(cartIndex);

                            if (!group.get(groupIndex).equals(currentCartItem))
                            {
                                // loser, contiguous group not found
                                System.out.println("group not found");
                                return 0;
                            }

                            // match! increment
                            ++cartIndex;
                        }
                    }

                    // found the whole group, on to next group
                    break;
                }
            }
        }

        // we have exhausted all of the group items, so all matches must have been found
        // winner
        System.out.println("winner!");
        return 1;
    }
}
