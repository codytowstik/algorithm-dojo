package main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public final class DataLoader
{
    public static Properties loadExpectedResults(Class clazz, String propertiesFileName )
    {
        Properties expectedResults = new Properties();

        try
        {
            URL url = clazz.getResource(propertiesFileName);
            File inputFile = new File(url.getPath());
            FileInputStream fileInputStream = new FileInputStream(inputFile);

            expectedResults.load(fileInputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return expectedResults;
    }
}
