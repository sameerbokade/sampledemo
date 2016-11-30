package pacckage1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.omg.SendingContext.RunTimeOperations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test {

 public static void main(String[] args) throws InterruptedException, IOException {
  AppiumDriver<WebElement> driver;
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.gears42.surelock");
        //caps.setCapability("avd", "AVD_for_Nexus_6");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,1800);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElementById("android:id/button1").click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      driver.findElementByXPath("//android.widget.Button[@text='OK, Got It!' and @index='2']").click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.findElementByXPath("//android.widget.TextView[@text='SureLock' and @index='0']").click();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.findElementById("android:id/button_always").click(); 
     driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
     
     driver.findElementById("com.gears42.surelock:id/gridview").click(); 
     driver.findElementById("com.gears42.surelock:id/gridview").click();
     driver.findElementById("com.gears42.surelock:id/gridview").click();
Runtime.getRuntime().exec("adb shell am broadcast -a com.gears42.surelock.COMMUNICATOR -e \"command\" \"open_admin_settings\" -e \"password\" \"0000\""); 
driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
driver.findElementById("com.gears42.surelock:id/btNext").click();
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.scrollToExact("About SureLock").click();
driver.findElementByXPath("//android.widget.TextView[@text='Activate' and @index='0']").click();
if(driver.findElementByXPath("//android.widget.TextView[@text='Enter activation code' and @index='0']").isDisplayed())
{
driver.findElementById("android:id/edit").sendKeys("909686");
//driver.findElementById("android:id/button2").click();
driver.findElementById("android:id/button1").click();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElementById("android:id/button2").click();
driver.scrollToExact("Done").click();
}
}
}