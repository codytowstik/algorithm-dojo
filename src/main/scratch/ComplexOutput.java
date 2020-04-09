package main.scratch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Complex output class.
 *
 * For an `input.properties` result line, parse complex results.
 *
 * ex:
 * 3Sum
 * -1,0,1,2,-1,-4=-1,0,1:-1,-1,2
 *
 * raw output: -1,0,1:-1,-1,2
 * parsed: [[-1,0,1],[-1,-1-2]]
 */
public final class ComplexOutput
{
    public static final String MULTI_LIST_DELIMETER = ":";

    public final String rawOutput;

    public ComplexOutput(Object rawExpectedOutput)
    {
        rawOutput = (String) rawExpectedOutput;
    }

    public List<List<Integer>> parseListListInt()
    {
        // -1,0,1:-1,-1,2 => ["-1,0,1","-1,-1,2"]
        String[]    rawSubLists = rawOutput.split(MULTI_LIST_DELIMETER);

        // our container list will have as many elements as there are sub-lists
        List<List<Integer>>     outerList = new ArrayList<>(rawSubLists.length);

        for (String rawSubList : rawSubLists)
        {
            List<Integer>   subList = new ArrayList<>();

            // parse the numbers from our string

            String[]        splitValues = rawSubList.split(",");

            for (int i = 0; i < splitValues.length; i++)
            {
                Integer     intValue = Integer.parseInt(splitValues[i]);

                subList.add(intValue);
            }

            outerList.add(subList);
        }

        return  outerList;
    }
}
