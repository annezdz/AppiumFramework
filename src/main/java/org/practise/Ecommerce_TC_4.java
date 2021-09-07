package org.practise;

import PageObject.CheckoutPageObject;
import PageObject.FormPageObject;
import PageObject.ProductsPageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
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

        FormPageObject formPage = new FormPageObject(driver);

        //formPage.nameField.sendKeys("Anne");
        formPage.getNameField().sendKeys("Anne");
        driver.hideKeyboard();
        formPage.getFemaleOption().click();
        formPage.getCountrySelection().click();

        Utilities utilities = new Utilities(driver);

        utilities.scrollToText("Barbados");

        formPage.getBtnLetsShop().click();

        ProductsPageObject productsPageObject = new ProductsPageObject(driver);
        utilities.scrollToMatches("Nike Blazer Mid '77");

        int count = productsPageObject.getProductName().size();

        for (int i = 0; i < count; i++) {
            String name = productsPageObject.getProductName().get(i).getText();

            if (Objects.equals(name, "Nike Blazer Mid '77")) {
                productsPageObject.getAddProductCart().get(i).click();
                break;
            }
        }

        utilities.scrollToMatches("Air Jordan 1 Mid SE");

        for (int i = 0; i < count; i++) {
            String name = productsPageObject.getProductName().get(i).getText();

            if (Objects.equals(name, "Air Jordan 1 Mid SE")) {
                productsPageObject.getAddProductCart().get(i).click();
                break;
            }
        }
        productsPageObject.getBtnCart().click();

        Thread.sleep(4000);

        utilities.scrollToText("$110.0");

        CheckoutPageObject checkoutPageObject = new CheckoutPageObject(driver);

        int counte = checkoutPageObject.getProductList().size();
        double sum = 0;

        for (int i = 0; i < counte; i++) {
            String amount1 = checkoutPageObject.getProductList().get(i).getText();
            double amount = getAmount(amount1);
            sum += amount;
        }

        System.out.println("Total: " + sum);

        String totalValue = checkoutPageObject.totalAmount.getText();

        totalValue = totalValue.substring(1);
        double num = Double.parseDouble(totalValue);

        System.out.println("Label value: " + totalValue);

        Assert.assertSame(sum, num);

        //Mobile Gestures

        checkoutPageObject.getCheckBox().click();
        WebElement checkbox = checkoutPageObject.getCheckBox();

        TouchAction action = new TouchAction(driver);
        action.tap(tapOptions().withElement(element(checkbox))).perform();

        WebElement terms = checkoutPageObject.getTermsButton();

        action.longPress(longPressOptions().withElement(element(terms))
                .withDuration(Duration.ofSeconds(2))).release().perform();

        checkoutPageObject.getButton().click();
        checkoutPageObject.getBtnProceed().click();
    }

    public static double getAmount(String value) {

        value = value.substring(1);
        return Double.parseDouble(value);


        }
}

