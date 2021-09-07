package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApiDemoPageObject {

    public ApiDemoPageObject(AndroidDriver<AndroidElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement checkbox;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement editText;

    @AndroidFindBy(className = "android.widget.Button")
    private List<WebElement> button;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    private  WebElement relativeLayout;

    public WebElement getCheckbox() {
        return checkbox;
    }

    public WebElement getEditText() {
        return editText;
    }

    public List<WebElement> getButton() {
        return button;
    }

    public WebElement getRelativeLayout() {
        return relativeLayout;
    }
}
