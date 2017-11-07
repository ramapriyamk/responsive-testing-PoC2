package com.tivo.mavrik.guidedsetup.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage {
	WebDriver driver;

	@FindBy(xpath="//section[@id='htc-main']/div/div[2]/div/div/div[1]/div[1]")
	private WebElement featuresDropdown;
	
	public ShopPage(WebDriver driver){
		this.driver =driver;
	}
	
	public WebElement getfeatureDropdown(){
		return featuresDropdown;
	}
	
}
