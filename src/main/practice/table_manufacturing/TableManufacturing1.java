package main.practice.table_manufacturing;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Practice for Dematic.
 */
public final class TableManufacturing1
{
    public static String[] solution(String[] A)
    {
        // input is inventory with no specific order

        // type will be:
        // Legs
        // Tops
        // Screws
        // Nuts

        // model:
        // string composed of case sensitive letters and/or numbers
        // models of (screws, nuts) match models of (legs, tops)

        // quantity:
        // whole number [0,100]

        // tables require 4 legs, 1 top, 6 screws, 4 nuts

        // given inventory
        // return a list that contains the number of tables each department can produce per model

        // output:
        // ["<department>,<model>,<quantity>","<department>,<model>,<quantity>",..]
        // first Parts, then Assembly
        // sorted alphabetically ascending by model
        // if no department can build a complete set, return a one-slot string array containing "None"

        // departments:
        // Parts (legs, tops)
        // Assembly (screws, nuts)

        // constants
        final int REQUIRED_LEGS = 4;
        final int REQUIRED_TOPS = 1;
        final int REQUIRED_SCREWS = 6;
        final int REQUIRED_NUTS = 4;

        // maps to track inventory (model -> quantity)
        Map<String,Integer> legsInventory = new HashMap<>();
        Map<String,Integer> topsInventory = new HashMap<>();
        Map<String,Integer> screwsInventory = new HashMap<>();
        Map<String,Integer> nutsInventory = new HashMap<>();

        // track unique model numbers
        Set<String> uniqueModelNumbers = new HashSet<>();

        // parse inventory input strings
        for (String part : A)
        {
            String[] partData = part.split(", ");

            String type = partData[0];
            String model = partData[1];
            Integer quantity = Integer.parseInt(partData[2]);

            uniqueModelNumbers.add(model);

            switch (type)
            {
                case "Legs":
                {
                    legsInventory.put(model, quantity);
                    break;
                }

                case "Tops":
                {
                    topsInventory.put(model, quantity);
                    break;
                }

                case "Screws":
                {
                    screwsInventory.put(model, quantity);
                    break;
                }

                case "Nuts":
                {
                    nutsInventory.put(model, quantity);
                    break;
                }
            }
        }

        // track output for each department
        List<String> partsOutput = new ArrayList<>();
        List<String> assemblyOutput = new ArrayList<>();

        // create a list of model numbers from inventory keySets, sort alphabetically
        List<String> modelNumbers = new ArrayList<>(uniqueModelNumbers);

        Collections.sort(modelNumbers);

        // for each model number
        for (String model : modelNumbers)
        {
            // get number of legs and tops, 'numLegs', 'numTops'
            int numLegs = legsInventory.getOrDefault(model, 0);
            int numTops = topsInventory.getOrDefault(model, 0);

            // calculate possible number of tables we can create
            int tablesPossibleLegs = numLegs / REQUIRED_LEGS;
            int tablesPossibleTops = numTops / REQUIRED_TOPS;

            // number of possible tables is limited by smallest result
            int tablesPossibleParts = Math.min(tablesPossibleLegs, tablesPossibleTops);

            if (tablesPossibleParts > 0)
            {
                addOutput(partsOutput, "Parts", model, tablesPossibleParts);
            }

            // get number of screws and nuts, 'numScrews', 'numNuts'
            int numScrews = screwsInventory.getOrDefault(model, 0);
            int numNuts = nutsInventory.getOrDefault(model, 0);

            // calculate possible number of tables we can create
            int tablesPossibleScrews = numScrews / REQUIRED_SCREWS;
            int tablesPossibleNuts = numNuts / REQUIRED_NUTS;

            // number of possible tables is limited by smallest result
            int tablesPossibleAssembly = Math.min(tablesPossibleScrews, tablesPossibleNuts);

            if (tablesPossibleAssembly > 0)
            {
                addOutput(assemblyOutput, "Assembly", model, tablesPossibleAssembly);
            }
        }

        // build result string
        int outputCount = partsOutput.size() + assemblyOutput.size();

        String[] output;

        if (outputCount > 0)
        {
            output = new String[outputCount];

            int outputIndex = 0;

            print(partsOutput.toString());

            for (String outputItem : partsOutput)
            {
                output[outputIndex++] = outputItem;
            }

            for (String outputItem : assemblyOutput)
            {
                output[outputIndex++] = outputItem;
            }
        }
        else
        {
            output = new String[]{"None"};
        }

        return output;
    }

    /**
     * Build the output string and add it to the list of collected output for the specified department.
     *
     * Each individual output is structured as "<department,model,quantity>".
     *
     * @param output the output list to append to
     * @param department the department
     * @param model the model number
     * @param quantity the quantity
     */
    private static void addOutput(List<String> output, String department, String model, int quantity)
    {
        String formattedOutput = MessageFormat.format("{0}, {1}, {2}", department, model, quantity);

        output.add(formattedOutput);
    }


    private static void print(String message)
    {
        print(message, null);
    }

    private static void print(String message, Object o1)
    {
        String messageFormatted;

        if (o1 != null && o1.getClass().isArray())
        {
            messageFormatted = MessageFormat.format(message, Arrays.toString((String[]) o1));
        }
        else
        {
            messageFormatted = MessageFormat.format(message, o1);
        }

        System.out.println(messageFormatted);
    }
}
