package org.appium.properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:${user.dir}/resources/Ecommerce.properties",
                 "file:${user.dir}/resources/User.properties",
                 "file:${user.dir}/resources/Appium.properties"})


public interface Properties extends Config {

    @Key("name")
    String name();

    @Key("gender")
    String gender();

    @Key("country")
    String country();

    @Key("ipAddress")
    String ipAddress();

    @Key("portNo")
    int portNo();

    @Key("appPath")
    String appPath();

    @Key("deviceName")
    String deviceName();

    @Key("appiumJSProperty")
    String appiumNodeJSProperty();

    @Key("reportPath")
    String reportPath();

    @Key("reportName")
    String reportName();
}
