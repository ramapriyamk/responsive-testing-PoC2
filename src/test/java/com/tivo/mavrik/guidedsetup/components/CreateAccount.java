package com.tivo.mavrik.guidedsetup.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.tivo.mavrik.common.CommonUtils;


public class CreateAccount{
	
	@FindBy(xpath="//a[@href='#/setup/login']")
	private WebElement SignInLink;

	@FindBy(id = "email")
	private WebElement EmailId;
	
	@FindBy(id ="firstName")
	private WebElement FirstName;
	
	@FindBy(id="lastName")
	private WebElement LastName;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement submitButton; 
	
	@FindBy(id="state")
	private WebElement selectState;
	
	@FindBy(id ="password")
	private WebElement pwd;
	
	@FindBy(id="passwordRepeat")
	private WebElement repeatPwd;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement City;
	
	@FindBy(id="zip")
	private WebElement zipCode;
	

	WebDriver driver;
	
	
	public CreateAccount(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void enterEmail(String email){
		EmailId.sendKeys(email);
	}
	
	public void enterFirstName(String fName){
		CommonUtils.clearAndSendKeys(FirstName, "fname");
	}
	
	public void enterLasTName(String lName){
		LastName.sendKeys(lName);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	public void selectState(String stateValue){
		Select stateDropdown= new Select(selectState);
		stateDropdown.selectByVisibleText(stateValue);
	}
	
	public WelcomePage clickSignInLink() throws InterruptedException{
		Thread.sleep(300);
		if (SignInLink.isDisplayed() || SignInLink.isEnabled())
		SignInLink.click();
		else System.out.println("Create Account page load failure");
		return PageFactory.initElements(driver, WelcomePage.class);
	}
}
