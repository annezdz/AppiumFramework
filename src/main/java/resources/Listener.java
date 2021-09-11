package resources;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.practise.BaseTeste;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends BaseTeste implements ITestListener {

    AndroidDriver<AndroidElement> driver;

    public void onTestFailure(ITestResult result){
        try {
            getScreenshot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test failed");

    }
}
