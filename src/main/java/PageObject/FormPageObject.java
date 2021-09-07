package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPageObject {

    public FormPageObject(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelection;

    @AndroidFindBy(id= "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getCountrySelection() {
        return countrySelection;
    }

    public WebElement getBtnLetsShop() {
        return btnLetsShop;
    }

    public WebElement getFemaleOption() {
        return femaleOption;
    }
}

