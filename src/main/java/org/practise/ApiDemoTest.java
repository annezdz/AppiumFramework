package org.practise;

import PageObject.ApiDemoPageObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiDemoTest extends BaseTeste {

    @Test
    public void apiDemo() throws IOException {

        AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
        Utilities utilities = new Utilities(driver);

        ApiDemoPageObject apiDemoPageObject = new ApiDemoPageObject(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utilities.tvText("Preference");
        utilities.tvText("3. Preference dependencies");

        apiDemoPageObject.getCheckbox().click();

        apiDemoPageObject.getRelativeLayout().click();
        apiDemoPageObject.getEditText().sendKeys("hello");
        apiDemoPageObject.getButton().get(1).click();

    }
}
