package com.example.wednesdayChallenge.PojoForms;

public class LoanForm {
    private String id;
    private String inputPassword;
    private double loanAmount;


    public LoanForm(String id, String inputPassword, double loanAmount) {
        this.id = id;
        this.inputPassword = inputPassword;
        this.loanAmount = loanAmount;
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

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
}
