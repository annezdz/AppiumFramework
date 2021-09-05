package org.practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws FileNotFoundException, MalformedURLException {

        String projectPath = System.getProperty("user.dir");

        System.out.println(projectPath);
    }
}
