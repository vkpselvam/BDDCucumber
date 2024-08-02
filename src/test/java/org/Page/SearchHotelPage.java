package org.Page;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass{
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Search Hotel ']")
	private WebElement searchHotelText;
	
	public WebElement getSearchHotelText() {
		return searchHotelText;
	}
	
	@FindBy(xpath="//select[@id='location']")
	private WebElement location;
	
	public WebElement getLocation() {
		return location;
	}
	@FindBy(xpath="//select[@name='hotels']")
	private WebElement hotel;
	
	public WebElement getHotel() {
		return hotel;
	}	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	public WebElement getRoomType() {
		return roomType;
				
	}	
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement roomNos;
	
	public WebElement getRoomNos() {
		return roomNos;
	}
	@FindBy(xpath="//input[@name='datepick_in']")
	private WebElement checkIn;
	
	public WebElement getCheckIn() {
		return checkIn;
	}
	@FindBy(xpath="//input[@name='datepick_out']")
	private WebElement checkOut;
	
	public WebElement getCheckOut() {
		return checkOut;
	}
	@FindBy(xpath="//select[@name='adult_room']")
	private WebElement adultsPerRoom;
	
	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}
	@FindBy(xpath="//select[@name='child_room']")
	private WebElement childPerRoom;
		
	public WebElement childPerRoom() {
		return childPerRoom;
	}
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement submit;
	
	public WebElement submitButton() {
		return submit;
	}
}
