package com.am9.spring_security_lab.constant;

/**
 * This class contain the names
 * of environment variables usd in
 * this app or other default values
 */
public final class AppConstants {

    public static final String JWT_SECRET_KEY = "JWT_SECRET_KEY";

    // MUST not be used for production, only testing and dev environments
    public static final String DEFAULT_JWT_SECRET_KEY = "b253b34edb4dd0048175b23d6e30dfcea4337fb6ccdb16504087e6428e46cbfa";

    public static final String JWT_EXP_TIME = "JWT_EXP_TIME";

    // Two hours
    public static final Long DEFAULT_JWT_EXP_TIME = 7200000L;

    public static final String JWT_HEADER = "Authorization";
}