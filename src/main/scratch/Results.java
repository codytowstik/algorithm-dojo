package main.scratch;

import main.threesum_15.ThreeSumRunner;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

public final class Results
{
    private static final Map<Integer,List<Integer>> expectedResultsHashToList = new HashMap<>();
    private static final Map<Integer,List<Integer>> actualResultsHashToList = new HashMap<>();

    public static void main(String[] args)
    {
        List<List<Integer>> expectedResults = loadListListOutput(ThreeSumRunner.class, "failed_expected", true);
        List<List<Integer>> actualResults = loadListListOutput(ThreeSumRunner.class, "failed_actual", false);

        checkExpectedVersusActual();
    }

    private static List<List<Integer>> loadListListOutput( Class clazz, String filename, boolean expected )
    {
        URL resource = clazz.getResource(filename);
        File file = new File( resource.getPath());

        String output;

        try
        {
            output = new String(Files.readAllBytes(file.toPath()));
        }
        catch(Throwable t)
        {
            return null;
        }

        // remove start and end brackets
        String trimmedOutput = output.substring(2, output.length() - 3);

        String[] rawSubArrays = trimmedOutput.split("],\\[" );

        List<List<Integer>> result = new ArrayList<>();

        int     total = 0;

        // -41689, -40908, 82597
        for (String rawSubArray : rawSubArrays)
        {
            List<Integer> subArray = new ArrayList<>();

            String[] values = rawSubArray.split( "," );

            for (String value : values)
            {
                subArray.add(Integer.parseInt(value.trim()));
            }

            Collections.sort(subArray);

            if (expected)
            {
                expectedResultsHashToList.put(subArray.hashCode(), subArray);
            }
            else
            {
                actualResultsHashToList.put(subArray.hashCode(), subArray);
            }

            result.add(subArray);
            total++;
        }

        System.out.println("total" + "filename " + total);

        int hashCount;

        if (expected)
        {
            hashCount = expectedResultsHashToList.size();
        } else
        {
            hashCount = actualResultsHashToList.size();
        }

        System.out.println("hash total " + hashCount);

        if (hashCount != total)
        {
            System.out.println("Oops!");
        }

        System.out.println();

        return result;
    }

    private static void checkExpectedVersusActual()
    {
        List<List<Integer>> extraExpected;

        int missingExpected = 0;

        for (Integer integer : expectedResultsHashToList.keySet())
        {
            if (!actualResultsHashToList.containsKey(integer))
            {
                missingExpected++;
            }
        }

        int extraActual = 0;

        for (Integer integer : actualResultsHashToList.keySet())
        {
            if (!expectedResultsHashToList.containsKey(integer))
            {
                extraActual++;
            }
        }

        String  expectedOutput = String.format("Missing expected: %d", missingExpected );
        String  actualOutput = String.format(  "Extra actual:     %d", extraActual );

        System.out.println(expectedOutput);
        System.out.println(actualOutput);
    }
}
