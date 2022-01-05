package com.example.wednesdayChallenge.PojoForms;

public class PayLoanForm {

    private String id;
    private String inputPassword;

    public PayLoanForm(String id, String inputPassword) {
        this.id = id;
        this.inputPassword = inputPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }
}
