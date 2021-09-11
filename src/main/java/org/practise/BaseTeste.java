package org.practise;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseTeste {

    public static AppiumDriverLocalService service;

    public AppiumDriverLocalService startServer(){

        boolean flag = checkIfServerIsRunning(4723);
        if(!flag){
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;

    }

    public static boolean checkIfServerIsRunning(int port){

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }catch (IOException e){
            isServerRunning = true;
        }finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(
                "C:\\Users\\anicolle\\eclipse-workspace\\AppiumFrameword\\" +
                        "AppiumFramework\\src\\main\\java\\resources\\emulator.bat");
        Thread.sleep(6000);
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        String projectPath = System.getProperty("user.dir");
        DesiredCapabilities cap = new DesiredCapabilities();

        FileInputStream fis = new FileInputStream(projectPath + "\\src\\global.properties");

        Properties prop = new Properties();

        prop.load(fis);

        File apk = new File (prop.getProperty("generalStore"));

        String device = (String) prop.get("device");
        if(device.contains("emulator")){
            startEmulator();
        }

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }

    public void getScreenshot(AndroidDriver<AndroidElement> d) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date date = new Date();
        String fileName = sdf.format(date);
        File des = d.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(des, new File(System.getProperty("user.dir")+"//Screenshot/"+fileName+".png"));
        System.out.println("Screenshot is captured");
    }




}