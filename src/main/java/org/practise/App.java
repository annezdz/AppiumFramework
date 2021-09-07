package org.practise;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException, MalformedURLException {

        String projectPath = System.getProperty("user.dir");

        System.out.println(projectPath);
    }
}
