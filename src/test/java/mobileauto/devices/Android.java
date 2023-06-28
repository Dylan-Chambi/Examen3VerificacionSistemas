package mobileauto.devices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.GetEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevice{
    @Override
    public AppiumDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Pixel_4_XL_API_31");
        capabilities.setCapability("platformVersion","12");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", GetEnvironment.getInstance().getPackageValue());
        capabilities.setCapability("appActivity",GetEnvironment.getInstance().getActivityValue());
        AppiumDriver driver= null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
