package com.tivo.mavrik.common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CommonUtils {
	
	
	public static void clearAndSendKeys(WebElement element ,String text){
		element.clear();
		element.sendKeys(text);
	}
	
	public static void scrolldown(WebDriver driver) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	
	public static void getScreenshotOfWebElement(WebDriver driver, WebElement element, String screenshotName, String screenshotLocation) throws IOException{
		final BufferedImage img;
		final BufferedImage cropImg;
		
		File viewPortscreengrab =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		img = ImageIO.read(viewPortscreengrab);
		
		//Crop the image to focus on the webelement
		//get the crop point for the crop image
		Point elementLocation = element.getLocation();
		Point elementWidthHeight = new Point (element.getSize().getWidth(), element.getSize().getHeight());
		cropImg =img.getSubimage(elementLocation.getX(), elementLocation.getY(), elementWidthHeight.getX(), elementWidthHeight.getY());
File elementscreengrab = new File(screenshotName+".png");
ImageIO.write(cropImg, "png", elementscreengrab);
		File screengrabLocation = new java.io.File(screenshotLocation);
		FileUtils.copyFileToDirectory(viewPortscreengrab, screengrabLocation);
		FileUtils.copyFileToDirectory(elementscreengrab, screengrabLocation);		
	}

public static void mouseHoverOnElement(WebDriver driver, WebElement element){
Actions builder = new Actions(driver);
builder.moveToElement(element).build().perform();
}

public static void mouseHoverOnElementAndStay(WebDriver driver, WebElement element) throws InterruptedException{
Actions builder = new Actions(driver);
builder.moveToElement(element).perform();
Thread.sleep(2000);
}
}
