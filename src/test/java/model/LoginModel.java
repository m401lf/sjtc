package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder

public class LoginModel {
    private String loginname;
    private String password;

    public LoginModel() {

    }

    public static LoginModel createLoginModel(Map<String, String> entry) {
        LoginModel loginModel = new LoginModel();
        //Table of the feature file
        loginModel.setLoginname(entry.get("loginname"));
        loginModel.setPassword(entry.get("password"));
        return loginModel;
    }

    public String getLoginname() {
        return loginname;

    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;

    }

    public String getPassword() {
        return password;

    }

    public void setPassword(String password) {
        this.password = password;

    }
}
