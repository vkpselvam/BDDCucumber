package org.Step;

import org.BaseClass.BaseClass;
import org.Manager.PageObjectManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep extends BaseClass {

	public static BaseClass base = new BaseClass();
	public static PageObjectManager pageObject = new PageObjectManager();

	@When("User should be in Adactin Login Page")
	public void user_should_be_in_adactin_login_page() {
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

	@When("User should enter the valid credentials")
	public void user_should_enter_the_valid_credentials() {
		base.sendKeysByJava(pageObject.getLoginPage().getUserName(), base.readExcel(1, 2));

		base.sendKeysByJava(pageObject.getLoginPage().getPassword(), base.readExcel(1, 3));

		// To Validate Login Button
	}

	@When("User should click Login button")
	public void user_should_click_login_button() {
		try {

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

	@Then("User should validate Login Success")
	public void user_should_validate_login_success() {
		try {

			// To Validate User is In Search Hotel Page or Not
			if (pageObject.getSearchHotelPage().getSearchHotelText().isDisplayed()) {
				System.out.println("User_Is_In_SearchHotel Page");
				// Report - User_Is_In_SearchHotel Page
			}

			// To Validate User Credentials are valid or Not = in Excel
			base.UserWriteExcel(pageObject.getSearchHotelPage().getSearchHotelText(), 4, 3,
					"User Successfully Logged In");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			base.screenCapture();
		}
	}
}
