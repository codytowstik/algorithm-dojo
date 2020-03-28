package main.utils;

import java.util.Map;

public final class Utils
{
    public static int parseNumericKey(Map.Entry<Object, Object> entry)
    {
        String input = (String) entry.getKey();

        return Integer.parseInt(input);
    }

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
}
