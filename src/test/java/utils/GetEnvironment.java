package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetEnvironment {
    private static GetEnvironment instance = null;
    private String device;
    private String packageValue;
    private String activityValue;

    private GetEnvironment(){
        Properties properties = new Properties();
        // env.properties
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("env.properties");
        if (inputStream != null ){
            try {
                properties.load(inputStream);
                device = properties.getProperty("device");
                packageValue = properties.getProperty("package");
                activityValue =  properties.getProperty("activity");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static GetEnvironment getInstance(){
        if (instance == null)
            instance = new GetEnvironment();
        return instance;
    }

    public String getDevice() {
        return device;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public String getActivityValue() {
        return activityValue;
    }
}
