package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;


/**
 * @author Syed Caazimuddin
 */
public class Screenshot {



    public static String getScreenhot(String path_screenshot,String screenshotName, AndroidDriver<AndroidElement> driver) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File srcFile= driver.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String imageName = screenshotName+dateName+".png";
        String destination = path_screenshot + ""+screenshotName+dateName+".png";

        File finalDestination = new File(path_screenshot,imageName);
        FileUtils.copyFile(srcFile, finalDestination);
        System.out.println(destination);
        return "."+destination;
    }



}
