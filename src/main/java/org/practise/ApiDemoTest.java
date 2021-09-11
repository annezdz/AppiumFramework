package org.practise;

import PageObject.ApiDemoPageObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Listener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class ApiDemoTest extends BaseTeste {

    public ApiDemoTest() throws MalformedURLException {
    }

    @Test
    public void apiDemo() throws IOException, InterruptedException {

        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
        Utilities utilities = new Utilities(driver);

        ApiDemoPageObject apiDemoPageObject = new ApiDemoPageObject(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utilities.tvText("Preference");
        utilities.tvText("3. Preference dependencies");

        apiDemoPageObject.getCheckbox().click();

        apiDemoPageObject.getRelativeLayout().click();
        try{
            apiDemoPageObject.getEditText().sendKeys("hello");
            apiDemoPageObject.getButton().get(1).click();
        }catch (Exception e){
            System.out.println("fail");
        }
        service.stop();

    }
}
