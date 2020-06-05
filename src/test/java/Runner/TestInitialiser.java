package Runner;


import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import static Keyword.Module.handlingSystemError;



/**
 * @author Syed Caazimuddin
 */
public class TestInitialiser {

    public static AppiumDriverLocalService service;
    public static AppiumServiceBuilder builder;
    public static DesiredCapabilities cap;

 //   static Logger Log;
    public static String screenshotPath;

    public static AndroidElement element;

    //public static AndroidDriver<AndroidElement> driver;

    public static EnhancedAndroidDriver<MobileElement> driver;

    public static WebDriverWait wait;

    static HashMap<String, String> data = new HashMap();


    static Properties prop = new Properties();
    static FileInputStream fis;



    //Touch action
    static TouchAction t;


    static String reportConfigPath;


    public static void startAppiumServer(){

        String Appium_Node_Path = "C:\\Program Files\\nodejs\\node.exe";
        String Appium_JS_Path = "C:\\Users\\caazisy\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                //.usingPort(2856)
                .usingDriverExecutable(new File(Appium_Node_Path)).
                        withAppiumJS(new File(Appium_JS_Path))
                .withLogFile(new File("C:/Users/caazisy/AppiumServerLogs.txt"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
        );

        service.start();
    }


    public static void setDesiredCapability() throws MalformedURLException, InterruptedException {

        File f = new File("src");
        File fs = new File(f, "com.hesta.xmembercentre.apk");


        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        cap.setCapability("appPackage", "com.hesta.xmembercentre");
        cap.setCapability("appActivity", "md541056f2046f9312eca161f3778a35231.SplashActivity");
/*        cap.setCapability("appWaitActivity", "SplashActivity");
        cap.setCapability("appWaitActivity", "md541056f2046f9312eca161f3778a35231.SplashActivity");

        cap.setCapability("intentAction", "android.intent.action.MAIN");
        cap.setCapability("intentCategory", "android.intent.category.LAUNCHER");
        cap.setCapability("autoGrantPermissions", true);*/



        //driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver = Factory.createAndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);


        Thread.sleep(2000);


        wait = new WebDriverWait(driver, 20);


    }





    public static void loginDashboard(){

        wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("text(\"Login\")")));

        driver.findElementByAndroidUIAutomator("text(\"Login\")").click();

    }

    public static void validCrendentials(){

        t = new TouchAction(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='Login']")));

        //driver.findElementById("username").click();
        //driver.findElementById("username").clear();
        driver.findElementById("username").sendKeys("4419754");
        driver.hideKeyboard();


        //t.tap(driver.findElementById("password")).perform();
        //driver.findElementById("password").clear();
        driver.findElementById("password").sendKeys("test123");
        driver.hideKeyboard();

        driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();

    }

    public static void skipPIN(){


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Maybe later']")));
        driver.findElementByAndroidUIAutomator("text(\"Maybe later\")").click();
    }

    public static void termsAndConditions() throws InterruptedException {

        driver.findElementByClassName("android.widget.TextView").click();

        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"'Privacy'\"));");


        driver.findElementByXPath("//android.widget.Button[@text='I Agree']").click();

        //wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("text(\"Close\")")));

        //Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("text(\"Ok\")")));

        driver.findElementByXPath("//android.widget.Button[@text='Ok']").click();

        handlingSystemError();

        wait.until(ExpectedConditions.visibilityOf(driver.findElementByClassName("android.widget.FrameLayout")));


        driver.findElementByClassName("android.widget.FrameLayout").click();
        driver.findElementByClassName("android.widget.TextView").click();


     /*   MobileElement ele = driver.findElementByAndroidUIAutomator("text(\"Close\")");
        System.out.println("THE ELEMENT LOCATION IS:  " + ele.getLocation());*/



//        driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();

        //t.tap(491, 1699).perform();

        //Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Super']")));
    }





    public static void stopAppiumServer(){

        //driver.closeApp();
        service.stop();



    }







}
