package main.utils;

import java.util.List;
import java.util.Map;

public final class Utils
{
    public static int parseNumericKey(Map.Entry<Object, Object> entry)
    {
        String input = (String) entry.getKey();

        return Integer.parseInt(input);
    }

    /**
     * Parse an array of int[] into verifiable string output.
     *
     * ex:
     * [1,2,3] => 1,2,3
     *
     * @param result the raw result object
     * @return the result in our input/output syntax
     */
    public static String parseIntArray(Object result)
    {
        int[]              resultArray = (int[]) result;

        StringBuilder   resultBuilder = new StringBuilder();

        for (int i : resultArray)
        {
            resultBuilder.append( i );
            resultBuilder.append( ",");
        }

        // remove additional comma
        resultBuilder.setLength( resultBuilder.length() - 1);

        return resultBuilder.toString();
    }

    /**
     * Parse a `List<List<Integer>>` into our string output.
     *
     * ex:
     *  [[-1,0,1],[-1,-1,2]] => -1,0,1:-1,-1,2
     * @param result the raw result object
     * @return the result in our input/output syntax
     */
    public static String parseListListInt(Object result)
    {
        List<List<Integer>> resultList = (List<List<Integer>>) result;

        StringBuilder resultBuilder = new StringBuilder();

        for (List<Integer> subList : resultList)
        {
            StringBuilder subResultBuilder = new StringBuilder();

            for (Integer value : subList)
            {
                subResultBuilder.append(value);
                subResultBuilder.append(",");
            }

            // remove additional comma
            subResultBuilder.setLength(subResultBuilder.length() - 1);

            // append sublist and list separator
            resultBuilder.append(subResultBuilder.toString());
            resultBuilder.append(":");
        }

        // remove additional list separator
        resultBuilder.setLength(resultBuilder.length() - 1);

        return resultBuilder.toString();
    }
}
