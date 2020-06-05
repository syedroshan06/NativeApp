package Keyword;

import Runner.TestInitialiser;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Accounts;
import pages.Super;

import static pages.Super.Super_DashboardVisibility;



/**
 * @author Syed Caazimuddin
 */
public class Module {

    public static WebDriverWait wait = TestInitialiser.wait;
    //static AndroidDriver<AndroidElement> driver = TestInitialiser.driver;

    static EnhancedAndroidDriver<MobileElement> driver = TestInitialiser.driver;

    static boolean superDeepLinkFound = true;



    public static void AccountDashboard(){

        wait.until(ExpectedConditions.visibilityOf(Accounts.Account_Deeplink()));
        Accounts.Account_Deeplink().click();


    }

    public static void SuperDashboard(){

        wait.until(ExpectedConditions.visibilityOf(Super.Super_Deeplink()));
        Super.Super_Deeplink().click();


    }

    public static EnhancedAndroidDriver<MobileElement> handlingSystemError(){

        if (driver.findElementsByAndroidUIAutomator("text(\"Close\")").size() > 0) {


            //wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("text(\"Close\")")));
            driver.findElementByAndroidUIAutomator("text(\"Close\")").click();

        }

        return driver;
    }

    public static void Prerequisite(){



        while (superDeepLinkFound) {
            if (Super_DashboardVisibility() > 0) {

                Super.Super_Deeplink().click();
                superDeepLinkFound = false;
                System.out.println("I am inside while-if loop");

            }

            else{

                driver.pressKeyCode(AndroidKeyCode.BACK);
                System.out.println("I am inside while-else loop");

            }
        }
        superDeepLinkFound = true;

    }

    public static void AvailabilityOfAccountDashboard(){

        wait.until(ExpectedConditions.visibilityOf(Accounts.Account_Deeplink()));
    }

    public static void ClickAccountDeeplink(){

        Accounts.Account_Deeplink().click();
    }

    public static void ClickProfileSettings(){

        Accounts.Profile_Setting().click();
    }

    public static void Assert_Account_Information(){

        Assert.assertTrue(Accounts.Account_Name().isDisplayed());
        Assert.assertTrue(Accounts.Member_ID().isDisplayed());
        Assert.assertTrue(Accounts.Last_login().isDisplayed());
    }

    public static void Assert_Profile_Settings_Menu(){

        Assert.assertTrue(Accounts.Member_details().isDisplayed());
        Assert.assertTrue(Accounts.Contact_details().isDisplayed());
        Assert.assertTrue(Accounts.Communication_settings().isDisplayed());
    }
}
