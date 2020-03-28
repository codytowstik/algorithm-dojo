package main.utils;

public class MultiInput
{
    public static final String INPUT_DELIMETER = "/";

    public final String originalInput;
    public final String[] inputs;

    public MultiInput(Object input)
    {
        String  inputString = (String) input;

        originalInput = inputString;

        this.inputs = inputString.split(INPUT_DELIMETER);
    }

    public int getInt(int inputNum)
    {
        return Integer.parseInt(inputs[inputNum]);
    }

    public int[] getArrayInt(int inputNum)
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
