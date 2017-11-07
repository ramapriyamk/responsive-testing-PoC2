package com.tivo.mavrik.guidedsetup.tests;

import java.io.IOException;

import com.galenframework.api.GalenPageDump;
import com.galenframework.reports.model.LayoutReport;
import com.tivo.mavrik.guidedsetup.components.CreateAccount;
import com.tivo.mavrik.guidedsetup.components.WelcomePage;
import com.tivo.mavrik.guidedsetup.tests.GalenTestBase.TestDevice;

import net.mindengine.galen.api.Galen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAccountPageTest extends GalenTestBase {

	private WelcomePage welcomePage;
	private CreateAccount createAccount;

	@Test(groups = { "testrun" }, dataProvider = "devices", description = "Verify Create Account Page Header and Footer", priority = 2)
	public void verifyCreateAccountPageElements(TestDevice device)
			throws IOException, InterruptedException {
		load(TESTENV_URL);
		this.welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		this.createAccount = this.welcomePage.createNewCustAccount();
		this.welcomePage = this.createAccount.clickSignInLink();

		checkLayout("/specs/mavrikWelcomePage.spec", device.getTags());
	}
}
