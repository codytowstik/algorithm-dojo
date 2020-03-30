package main.utils;

/**
 * Multiple input class.
 *
 * For an `input.properties` file line, each separate input is delimited by a forward slash (/)
 *
 * ex:
 * Two Sum
 * 2,7,11,15/9=0,1
 *
 * input1 = [2,7,11,15]
 * input2 = 9 (target)
 */
public final class MultiInput
{
    public static final String INPUT_DELIMETER = "/";

    public final String originalInput;
    public final String[] inputs;

    /**
     * @param rawInput raw input from properties e.g. 2,7,11,15/9
     */
    public MultiInput(Object rawInput)
    {
        originalInput = (String) rawInput;

        this.inputs = originalInput.split(INPUT_DELIMETER);
    }

    /**
     * Get the specified input as an int.
     *
     * ex:
     * 2,7,11,15/9=0,1
     * getInt(1) = 9
     *
     * @param inputNum the nth input to parse
     * @return the parsed input as an `int`
     */
    public int parseInt(int inputNum)
    {
        return Integer.parseInt(inputs[inputNum]);
    }

    /**
     * Get the specified input as an array.
     *
     * ex:
     *  2,7,11,15/9=0,1
     *  getArrayInt(0) => [2,7,11,15]
     *
     * @param inputNum the nth input to parse
     * @return the parsed input as an `int[]`
     */
    public int[] parseArrayInt(int inputNum)
    {
        // get our comma separated list of values e.g. 1,2,3
        String      input = inputs[inputNum];

        // split by comma
        String[]      splitValues = input.split( "," );

        // create new array to hold the values we want as int

        int[]       array = new int[splitValues.length];

        for (int i = 0; i < splitValues.length; i++)
        {
            array[i] = Integer.parseInt(splitValues[i]);
        }

        return array;
    }
}
