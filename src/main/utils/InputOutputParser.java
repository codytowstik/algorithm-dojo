package main.utils;

import java.util.Arrays;

public final class InputOutputParser
{
    private static final String ARRAY_ITEM_DELIMITER = ",";
    private InputOutputParser()
    {
        // disallow instantiation
    }

    /**
     * Parse a string representation of an array.
     *
     * Raw input is just a comma separated list of values e.g. 1,2,3
     * @param raw raw string input
     * @return the array object
     */
    public static int[] parseArrayInt(String raw)
    {
        String[] values = raw.split(ARRAY_ITEM_DELIMITER);

        return Arrays
                .stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
