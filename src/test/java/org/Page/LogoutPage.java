package org.Page;
import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='logout']")
	private WebElement logoutButton;
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	@FindBy(xpath="//td[text()='You have successfully logged out. ']")
	private WebElement logoutPageText;
	
	public WebElement getLogoutPageText() {
		return logoutPageText;
	}
}
