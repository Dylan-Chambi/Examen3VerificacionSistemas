package mobileauto.session;

import devices.FactoryDevices;
import io.appium.java_client.AppiumDriver;
import utils.GetEnvironment;

public class Session {
    private static Session session = null;
    private AppiumDriver device;
    private Session(){
        // todo property file
        device = FactoryDevices.make(GetEnvironment.getInstance().getDevice()).create();
    }

    public static Session getSession(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeSession(){
        device.quit();
        session = null;
    }

    public AppiumDriver getDevice() {
        return device;
    }
}
