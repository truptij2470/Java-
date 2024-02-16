package com.app.pojoscom.app.service;

import com.app.exception.AuthenticationException;

public class AuthService {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String CUSTOMER_USERNAME = "c1";
    private static final String CUSTOMER_PASSWORD = "c1";

    public void login(String username, String password) throws AuthenticationException {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Admin login successful.");
        } else if (username.equals(CUSTOMER_USERNAME) && password.equals(CUSTOMER_PASSWORD)) {
            System.out.println("Customer login successful.");
        } else {
            throw new AuthenticationException("Invalid username or password.");
        }
    }
}
