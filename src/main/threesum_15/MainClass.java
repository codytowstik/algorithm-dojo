package main.threesum_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class MainClass {
    public static String booleanToString( boolean input )
    {
        return input ? "True" : "False";
    }

    public static void main( String[] args ) throws IOException
    {
        URL                 url = MainClass.class.getResource( "input_15.txt" );
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
