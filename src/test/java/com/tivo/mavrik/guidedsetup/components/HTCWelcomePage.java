package com.tivo.mavrik.guidedsetup.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tivo.mavrik.common.CommonUtils;

public class HTCWelcomePage {

	WebDriver driver;
		
	@FindBy(xpath ="//div[2]/ul[@class='menu-list']/li[1]/div[1]")
	private WebElement Mproducts;
	
	@FindBy(xpath ="//div[@class='header-wrapper']/div[2]/div[2]/ul/li[1]/div[2]/a[1]")
	private WebElement MfirstProductPage;
	
	@FindBy(xpath ="//div[@class='header-wrapper']/div[1]/div[3]/ul/li[1]/div[2]/div[1]/div/a[1]")
	private WebElement DfirstProductPage;
		
	public HTCWelcomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public ShopPage gotoFirstProductShopPageOnDesktop() throws InterruptedException{
		CommonUtils.mouseHoverOnElementAndStay(driver, driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[1]/div[3]/ul/li[1]/div[1]/a")));
		DfirstProductPage.click();
		Thread.sleep(3000);
		return PageFactory.initElements(driver, ShopPage.class);
	}
	
	public ShopPage gotoFirstProductShopPageOnMobile() throws InterruptedException{
		Mproducts.click();
		Thread.sleep(1000);
		MfirstProductPage.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, ShopPage.class);
	}
	
	
}
