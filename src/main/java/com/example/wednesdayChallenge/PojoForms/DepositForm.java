package com.example.wednesdayChallenge.PojoForms;

public class DepositForm {

    private String id;
    private String inputPassword;
    private double depositAmount;

    public DepositForm(String id, String inputPassword, double depositAmount) {
        this.id = id;
        this.inputPassword = inputPassword;
        this.depositAmount = depositAmount;
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

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }
}
