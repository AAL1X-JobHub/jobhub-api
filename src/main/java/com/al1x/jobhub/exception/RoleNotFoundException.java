package com.al1x.jobhub.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException() {
        super("Role not found for the user.");
    }
    public RoleNotFoundException(String message) {
        super(message);
    }
}