package mobileauto.devices;

import java.util.HashMap;
import java.util.Map;

public class FactoryDevices {

    private static Map<String,IDevice> deviceMap = new HashMap<>();

    public static IDevice make(String type){
        deviceMap.put("android", new Android());
        deviceMap.put("ios", new Ios());
        deviceMap.put("cloud", new AndroidCloud());

        return deviceMap.containsKey(type.toLowerCase())?
                deviceMap.get(type.toLowerCase()):
                deviceMap.get("android");
    }

}