package com.FinWorks.step_definitions;

import com.FinWorks.pages.LoginPage_AY;
import com.FinWorks.utilities.BrowserUtils;
import com.FinWorks.utilities.ConfigurationReader;
import com.FinWorks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs_AY {

    LoginPage_AY loginPage_ay = new LoginPage_AY();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_and(String username, String password) {

        loginPage_ay.login(username,password);

        loginPage_ay.waitUntilLoaderScreenDisappear();

    }

    @Then("the user should be able to login to the app")
    public void the_user_should_be_able_to_login_to_the_app() {

        BrowserUtils.waitFor(4);

        Assert.assertEquals("#Inbox - Odoo", Driver.get().getTitle());

    }


    @When("the user enters valid {string} but invalid {string}")
    public void the_User_Enters_Valid_But_Invalid(String username, String password) {

        loginPage_ay.login(username, password);


    }

    @Then("the user should NOT be able to login to the app")
    public void the_User_Should_NOT_Be_Able_To_Login_To_The_App() {

        Assert.assertEquals("Wrong login/password", loginPage_ay.failedLoginMessage());
    }

    @When("the user enters invalid {string} but valid {string}")
    public void the_User_Enters_Invalid_But_Valid(String username, String password) {

        loginPage_ay.login(username, password);
    }


}
