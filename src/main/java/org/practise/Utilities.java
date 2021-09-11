package org.practise;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utilities extends BaseTeste {

    static AndroidDriver driver;
    public Utilities(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }


    public void scrollToText(String text){
        driver.findElementByAndroidUIAutomator
                ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));").click();
    }

    public void scrollToMatches(String text){
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" +
            ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
            ".scrollIntoView(new UiSelector().textMatches(\""+text+"\").instance(0))"));
    }

    public void tvText(String text){
        driver.findElementByXPath("//android.widget.TextView[@text=\""+text+"\"]").click();
    }

//    public static void getScreenshot()   {
//        Date currentDate = new Date();
//       // String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\anicolle\\eclipse-workspace\\Screenshots"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



}
