package com.FinWorks.pages;

import com.FinWorks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_AY extends BasePage{

    public LoginPage_AY() {

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@id='login']")
    private WebElement emailInputBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href='/web/reset_password?']")
    private WebElement resetPassword;

    @FindBy(xpath = "//p[contains(text(),'Wrong login/password')]")
    private WebElement failedLoginMessage;

    public void login(String username, String password) {
        emailInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        submitButton.click();

    }

    public String failedLoginMessage() {

        return failedLoginMessage.getText();

    }



}


