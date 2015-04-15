/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporters;

import java.io.Serializable;

/**
 *
 * @author best1yash
 */
public class Login implements Serializable{
    private String name;
    private Branch branch;
    private String login_id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Login(){
        name = null;
        branch = null;
        password = null;
        login_id = null;
    }
    
    public String getBranchName(){
        return branch.getName();
    }
    private static final long serialVersionUID = 1L;
}
