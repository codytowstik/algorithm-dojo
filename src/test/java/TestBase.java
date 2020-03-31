import org.junit.jupiter.api.Assertions;

public abstract class TestBase
{
    private static final int ARRAY_LENGTH_LIMIT = 32;

    void assertEquals(int[] expected, int[] actual)
    {
        // if array exceeds our limit, only compare the lengths so we have nice output
        if ((expected.length > ARRAY_LENGTH_LIMIT) || (actual.length > ARRAY_LENGTH_LIMIT))
        {
            Assertions.assertEquals(expected.length, actual.length, "Array lengths differ.");
        }
        else
        {
            String      prettyArr1String = prettyPrintArray(expected);
            String      prettyArr2String = prettyPrintArray(actual);

            Assertions.assertEquals(prettyArr1String, prettyArr2String);
        }
    }

    /**
     * Pretty print an integer array.
     *
     * ex:
     *  1, 2, 3, 4 (n=4) .. [1, 2, 3, 4]
     *
     * @param array the array
     * @return the array as a string
     */
    String prettyPrintArray(int[] array)
    {
        StringBuilder  builder = new StringBuilder();

        builder.append("[");

        for (int i : array)
        {
            builder.append(i);

            builder.append(", ");
        }

        // remove the last comma/space

        builder.setLength(builder.length() - 2);

        builder.append("]");

        return builder.toString();
    }
}
