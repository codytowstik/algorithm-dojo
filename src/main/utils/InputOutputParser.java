package main.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputOutputParser
{
    private static final String ARRAY_ITEM_DELIMITER = ",";
    private static final String SUB_ARRAY_DELIMITER = ":";

    private InputOutputParser()
    {
        // disallow instantiation
    }

    /**
     * Parse a string representation of an `int[]`.
     *
     * Raw input is just a comma separated list of values e.g. 1,2,3
     * @param raw the raw string input
     * @return the array object
     */
    public static int[] parseArrayInt(String raw)
    {
        if (raw.length() == 0)
        {
            return new int[0];
        }

        String[]    rawValues = raw.split(ARRAY_ITEM_DELIMITER);

        return Arrays
                .stream(rawValues)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * Parse a string representation of an `char[]`.
     *
     * Raw input is just a comma separated list of values e.g. h,e,l,l,o
     * @param raw the raw string input
     * @return the array object
     */
    public static char[] parseArrayChar(String raw)
    {
        if (raw.length() == 0)
        {
            return new char[0];
        }

        String[]    rawValues = raw.split(ARRAY_ITEM_DELIMITER);

        char[]      chars = new char[rawValues.length];


        for (int i = 0; i < rawValues.length; i++)
        {
            chars[i] = rawValues[i].charAt(0);
        }

        return chars;
    }

    /**
     * Parse a string representation of an `String[]`.
     *
     * Raw input is just a comma separated list of values e.g. hello,there,world
     * @param raw the raw string input
     * @return the array object
     */
    public static String[] parseArrayString(String raw)
    {
        if (raw.length() == 0)
        {
            return new String[0];
        }

        String[]    rawValues = raw.split(ARRAY_ITEM_DELIMITER);

        return rawValues;
    }

    /**
     * Parse a string representation of a `List<List<Integer>>`.
     *
     * Example raw input:
     * -4,2,2:-4,1,3:-4,0,4:-4,-2,6:-2,0,2:-2,-2,4
     *
     * @param raw the raw string input
     * @return the list object
     */
    public static List<List<Integer>> parseListListInteger(String raw)
    {
        // e.g ["-4,2,2", "-4,1,3", "-4,0,4", "-4,-2,6", "-2,0,2", "-2,-2,4"]
        String[]                rawSubLists = raw.split(SUB_ARRAY_DELIMITER);

        List<List<Integer>>     result = new ArrayList<>();

        for (String rawSubList : rawSubLists)
        {
            String[]        rawValues = rawSubList.split(ARRAY_ITEM_DELIMITER);

            // convert raw sub-list into List<Integer>
            List<Integer>   subList = Arrays
                                        .stream(rawValues)
                                        .mapToInt(Integer::parseInt)
                                        .boxed()
                                        .collect(Collectors.toList());

            result.add(subList);
        }

        return result;
    }

    /**
     * Parse a string representation of a `List<String>`
     *
     * @param raw the raw string input
     * @return the list object
     */
    public static List<String> parseListString(String raw)
    {
        if ( raw.length() == 0)
        {
            return new ArrayList<>();
        }

        String[]        splitListItems = raw.split(ARRAY_ITEM_DELIMITER);

        return Arrays.asList(splitListItems);
    }

    /**
     * Parse a string representation of a `List<Integer>`
     *
     * @param raw the raw string input
     * @return the list object
     */
    public static List<Integer> parseListInteger(String raw)
    {
        if (raw.length() == 0)
        {
            return new ArrayList<>();
        }

        String[]        splitListItems = raw.split(ARRAY_ITEM_DELIMITER);

        return Arrays
            .stream(splitListItems)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }
}
