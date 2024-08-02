package org.execution;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.BaseClass.BaseClass;
import org.Manager.PageObjectManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginPageValidation {

	public static BaseClass base = new BaseClass();
	public static PageObjectManager pageObject = new PageObjectManager();

	@Test()
	private void browser_URL_Validation() {
		try {

			base.getDriver(base.readExcel(1, 0));
			base.windowMax();
			base.getUrl(base.readExcel(1, 1));

			if (base.readExcel(1, 1).equals(base.getCurrentUrl())) {
				System.out.println("URL_Successfully Launched");
				// Report - URL_Successfully Launched
			} else {
				System.out.println("URL_Not_Successfully Launched");
				// Report - URL_Not_Successfully Launched
			}
		} catch (NoSuchSessionException e) {
			System.out.println("Check_WebDriverManagerVersion" + e.getMessage());
			base.screenCapture();

		} catch (WebDriverException e) {
			System.out.println("Check_SeleniumVersion" + e.getMessage());
			base.screenCapture();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			base.screenCapture();
		}
	}

	@Test()
	private void user_Is_In_LoginPage_Validation() {
		try {
			if (pageObject.getLoginPage().getUserLogin().isDisplayed()) {

				System.out.println("User is in Login Page ");
				// Report - User is in Login Page
				if (pageObject.getLoginPage().getUserLogin().getText().contains("Build 1")) {
					System.out.println("User_Is_In_Build 1 ");
					// Report - User_Is_In_Build 1
				}
			}
			// To Validate User is in Login Page give result in Excel
			base.writeExcel(pageObject.getLoginPage().getUserLogin(), 4, 1);
		} catch (Exception e) {
			System.out.println("User_Not_In_LoginPage" + e.getMessage());
			base.screenCapture();
		}
		
	}

	@Test()
	private void user_Logins_Credentials_Validation() {
		try {

			base.sendKeysByJava(pageObject.getLoginPage().getUserName(), base.readExcel(1, 2));

			base.sendKeysByJava(pageObject.getLoginPage().getPassword(), base.readExcel(1, 3));

			// To Validate Login Button
			if (pageObject.getLoginPage().getLogin().isDisplayed()) {

				if (pageObject.getLoginPage().getLogin().isEnabled()) {

					base.click(pageObject.getLoginPage().getLogin());

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			base.screenCapture();
		}
	}
}