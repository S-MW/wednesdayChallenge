package com.example.wednesdayChallenge.PojoForms;

public class WithdrawForm {

    private String id;
    private String inputPassword;
    private double withdrawAmount;

    public WithdrawForm(String id, String inputPassword, double withdrawAmount) {
        this.id = id;
        this.inputPassword = inputPassword;
        this.withdrawAmount = withdrawAmount;
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

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
