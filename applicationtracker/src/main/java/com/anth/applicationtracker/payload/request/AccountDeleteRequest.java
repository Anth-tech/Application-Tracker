package com.anth.applicationtracker.payload.request;

import jakarta.validation.constraints.NotBlank;

public class AccountDeleteRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String confirmation;

    public AccountDeleteRequest(String username, String confirmation) {
        this.username = username;
        this.confirmation = confirmation;
    }

    public String getUsername() {
        return username;
    }
    public String getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
}
