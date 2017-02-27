package com.actio.configs;

import lombok.Value;

@Value
public class Constants {

    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static final String SYSTEM_ACCOUNT = "system";

}