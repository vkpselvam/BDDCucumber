package org.Page;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//input[@id='login']")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

	@FindBy(xpath = "//td[text()='Existing User Login - Build 1']")
	private WebElement UserLogin;

	public WebElement getUserLogin() {
		return UserLogin;
	}

}
