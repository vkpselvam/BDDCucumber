package org.Page;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPage extends BaseClass{
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='order_no']")
	private WebElement orderId;
	
	public WebElement getOrderId() {
	return orderId;	
	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement bookingConfirmationText;
	
	public WebElement getBookingConfirmationText() {
		return bookingConfirmationText;
	}
	
	@FindBy(xpath="//input[@name='my_itinerary']")
	private WebElement myItenarybutton;
	
	public WebElement getMyItenaryButton() {
		return myItenarybutton;
	}

}
