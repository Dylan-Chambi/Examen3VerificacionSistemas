package mobileauto.devices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidCloud implements IDevice{
    @Override
    public AppiumDriver create() {
        String user = "dylanchambif_XohAjV";
        String accessKey = "6qtUkfdCVzJcKs7sbxFj";
        String app = "bs://a9de8b5068784ea54eb626e238f61c8da40bf866";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Samsung Galaxy S23 Ultra");
        capabilities.setCapability("os_version", "13.0");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("app", app);
        capabilities.setCapability("browserstack.user", user);
        capabilities.setCapability("browserstack.key", accessKey);

        capabilities.setCapability("project", "UPB Test WhenDO");
        capabilities.setCapability("build", "build 0001");
        capabilities.setCapability("name", "WhenDO Test");


        AppiumDriver driver= null;
        try {
            System.out.println("http://" + user + ":" + accessKey + "@hub-cloud.browserstack"
                    + ".com/wd/hub");
            driver = new AndroidDriver(new URL("http://" + user + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
