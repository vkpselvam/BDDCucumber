package org.Page;

import org.BaseClass.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyItenaryPage extends BaseClass{
	public MyItenaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Booked Itinerary']")
	private WebElement bookedItenaryText;
	
	public WebElement getBookedItenaryText() {
		return bookedItenaryText;
	}

	@FindBy(xpath="//input[@id='btn_id_1257464']")
	private WebElement cancelOrder;
	
	public WebElement getCancelOrderID() {
		return cancelOrder;
	}
	
	public void alertCommand(String alertPop) {
		Alert alert=driver.switchTo().alert();
		switch (alertPop) {
		case "Accept":
			alert.accept();
			break;
		case "Cancel":
		alert.dismiss();;
		default:
			System.out.println("InValid Alert Command");
			break;
		}
	}
	
	@FindBy(xpath="//label[@id='search_result_error']")
	private WebElement canceltext;
	
	public WebElement getCanceltext() {
		return canceltext;
	}
	
	@FindBy(xpath="//label[@id='search_result_error']")
	private WebElement orderCancelledText;
	
	public WebElement getOrderCancelledText() {
		return orderCancelledText;
	}
}
