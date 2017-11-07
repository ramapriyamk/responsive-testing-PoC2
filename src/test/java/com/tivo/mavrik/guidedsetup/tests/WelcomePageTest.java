package com.tivo.mavrik.guidedsetup.tests;

import com.galenframework.api.Galen;
import com.galenframework.api.GalenPageDump;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.tivo.mavrik.common.CommonUtils;
import com.tivo.mavrik.guidedsetup.components.HTCWelcomePage;
import com.tivo.mavrik.guidedsetup.components.ShopPage;
import com.tivo.mavrik.guidedsetup.tests.GalenTestBase.TestDevice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WelcomePageTest extends GalenTestBase {
	
	private HTCWelcomePage HTCwelcomePage;
	private ShopPage shopPage;
	
	List<GalenTestInfo> testing = new LinkedList<GalenTestInfo>();

	@Test(groups = { "testrun" }, dataProvider = "devices", description = "Verify Welcome Page Header and Footer", priority = 1)
	public void verify_Header_Footer_alignment(TestDevice device)
			throws IOException {
		load(TESTENV_URL);
		LayoutReport layoutReport = Galen.checkLayout(getDriver(),"/specs/mavrikCommon.spec", device.getTags());
		GalenTestInfo test = GalenTestInfo
				.fromString("Common elements on " +device.getTags()+ " test");
		test.getReport().layout(layoutReport,
				"Check Common elements on " + device.getTags());
		testing.add(test);
	}

	@Test(groups = { "testrun" }, dataProvider = "devices", description = "Verify Welcome Page fields", priority = 2)
	public void WelcomePage_validation(TestDevice device) throws IOException {
		load(TESTENV_URL);
		LayoutReport layoutReport = Galen.checkLayout(getDriver(),
				"/specs/mavrikWelcomePage.spec", device.getTags());
		GalenTestInfo test = GalenTestInfo
				.fromString("Welcome Page on " +device.getTags()+ " device test");
		test.getReport().layout(layoutReport,
				"Check Welcome page layout on " + device.getTags());
		testing.add(test);
		new HtmlReportBuilder().build(testing, "target");

	}
	
	
	@Test(groups = { "createPageDump2" }, dataProvider = "devices", description = "Create Page dump of Welcome Page", priority = 1)
	public void getHomePageDump(TestDevice device) throws IOException,
			InterruptedException {
		load(SAP_URL);
		GalenPageDump galen = new GalenPageDump("HTC Welcomepage");
		Thread.sleep(3000);
		galen.dumpPage(
				driver,
				"C:\\Selenium_tests\\responsive-testing-PoC2\\src\\test\\resources\\specs\\homePage.spec",
				"C:\\Selenium_tests\\responsive-testing-PoC2\\src\\test\\resources\\specs\\pageDumps-"
						+ device.getTags().get(0));
	}
	
	@Test(groups = { "createPageDump3" }, dataProvider = "devices", description = "Create Page dump of Welcome Page", priority = 1)
	public void checkHomePage(TestDevice device) throws IOException,
			InterruptedException {
		load(SAP_URL);
		Thread.sleep(3000);
		LayoutReport layoutReport = Galen.checkLayout(getDriver(),
				"/specs/homePage.spec", device.getTags());
		GalenTestInfo test = GalenTestInfo
				.fromString("Home Page on " +device.getTags()+ " device test");
		test.getReport().layout(layoutReport,
				"Check Home page layout on " + device.getTags());
		testing.add(test);
		new HtmlReportBuilder().build(testing, "target");
		
	}
	@Test(groups = { "createPageDump" }, dataProvider = "devices", description = "Create Page dump of Welcome Page", priority = 1)
	public void getCreateAccountPageDump(TestDevice device) throws IOException,
			InterruptedException {
		load(SAP_URL);
		GalenPageDump galen = new GalenPageDump("Mavrik Welcomepage");
		Thread.sleep(5000);
		if(device.getTags().get(0).equals("Iphone5")){
		CommonUtils.getScreenshotOfWebElement(driver, driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[2]/div[2]/ul/li[1]/div[1]")), "ProductTab", "C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\pageDumps-"
				+ device.getTags().get(0)+"\\objects");
		} else {
			CommonUtils.mouseHoverOnElementAndStay(driver, driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[1]/div[3]/ul/li[1]/div[1]")));
		}
		//CommonUtils.scrolldown(driver);
		//Thread.sleep(5000);
		galen.dumpPage(
				driver,
				"C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\homePage.spec",
				"C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\pageDumps-"
						+ device.getTags().get(0));
	}
	
	
	@Test(groups = { "createPageDump" }, dataProvider = "devices", description = "Create Page dump of Welcome Page", priority = 1)
	public void getProductCatalogPageDump(TestDevice device) throws IOException,
			InterruptedException {
		load(SAP_URL);
		GalenPageDump galen = new GalenPageDump("HTC Welcomepage");
		Thread.sleep(5000);
		if(device.getTags().get(0).equals("Iphone6")){
			driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[2]/div[2]/ul/li[1]/div[1]")).click();
			CommonUtils.getScreenshotOfWebElement(driver, driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[2]/div[2]/ul/li[1]/div[2]/a")), "ProductTab", "C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\pageDumps-"
					+ device.getTags().get(0)+"\\objects");
		}
		else {
			CommonUtils.mouseHoverOnElementAndStay(driver, driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[1]/div[3]/ul/li[1]/div[1]")));
			CommonUtils.getScreenshotOfWebElement(driver, driver.findElement(By.xpath("//div[@id='htc-header']/header/div/div[2]/div[2]/ul/li[1]/div[2]/a")), "ProductTab", "C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\pageDumps-"
					+ device.getTags().get(0)+"\\objects");
		}
		
		galen.dumpPage(
				driver,
				"C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\productCatalog.spec",
				"C:\\eclipse-jee-kepler-R-win32-x86_64\\eclipse\\galen-framework-PoC\\src\\test\\resources\\specs\\pageDumps-"
						+ device.getTags().get(0));
		//CommonUtils.scrolldown(driver);
		//Thread.sleep(5000);
	}
	
	@Test(groups = { "createPageDump1" }, dataProvider = "devices", description = "Create Page dump of Welcome Page", priority = 1)
	public void getShopProductPageDump(TestDevice device) throws IOException,
			InterruptedException {
		load(SAP_URL);
		this.HTCwelcomePage = PageFactory.initElements(driver, HTCWelcomePage.class);
		GalenPageDump galen = new GalenPageDump("HTC ShopPage");
		Thread.sleep(5000);
		if(device.getTags().get(0).equals("Iphone6")){
			this.shopPage=this.HTCwelcomePage.gotoFirstProductShopPageOnMobile();
			Thread.sleep(2000);
			this.shopPage.getfeatureDropdown().click();
			Thread.sleep(1000);
			//this.shopPage.getfeatureDropdown().click();
		}
		else {
			this.HTCwelcomePage.gotoFirstProductShopPageOnDesktop();
		}
		
		galen.dumpPage(
				driver,
				"C:\\Selenium_tests\\responsive-testing-PoC2\\src\\test\\resources\\specs\\ShopPage.spec",
				"C:\\Selenium_tests\\responsive-testing-PoC2\\src\\test\\resources\\specs\\pageDumps-"
						+ device.getTags().get(0));
		//CommonUtils.scrolldown(driver);
		//Thread.sleep(5000);
	}

}
