package org.Page;

import org.BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement bookHotelText;
	
	public WebElement getBookHotelText() {
		return bookHotelText;
	}
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	
	public WebElement getAddress() {
		return address;
	}
	
	@FindBy(xpath="//input[@name='cc_num']")
	private WebElement ccNum;
	
	public WebElement getccNum() {
		return ccNum;
	}
	
	@FindBy(xpath="//select[@name='cc_type']")
	private WebElement ccType;
	
	public WebElement getccType() {
		return ccType;
	}
	
	@FindBy(xpath="//select[@name='cc_exp_month']")
	private WebElement ccExpMonth;
	
	public WebElement getccExpMonth() {
		return ccExpMonth;				
	}
	
	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement ccExpYear;
	
	public WebElement getccExpYear() {
		return ccExpYear;				
	}
	
	@FindBy(xpath="//input[@name='cc_cvv']")
	private WebElement ccCvv;
	
	public WebElement getccCvv() {
		return ccCvv;
	}
	
	@FindBy(xpath="//input[@name='book_now']")
	private WebElement bookButton;
	
	public WebElement getBookButton() {
		return bookButton;
	}
}

