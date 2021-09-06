package org.practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiDemoTest extends BaseTeste {

    @Test
    public void apiDemo() throws IOException {

        AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        driver.findElementsByClassName("android.widget.Button").get(1).click();


    }
}
