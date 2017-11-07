package com.tivo.mavrik.guidedsetup.tests;

import com.galenframework.testng.GalenTestNgTestBase;

import net.mindengine.galen.config.GalenConfig;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.pagefactory.*;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public abstract class GalenTestBase extends GalenTestNgTestBase {

	static WebDriver driver;
	protected static final String SAP_URL ="http://www.htc.com/us/";
	protected static final String TESTENV_URL = "https://www-qas.tivo.com/mavrik/#/setup/login?tsn=84A0001111417CE&zip=95002&relaystate=http:%2F%2Fmsetup-dev.s3-website-us-west-1.amazonaws.com%2F%3Ftsn%3D84A00011114140F%23welcome";
	protected static final String PAGEDUMP_URL = "https://forward.tivo.com/";
	//protected static final String PAGEDUMP_URL = "https://cyborg.tivo.com/mavrik/#/setup/login?tsn=84A0001111417CE&zip=95002&relaystate=http:%2F%2Fmsetup-dev.s3-website-us-west-1.amazonaws.com%2F%3Ftsn%3D84A00011114140F%23welcome";

	
	@Override
	public WebDriver createDriver(Object[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\selenium_servers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		/*File file = new File("C:/Program Files/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		driver = new PhantomJSDriver();*/
		
		/*System.setProperty("webdriver.chrome.driver",
		 "C:\\selenium_servers\\chromedriver.exe"); 
		driver = new ChromeDriver();*/
		 
		if (args.length > 0) {
			if (args[0] != null && args[0] instanceof TestDevice) {
				TestDevice device = (TestDevice) args[0];
				if (device.getScreenSize() != null) {
					driver.manage().window().setSize(device.setScreenSize());

				}
			}
		}
		return driver;
	}

	public void load(String uri) {
		driver.get(uri);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@DataProvider(name = "devices")
	public Object[][] devices() {
		return new Object[][] {
				/*{ new TestDevice("tablet", new Dimension(768, 1024),
						asList("tablet")) },
				{ new TestDevice("desktop", new Dimension(1920, 959),
						asList("desktop")) },*/
				{ new TestDevice("Iphone6plus", new Dimension(412, 732),
						asList("Iphone6plus")) },
				{ new TestDevice("Nexus", new Dimension(375, 667),
								asList("Nexus")) } };
	}

	public static class TestDevice {
		private final String name;
		private final Dimension screenSize;
		private final List<String> tags;

		public TestDevice(String name, Dimension screenSize, List<String> tags) {
			this.name = name;
			this.screenSize = screenSize;
			this.tags = tags;
		}

		public Dimension setScreenSize() {
			driver.manage().window().maximize();
			@SuppressWarnings("rawtypes")
			ArrayList padding = (ArrayList)((JavascriptExecutor) driver).executeScript(
					  "return [window.outerWidth-window.innerWidth, window.outerHeight-window.innerHeight];");
			Dimension size = new Dimension((int)((getScreenSize().width +(Long)padding.get(0))), (int)((getScreenSize().height +(Long)padding.get(1))));
			System.out.println(  "Width is:" +size.width + "Height is:"+ size.height);
			return size;
		}

		public String getName() {
			return name;
		}

		public Dimension getScreenSize() {
			return screenSize;
		}

		public List<String> getTags() {
			return tags;
		}

		@Override
		public String toString() {
			return String.format("%s %dx%d", name, screenSize.width,
					screenSize.height);
		}
	}
}
