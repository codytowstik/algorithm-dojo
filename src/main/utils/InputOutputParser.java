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
     * Parse an array property string, and return its `int[]` equivalent.
     *
     * @param rawArrayInt the raw array e.g. 1,2,3,4 as a string
     * @return the equivalent `int[]`
     */
    public static int[] parseArrayIntString(String rawArrayInt)
    {
        String[]    split = rawArrayInt.split(ARRAY_ITEM_DELIMITER);

        return
            Arrays
            .stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * Parse a string representation of a `List<List<Integer>>`.
     *
     * Example raw input:
     * -4,2,2:-4,1,3:-4,0,4:-4,-2,6:-2,0,2:-2,-2,4
     *
     * @param rawListList the raw string input
     * @return the list object
     */
    public static List<List<Integer>> parseListListIntegerString(String rawListList)
    {
        // e.g ["-4,2,2", "-4,1,3", "-4,0,4", "-4,-2,6", "-2,0,2", "-2,-2,4"]
        String[]     rawSubLists = rawListList.split(SUB_ARRAY_DELIMITER);

        List<List<Integer>>     result = new ArrayList<>();

        for (String rawSubList : rawSubLists)
        {
            String[]        rawValues = rawSubList.split(ARRAY_ITEM_DELIMITER);

            // convert raw sub-list into List<Integer>
            List<Integer>    subList =
                Arrays
                .stream(rawValues)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

            result.add(subList);
        }

        return result;
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
        String[]    rawValues = raw.split(ARRAY_ITEM_DELIMITER);

        return Arrays
                .stream(rawValues)
                .mapToInt(Integer::parseInt)
                .toArray();
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
        String[]    rawSubLists = raw.split(SUB_ARRAY_DELIMITER);

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
}
