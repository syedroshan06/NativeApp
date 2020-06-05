package pages;



/**
 * @author Syed Caazimuddin
 */


import Runner.TestInitialiser;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class Accounts {

    static MobileElement element;

    //static AndroidDriver<AndroidElement> driver = TestInitialiser.driver;

    static EnhancedAndroidDriver<MobileElement> driver = TestInitialiser.driver;






    public static MobileElement Account_Deeplink(){




        //element = driver.findElementByAndroidUIAutomator("text(\"Account\")");

        element = driver.findElementByAndroidUIAutomator("text(\"Account\")");

        return element;
    }

    public static MobileElement Profile_Setting(){

        element = driver.findElementByAndroidUIAutomator("text(\"Profile settings\")");


        return element;
    }

    public static MobileElement Account_Name(){

        element = driver.findElementByAndroidUIAutomator("text(\"Account name\")");


        return element;
    }

    public static MobileElement Member_ID(){

        element = driver.findElementByAndroidUIAutomator("text(\"Member ID\")");


        return element;
    }

    public static MobileElement Last_login(){

        element = driver.findElementByAndroidUIAutomator("text(\"Last login\")");


        return element;
    }

    public static MobileElement Member_details(){

        element = driver.findElementByAndroidUIAutomator("text(\"Member details\")");


        return element;
    }

    public static MobileElement Contact_details(){

        element = driver.findElementByAndroidUIAutomator("text(\"Contact details\")");


        return element;
    }

    public static MobileElement Communication_settings(){

        element = driver.findElementByAndroidUIAutomator("text(\"Communication settings\")");

        return element;
    }

}
