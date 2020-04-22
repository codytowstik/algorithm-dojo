package main.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Utils
{
    private Utils()
    {
        // disallow instantiation
    }

    public static int parseNumericKey(Map.Entry<Object, Object> entry)
    {
        String      input = (String) entry.getKey();

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
        int[]           resultArray = (int[]) result;

        StringBuilder   resultBuilder = new StringBuilder();

        for (int i : resultArray)
        {
            resultBuilder.append(i);
            resultBuilder.append(",");
        }

        // remove additional comma
        resultBuilder.setLength(resultBuilder.length() - 1);

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
        List<List<Integer>>     resultList = (List<List<Integer>>) result;

        StringBuilder           resultBuilder = new StringBuilder();

        for (List<Integer> subList : resultList)
        {
            StringBuilder   subResultBuilder = new StringBuilder();

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

    public static boolean isEquals(char[] array1, char[] array2)
    {
        if (array1.length != array2.length)
        {
            return false;
        }

        // sort arrays since order doesn't matter
        Arrays.sort(array1);
        Arrays.sort(array2);

        boolean equal = true;

        for (int i = 0; i < array1.length; i++)
        {
            equal &= (array1[i] == array2[i]);
        }

        return equal;
    }

    public static boolean isEqualsIgnoreOrder(List<List<Integer>> list1, List<List<Integer>> list2)
    {
        if (list1.size() != list2.size())
        {
            return false;
        }

        List<List<Integer>>     list1DeepSorted = deepSortListListInteger(list1);
        List<List<Integer>>     list2DeepSorted = deepSortListListInteger(list2);

        boolean     equal = true;

        for (int i = 0; i < list1.size(); i++)
        {
            equal &= list1DeepSorted.get(i).equals(list2DeepSorted.get(i));
        }

        return equal;
    }

    public static boolean isEqualsIgnoreOrder(int[] array1, int[] array2)
    {
        if (array1.length != array2.length)
        {
            return false;
        }

        // sort arrays since order doesn't matter
        Arrays.sort(array1);
        Arrays.sort(array2);

        boolean     equal = true;

        for (int i = 0; i < array1.length; i++)
        {
            equal &= (array1[i] == array2[i]);
        }

        return equal;
    }

    /**
     * Sort a `List<List<Integer>>` object .. sorting the inner lists and then
     * the outer lists.
     *
     * @param list the original list
     * @return the deeply- sorted
     */
    public static List<List<Integer>> deepSortListListInteger(List<List<Integer>> list)
    {
         return list
                 .stream()
                 .peek(Collections::sort)
                 .sorted(new ListComparator<>())
                 .collect(Collectors.toList());
    }

    /**
     * Get the first public method found in the given array.
     *
     * @param methods the methods
     * @return the first public method
     */
    public static Method getFirstPublicMethod(Method[] methods)
    {
        for (Method method : methods)
        {
            int     modifiers = method.getModifiers();

            String  modifier = Modifier.toString(modifiers);

            if (modifier.equals("public"))
            {
                return method;
            }
        }

        throw new RuntimeException("No public method found.");
    }

    public static String getFirstPublicMethodReturnType(Class<?> clazz)
    {
        Method[]        declaredMethods = clazz.getDeclaredMethods();

        // each problem should only have one method
        Method          declaredMethod = getFirstPublicMethod(declaredMethods);

        Class<?>        returnType = declaredMethod.getReturnType();

        String          returnTypeCanonicalName = returnType.getCanonicalName();

        return returnTypeCanonicalName;
    }
}
