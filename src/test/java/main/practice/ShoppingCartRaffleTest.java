package main.practice;

import main.practice.shopping_cart_raffle.ShoppingCartRaffle0;
import main.practice.table_manufacturing.TableManufacturing0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice for Amazon.
 *
 * The grocery store is doing a raffle. Each person has a list of items that represents their shopping cart.
 * You are given a list containing sequences of fruit that a shopping cart
 * must contain in order to win the raffle. The order of the sequences matter, the order of items within each sequence
 * matter, and each item in a sequence must be found contiguously within a shopping cart to  be a winner.
 * Sequences may also contain "any", which represent any kind of fruit.
 *
 * Return 1 if shopper is a winner, otherwise 0.
 *
 * Cart items can not match multiple times.
 *
 * Examples:
 * Cart: [Apple]
 * Seq:  [[Apple]]
 * Winner: True
 *
 * Cart: [Apple, Orange]
 * Seq: [[Orange], [Apple]]
 * Winner: False, items in cart not in the right order
 *
 * Cart: [Apple, Orange, Pear, Apple]
 * Seq: [[Apple], [Orange,Apple]]
 * Winner: False, items not contiguous
 *
 * Cart: [Apple, Orange, Pear, Apple]
 * Seq: [[Apple], [Any, Apple]]
 * Winner: True
 *
 * Cart: [Apple]
 * Seq: [[Apple, Any]]
 * Winner: False, No match for apple
 *
 * Cart: [Apple]
 * Seq: [[Apple], [Apple]]
 * Winner: False, fruit can't be matched multiple times.
 *
 * Cart: [Apple, Orange, Pear, Apple]
 * Seq: [[Apple], [Pear, Any]]
 * Winner: True
 */
public final class ShoppingCartRaffleTest
{
    private static List<String> cart1 = new ArrayList<>();
    private static List<List<String>> seq1 = new ArrayList<>();
    private static int result1;

    private static List<String> cart2 = new ArrayList<>();
    private static List<List<String>> seq2 = new ArrayList<>();
    private static int result2;

    private static List<String> cart3 = new ArrayList<>();
    private static List<List<String>> seq3 = new ArrayList<>();
    private static int result3;

    private static List<String> cart4 = new ArrayList<>();
    private static List<List<String>> seq4 = new ArrayList<>();
    private static int result4;

    private static List<String> cart5 = new ArrayList<>();
    private static List<List<String>> seq5 = new ArrayList<>();
    private static int result5;

    private static List<String> cart6 = new ArrayList<>();
    private static List<List<String>> seq6 = new ArrayList<>();
    private static int result6;

    private static List<String> cart7 = new ArrayList<>();
    private static List<List<String>> seq7 = new ArrayList<>();
    private static int result7;

    @BeforeAll
    public static void beforeAll()
    {
        // Cart: [Apple]
        // Seq:  [[Apple]]
        // Winner: True
        cart1.add("apple");

        seq1.add(List.of("apple"));

        result1 = 1;

        // Cart: [Apple, Orange]
        // Seq: [[Orange], [Apple]]
        // Winner: False, items in cart not in the right order
        cart2.add("apple");
        cart2.add("orange");

        seq2.add(List.of("orange"));
        seq2.add(List.of("apple"));

        result2 = 0;

        // Cart: [Apple, Orange, Pear, Apple]
        // Seq: [[Apple], [Orange,Apple]]
        // Winner: False, items not contiguous
        cart3.add("apple");
        cart3.add("orange");
        cart3.add("pear");
        cart3.add("apple");

        seq3.add(List.of("apple"));
        seq3.add(List.of("orange", "apple"));

        result3 = 0;

        // Cart: [Apple, Orange, Pear, Apple]
        // Seq: [[Apple], [Any, Apple]]
        // Winner: True, careful that "any" doesn't start consuming once "orange" is encountered
        cart4.add("apple");
        cart4.add("orange");
        cart4.add("pear");
        cart4.add("apple");

        seq4.add(List.of("apple"));
        seq4.add(List.of("any", "apple"));

        result4 = 1;

        // Cart: [Apple]
        // Seq: [[Apple, Any]]
        // Winner: False, No match for apple
        cart5.add("apple");

        seq5.add(List.of("apple", "any"));

        result5 = 0;

        // Cart: [Apple]
        // Seq: [[Apple], [Apple]]
        // Winner: False, fruit can't be matched multiple times.
        cart6.add("apple");

        seq6.add(List.of("apple"));
        seq6.add(List.of("apple"));

        result6 = 0;

        // Cart: [Apple, Orange, Pear, Apple]
        // Seq: [[Apple], [Pear, Any]]
        // Winner: True
        cart7.add("apple");
        cart7.add("orange");
        cart7.add("pear");
        cart7.add("apple");

        seq7.add(List.of("apple"));
        seq7.add(List.of("pear", "any"));
    }

    @Test
    public void shoppingCartRaffle0Test()
    {
        Assertions.assertEquals(result1, ShoppingCartRaffle0.isWinner(cart1, seq1), "1: ");
        Assertions.assertEquals(result2, ShoppingCartRaffle0.isWinner(cart2, seq2), "2: ");
        Assertions.assertEquals(result3, ShoppingCartRaffle0.isWinner(cart3, seq3), "3: ");
//        Assertions.assertEquals(result4, ShoppingCartRaffle0.isWinner(cart4, seq4), "4: ");
        Assertions.assertEquals(result5, ShoppingCartRaffle0.isWinner(cart5, seq5), "5: ");
        Assertions.assertEquals(result6, ShoppingCartRaffle0.isWinner(cart6, seq6), "6: ");
        Assertions.assertEquals(result7, ShoppingCartRaffle0.isWinner(cart7, seq7), "7: ");
    }
}
