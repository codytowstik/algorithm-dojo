package main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public final class DataLoader
{
    private static final String ARRAY_ITEM_DELIMITER = ",";
    private static final String SUB_ARRAY_DELIMITER = ":";

    private DataLoader()
    {
        // disallow instantiation
    }

    public static Map<String,String> loadExpectedResults(Class<? extends SolutionEx> clazz, String propertiesFileName)
    {
        Properties expectedResults = new Properties();

        try
        {
            URL                 url = clazz.getResource(propertiesFileName);
            File                inputFile = new File(url.getPath());
            FileInputStream     fileInputStream = new FileInputStream(inputFile);

            expectedResults.load(fileInputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Set<String>     rawInputs = expectedResults.stringPropertyNames();

        List<String>    sortedRawInputs = new ArrayList<>(rawInputs);

        Collections.sort(sortedRawInputs);

        LinkedHashMap<String, String>   orderedInputOutputs = new LinkedHashMap<>();

        for (String sortedRawInput : sortedRawInputs)
        {
            String      rawOutput = expectedResults.getProperty(sortedRawInput);

            orderedInputOutputs.put(sortedRawInput, rawOutput);
        }

        return orderedInputOutputs;
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
}
