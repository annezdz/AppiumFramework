package org.practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Base {

    public static AppiumDriverLocalService service;

    public void startServer(){
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {

        String projectPath = System.getProperty("user.dir");
        File apk = new File(projectPath + "/src/General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();

        //String device = (String) properties.get("device");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");

        cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }
}