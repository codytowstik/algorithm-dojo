package main.easyInterview.palindrome_9;

import main.utils.Solution;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MainClass {
    public static void main( String[] args ) throws IOException
    {
//        URL                 url = MainClass.class.getResource( "input_9.txt" );
        FileInputStream     fileInputStream = new FileInputStream( "input_9.properties" );

        Properties          expectedResults = new Properties();

        expectedResults.load( fileInputStream );

        for ( Map.Entry<Object, Object> entry: expectedResults.entrySet() )
        {
            String input = (String) entry.getKey();
            String expectedResult = (String) entry.getValue();

            Solution solution = new Solution0();

            Object result = solution.execute(input);


        }
    }
}
