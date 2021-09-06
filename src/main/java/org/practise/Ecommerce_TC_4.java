package org.practise;

import PageObject.FormPage;
import com.google.common.annotations.VisibleForTesting;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Ecommerce_TC_4 extends BaseTeste {

    @Test
    public void totalValidation() throws InterruptedException, IOException {


        AndroidDriver<AndroidElement> driver = capabilities("generalStore");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FormPage formPage = new FormPage(driver);

        //formPage.nameField.sendKeys("Anne");
        formPage.getNameField().sendKeys("Anne");
        driver.hideKeyboard();
        formPage.femaleOption.click();
        formPage.getCountrySelection().click();

        Utilities utilities = new Utilities(driver);

        utilities.scrollToText("Belarus");

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().textMatches(\"Air Jordan 4 Retro\").instance(0))"));

        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for (int i = 0; i < count; i++) {
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

            if (Objects.equals(name, "Air Jordan 4 Retro")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().textMatches(\"Air Jordan 1 Mid SE\").instance(0))"));

        for (int i = 0; i < count; i++) {
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

            if (Objects.equals(name, "Air Jordan 1 Mid SE")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(4000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"$160.97\"));");

        int counte = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;

        for (int i = 0; i < counte; i++) {
            String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
                    .get(i).getText();
            double amount = getAmount(amount1);
            sum += amount;
        }

        System.out.println("Total: " + sum);

        String totalValue = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

        totalValue = totalValue.substring(1);
        double num = Double.parseDouble(totalValue);

        System.out.println("Label value: " + totalValue);

        Assert.assertSame(sum, num);

        //Mobile Gestures

        //driver.findElement(By.className("android.widget.CheckBox")).click();
        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));

        TouchAction action = new TouchAction(driver);
        action.tap(tapOptions().withElement(element(checkbox))).perform();


        //TouchAction action = new TouchAction(driver);

        WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

        action.longPress(longPressOptions().withElement(element(terms))
                .withDuration(Duration.ofSeconds(2))).release().perform();

        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


    }

    public static double getAmount(String value) {

        value = value.substring(1);
        return Double.parseDouble(value);


        }
}

