package org.Page;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement selectHotelText;
	
	public WebElement getSelectHotelText() {
		return selectHotelText;
	}
	
	@FindBy(xpath="//input[@name='radiobutton_0']")
	private WebElement radioButton;
	
	public WebElement getRadioButton() {
		return radioButton;
	}
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueButton;
	
	public WebElement getcontinueButton() {
		return continueButton;
	}
	
}
