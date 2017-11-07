package com.tivo.mavrik.guidedsetup.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.annotations.*;

import java.io.IOException;

public class WelcomePage {
	
	@FindBy(xpath ="//a[@href='#/setup/signup']")
	private WebElement customerCreate;
	
	@FindBy(id="email")
	private WebElement EmailId;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement SignInBtn;

    WebDriver driver;

	public WelcomePage (WebDriver driver){
		this.driver = driver;
	}
	
	public void setEmailAdress(String strEmailId){
		EmailId.clear();
		EmailId.sendKeys(strEmailId);
	}
	
	public void setPassword(String strPassword){
		Password.clear();
		Password.sendKeys(strPassword);
	}
	
	public void login(){
		SignInBtn.click();
	}

	public CreateAccount createNewCustAccount(){
		if(customerCreate.isDisplayed() || customerCreate.isEnabled())
		customerCreate.click();
		else System.out.println("Welcome Page load Failure");
		return PageFactory.initElements(driver, CreateAccount.class);
	}
}
