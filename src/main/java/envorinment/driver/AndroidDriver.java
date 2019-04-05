package envorinment.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriver {
    private AppiumDriver driver;

    public AndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "520022be42d6b5cf");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.trello");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".home.HomeActivity");
        URL url = new URL("http://169.254.120.109:4444/wd/hub");
        driver = new io.appium.java_client.android.AndroidDriver(url, capabilities);
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}