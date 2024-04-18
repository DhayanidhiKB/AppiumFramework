package org.appium.properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:${user.dir}/resources/Ecommerce.properties"})

public interface Properties extends Config {

    @Key("name")
    String name();

    @Key("gender")
    String gender();

    @Key("country")
    String country();
}
