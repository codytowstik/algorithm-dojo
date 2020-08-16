package main.practice;

import main.practice.shopping_cart_raffle.ShoppingCartRaffle0;
import main.practice.table_manufacturing.TableManufacturing0;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Practice for Amazon.
 */
public final class ShoppingCartRaffleTest
{
    @Test
    public void shoppingCartRaffle0Test()
    {
        // shopping cart in map
        // save total number of fruits in cart

        // [[1,2,3],[3,2,1]]

        List<String> shoppingCart = new ArrayList<>();

        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("orange");
        shoppingCart.add("banana");
        shoppingCart.add("pear");
        shoppingCart.add("pizza");

        List<List<String>> codeList = new ArrayList<>();

        List<String>    code1 = new ArrayList<>();
        List<String>    code2 = new ArrayList<>();
        List<String>    code3 = new ArrayList<>();

        code1.add("orange");

        code2.add("banana");
        code2.add("pear");
        code2.add("egg");

        codeList.add(code1);
        codeList.add(code2);

        ShoppingCartRaffle0.isWinner(shoppingCart, codeList);
    }
}
