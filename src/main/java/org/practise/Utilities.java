package org.practise;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {

    AndroidDriver driver;
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



}
