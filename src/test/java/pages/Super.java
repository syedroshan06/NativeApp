package pages;

import Runner.TestInitialiser;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Syed Caazimuddin
 */
public class Super {


    static MobileElement element;

    //static AndroidDriver<AndroidElement> driver = TestInitialiser.driver;

    static EnhancedAndroidDriver<MobileElement> driver = TestInitialiser.driver;


    public static MobileElement Super_Deeplink(){




        element = driver.findElementByAndroidUIAutomator("text(\"Super\")");

        return element;
    }

    public static int Super_DashboardVisibility(){




        int size = driver.findElementsByAndroidUIAutomator("text(\"Super\")").size();

        return size;
    }

}
