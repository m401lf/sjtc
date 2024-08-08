package com.automationteststore.testCases.Login;


import helper.assertion.AssertionHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.TopMenuNavigationPage;

import java.io.IOException;
import java.sql.*;

@Listeners(base.Listeners.class)

public class login_validation_jdbc_connection extends BaseTest {
    TopMenuNavigationPage naviPage;
    LoginPage loginPage;
    MyAccountPage accountPage;
    String driverName = "com.mysql.cj.jdbc.Driver";
    String dataBaseName = "customers";
    String hostname = "localhost";
    String username = "root";
    String password = "root";
    String port = "3306";
    String query = "SELECT * from userlogin where User";
    String connectionUrl = "jdbc:mysql://"+hostname+":"+port+"/"+dataBaseName+"";
    String executeQueryForDev = ""+query+" = 'dev';";
    String executeQueryTester = "SELECT * from userlogin where User = 'tester';";
    String executeQueryTestManager = "SELECT * from userlogin where User = 'testmanager';";
    String executeQueryTester1 = "SELECT * from userlogin where User = 'tester1';";
    String executeQueryTester2 = "SELECT * from userlogin where User = 'tester2';";
    String executeQuerySdet = "SELECT * from userlogin where User = 'sdet';";

    @BeforeMethodMethod
    public void setUpDatabaseConnection() throws Exception {
        naviPage = new TopMenuNavigationPage(driver);
        loginPage= naviPage.clickOnLoginOrRegisterLink();
        Class.forName(driverName);

    }

    @Test(priority = 1)
    public void connectDatabaseDevByColumnIndex() throws SQLException, IOException {
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        ResultSet rs = con.createStatement().executeQuery(executeQueryForDev);
        while (rs.next()) {
            loginPage.enterLoginName(rs.getString(2));
            System.out.println(" :: " + rs.getString(2));
            loginPage.enterPassword(rs.getString(3));
            System.out.println(" :: " + rs.getString(3));
            accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();
            AssertionHelper.updateTestStatus(accountPage.getWelcomeMessageTxt().contains(rs.getString(4)));
            AssertionHelper.updateTestStatus(accountPage.assertPageHeaderIsDisplayed());
            driver.quit();

        }

    }

    @Test(priority = 2)
    public void connectDatabaseTestManagerByColumnLabel() throws SQLException, IOException {
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(executeQueryTestManager);
        while (rs.next()) {
            loginPage.enterLoginName(rs.getString("LoginName"));
            System.out.println(" :: " + rs.getString("LoginName"));
            loginPage.enterPassword(rs.getString("Password"));
            System.out.println(" :: " + rs.getString("Password"));
            accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();
            AssertionHelper.updateTestStatus(accountPage.getWelcomeMessageTxt().contains(rs.getString("Validation_Confirmation_Message")));
            AssertionHelper.updateTestStatus(accountPage.assertPageHeaderIsDisplayed());
            driver.quit();

        }

    }

    @Test(priority = 3)
    public void connectDatabaseTesterByColumnLabel() throws SQLException, IOException {
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(executeQueryTester);
        while (rs.next()) {
            loginPage.enterLoginName(rs.getString("LoginName"));
            System.out.println(" :: " + rs.getString("LoginName"));
            loginPage.enterPassword(rs.getString("Password"));
            System.out.println(" :: " + rs.getString("Password"));
            loginPage.clickOnLoginButtonInAccountLoginPage();
            AssertionHelper.updateTestStatus(loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(rs.getString("Validation_Confirmation_Message")));
            AssertionHelper.updateTestStatus(loginPage.assertPageHeaderIsDisplayed());
            driver.quit();

        }

    }

    @Test(priority = 4)
    public void connectDatabaseTester1ByColumnLabel() throws SQLException, IOException {
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(executeQueryTester1);
        while (rs.next()) {
            loginPage.enterLoginName(rs.getString("LoginName"));
            System.out.println(" :: " + rs.getString("LoginName"));
            loginPage.enterPassword(rs.getString("Password"));
            System.out.println(" :: " + rs.getString("Password"));
            loginPage.clickOnLoginButtonInAccountLoginPage();
            AssertionHelper.updateTestStatus(loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(rs.getString("Validation_Confirmation_Message")));
            AssertionHelper.updateTestStatus(loginPage.assertPageHeaderIsDisplayed());
            driver.quit();

        }

    }

    @Test(priority = 5)
    public void connectDatabaseTester2ByColumnLabel() throws SQLException, IOException {
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(executeQueryTester2);
        while (rs.next()) {
            loginPage.enterLoginName(rs.getString("LoginName"));
            System.out.println(" :: " + rs.getString("LoginName"));
            loginPage.enterPassword(rs.getString("Password"));
            System.out.println(" :: " + rs.getString("Password"));
            loginPage.clickOnLoginButtonInAccountLoginPage();
            AssertionHelper.updateTestStatus(loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(rs.getString("Validation_Confirmation_Message")));
            AssertionHelper.updateTestStatus(loginPage.assertPageHeaderIsDisplayed());
            driver.quit();

        }

    }

    @Test(priority = 6)
    public void connectDatabaseSdetByColumnLabel() throws SQLException, IOException {
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(executeQuerySdet);
        while (rs.next()) {
            loginPage.enterLoginName(rs.getString("LoginName"));
            System.out.println(" :: " + rs.getString("LoginName"));
            loginPage.enterPassword(rs.getString("Password"));
            System.out.println(" :: " + rs.getString("Password"));
            loginPage.clickOnLoginButtonInAccountLoginPage();
            AssertionHelper.updateTestStatus(loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(rs.getString("Validation_Confirmation_Message")));
            AssertionHelper.updateTestStatus(loginPage.assertPageHeaderIsDisplayed());
            driver.quit();

        }

        con.close();
    }

}