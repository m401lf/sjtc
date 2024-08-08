package com.automationteststore.testCases.Registration;

import com.automationteststore.base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners(base.Listeners.class)

@Test
public class TC_001_Registration_Excel_Input extends BaseTest {

    TopMenuNavigationPage naviPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;


    public void verify_Register_Excel_Input() throws IOException, InterruptedException {
        String file=System.getProperty("user.dir")+"/src/test/java/testData/registerdata.xlsx";
        int rows= ExcelUtils.getRowCount(file, "Sheet1");

        for(int i=1;i<=rows;i++) {
            //read data from excel
            String firstname = ExcelUtils.getCellData(file, "Sheet1", i, 0);
            String lastname = ExcelUtils.getCellData(file, "Sheet1", i, 1);
            String telephone = ExcelUtils.getCellData(file, "Sheet1", i, 2);
            String fax = ExcelUtils.getCellData(file, "Sheet1", i, 3);
            String companyName = ExcelUtils.getCellData(file, "Sheet1", i, 4);
            String address1 = ExcelUtils.getCellData(file, "Sheet1", i, 5);
            String address2 = ExcelUtils.getCellData(file, "Sheet1", i, 6);
            String city = ExcelUtils.getCellData(file, "Sheet1", i, 7);
            String postalCode = ExcelUtils.getCellData(file, "Sheet1", i, 8);
            String regionOrState = ExcelUtils.getCellData(file, "Sheet1", i, 9);
            String password = ExcelUtils.getCellData(file, "Sheet1", i, 11);
            String headerText = ExcelUtils.getCellData(file, "Sheet1", i, 12);


            naviPage = new TopMenuNavigationPage(driver);
            loginPage = naviPage.navigateToLoginPage();
            register = loginPage.navigateToRegisterPage();

            //pass data to the app
            register.enterFirstName(firstname);
            register.enterLastName(lastname);
            register.enterEmailAddress();
            register.enterTelephoneNumber(telephone);
            register.enterFaxNumber(fax);
            register.enterCompanyName(companyName);
            register.enterAddress1(address1);
            register.enterAddress2(address2);
            register.enterCity(city);
            register.selectRegionOrState(regionOrState);
            register.enterPostalOrZipCode(postalCode);
            register.inputUniqueLoginName();
            register.enterPassword(password);
            register.enterPasswordConfirm(password);
            register.tickOnSubscribeAsYes();
            register.checkOnIAgreeToPrivacyPolicyRadioButton();
            successPage = register.navigateToAccountSuccessPage();

            //validation & update results in excel
            String actual = successPage.getCongratulationsAccountSuccessfullyCreatedText();

            if(headerText.contains(actual))
            {
                System.out.println("Test Passed");
                //log.info("Test Passed");
                ExcelUtils.setCellData(file, "Sheet1",i,14,"Passed");
                ExcelUtils.fillGreenColor(file, "Sheet1",i,14);
            }
            else
            {
                //System.out.println("Test Failed");
                ExcelUtils.setCellData(file, "Sheet1",i,14,"Failed");
                ExcelUtils.fillRedColor(file, "Sheet1",i,14);
            }

        }
            Thread.sleep(5000);





        }

    }









