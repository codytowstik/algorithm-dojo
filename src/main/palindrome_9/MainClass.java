package main.palindrome_9;

import java.io.*;
import java.net.URL;

import main.palindrome_9.SolutionCleaned;

public class MainClass {
    public static String booleanToString( boolean input )
    {
        return input ? "True" : "False";
    }

    public static void main( String[] args ) throws IOException
    {
        URL                 url = MainClass.class.getResource( "input_9.txt" );
        File 	            inputFile = new File( url.getPath() );

        BufferedReader      in = new BufferedReader( new FileReader( inputFile ) );
        String              line;

        while ( ( line = in.readLine() ) != null )
        {
            System.out.println( line );

            int         x = Integer.parseInt( line );

            boolean     ret = new SolutionCleaned().isPalindrome( x );

            String      out = booleanToString( ret );

            System.out.print( out );
            System.out.println();
            System.out.println();
        }
    }
}
