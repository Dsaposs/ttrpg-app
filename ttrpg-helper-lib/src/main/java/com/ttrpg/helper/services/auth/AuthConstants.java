package com.ttrpg.helper.services.auth;

public class AuthConstants {
    public static final String AUTHORIZATION_SERVICE = "http://authorization-service/";

    public static final String AUTHORIZATION_URI = "/authorization";
    public static final String ADMIN_URI = "/admin";
    public static final String AUTHORIZATION_ALL_URI = "/all";
    public static final String AUTHORIZATION_ADD_URI = "/add";
    public static final String AUTHORIZATION_LOGIN_URI = "/login";
    public static final String TEMP_USER_HOST_ID = "{userId}";
    public static final String AUTHORIZATION_ADD_TEMP_URI = "/add/" + TEMP_USER_HOST_ID;

    public static final String USER = "USER";
    public static final String TEMP_USER = "TEMP_USER";
    public static final String ADMIN = "ADMIN";
}