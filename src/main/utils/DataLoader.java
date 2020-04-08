package main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public final class DataLoader
{
    private static final String ARRAY_ITEM_DELIMITER = ",";

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
    public static int[] valueOfArrayIntString(String rawArrayInt)
    {
        String[]    split = rawArrayInt.split(ARRAY_ITEM_DELIMITER);

        return
            Arrays
            .stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
