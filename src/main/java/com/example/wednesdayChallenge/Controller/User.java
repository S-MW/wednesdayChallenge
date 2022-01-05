package com.example.wednesdayChallenge.Controller;

import com.example.wednesdayChallenge.PojoForms.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("users")
public class User {

    private double bankBalance = 3000;

    ArrayList <UserForm>users = new ArrayList();

    @GetMapping
    public ResponseEntity getUsers()
    {
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserForm userForm)
    {
        users.add(userForm);
        return ResponseEntity.ok().body("User Saved");
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody WithdrawForm withdrawForm)
    {
        // Check user is exist && password is correct
        if(!checkIfUserIsExist(withdrawForm.getId(),withdrawForm.getInputPassword()))
        {
            return ResponseEntity.status(400).body("User Not Found / Pass is wrong");
        }
        // check for his/her balance
        if(!checkTheBalance(withdrawForm))
        {
            return ResponseEntity.status(400).body("The balance less than withdraw amount");
        }
        return ResponseEntity.status(200).body("Successfully withdraw");
    }

    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody DepositForm depositForm)
    {
        // Check user is exist && password is correct
        if(!checkIfUserIsExist(depositForm.getId(),depositForm.getInputPassword()))
        {
            return ResponseEntity.status(400).body("User Not Found / Pass is wrong");
        }

        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId().equals(depositForm.getId()))
            {
                users.get(i).setBalance(users.get(i).getBalance() + depositForm.getDepositAmount());
            }
        }
        return ResponseEntity.status(200).body("Successfully deposit");
    }


    @PostMapping("/get_loan")
    public ResponseEntity getLoan(@RequestBody LoanForm loanForm)
    {
        // Check user is exist && password is correct
        if(!checkIfUserIsExist(loanForm.getId(),loanForm.getInputPassword()))
        {
            return ResponseEntity.status(400).body("User Not Found / Pass is wrong");
        }
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId().equals(loanForm.getId()))
            {
                users.get(i).setBalance(users.get(i).getBalance() + loanForm.getLoanAmount());
                users.get(i).setLoanAmount(users.get(i).getLoanAmount() + loanForm.getLoanAmount());
            }
        }
        return ResponseEntity.status(200).body("Successfully Loan");
    }

    @PostMapping("/pay_loan")
    public ResponseEntity payLoan(@RequestBody PayLoanForm payLoanForm)
    {
        // Check user is exist && password is correct
        if(!checkIfUserIsExist(payLoanForm.getId(),payLoanForm.getInputPassword()))
        {
            return ResponseEntity.status(400).body("User Not Found / Pass is wrong");
        }

        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId().equals(payLoanForm.getId()))
            {
                if(users.get(i).getBalance() >= users.get(i).getLoanAmount())
                {
                    users.get(i).setBalance(users.get(i).getBalance() - users.get(i).getLoanAmount());
                    users.get(i).setLoanAmount(0);
                    return ResponseEntity.status(200).body("Successfully pay Loan");

                }
            }
        }
        return ResponseEntity.status(400).body("You don't have Enough Money");
    }


    @PostMapping("/delete_User")
    public ResponseEntity deleteUser(@RequestBody DeleteUserForm deleteUserForm)
    {

        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getId().equals(deleteUserForm.getId()))
            {
                if(users.get(i).getLoanAmount() <= 0)
                {
                    users.remove(i);
                    return ResponseEntity.status(200).body("Successfully delete User");
                }
            }
        }
        return ResponseEntity.status(400).body("User still have Loan");
    }


















    //    ############### All business logic  ###############
    private boolean checkIfUserIsExist(String id, String password)
    {
        for (UserForm u:users)
        {
            // check if User Is Exist by id
            if(u.getId().equals(id))
            {
                //  if User id found check for the password
                if(u.getPassword().equals(password))
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    private boolean checkTheBalance(WithdrawForm withdrawForm)
    {
        for (UserForm u:users)
        {
            if(u.getId().equals(withdrawForm.getId()))
            {
                if(withdrawForm.getWithdrawAmount() > u.getBalance())
                {
                    return false;
                }
                u.setBalance(u.getBalance()-withdrawForm.getWithdrawAmount());
                return true;
            }
        }
        // ممكن يكون في حل افضل من هذا
        return false;
    }
}
