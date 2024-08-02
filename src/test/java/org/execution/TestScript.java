package org.execution;

import java.io.IOException;

import org.BaseClass.BaseClass;
import org.Page.BookHotelPage;
import org.Page.BookingConfirmationPage;
import org.Page.LoginPage;
import org.Page.LogoutPage;
import org.Page.MyItenaryPage;
import org.Page.SearchHotelPage;
import org.Page.SelectHotelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestScript extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		BaseClass base = new BaseClass();
		base.getDriver(base.readExcel(1, 0));
		base.windowMax();
		base.getUrl(base.readExcel(1, 1));

		// To Validate Url
		if (base.readExcel(1, 1).equals(base.getCurrentUrl())) {
			System.out.println("URL_Successfully Launched");
			// Report - URL_Successfully Launched
		} else {
			System.out.println("URL_Not_Successfully Launched");
			// Report - URL_Not_Successfully Launched
		}

		LoginPage loginPage = new LoginPage();
		// To Validate User is in Login Page or Not

		if (loginPage.getUserLogin().isDisplayed()) {
			System.out.println("User is in Login Page ");
			// Report - User is in Login Page
			if (loginPage.getUserLogin().getText().contains("Build 1")) {

				System.out.println("User_Is_In_Build 1 ");
				// Report - User_Is_In_Build 1
			}
		}

		// To Validate User is in Login Page give result in Excel
		base.writeExcel(loginPage.getUserLogin(), 4, 1);

		WebElement userName = loginPage.getUserName();
		base.sendKeysByJS(userName, base.readExcel(1, 2));
		base.screenCapture();

		WebElement password = loginPage.getPassword();
		base.sendKeysByJava(password, base.readExcel(1, 3));
		base.screenCapture();

		WebElement loginButton = loginPage.getLogin();

		// To Validate Login Button
		if (loginPage.getLogin().isDisplayed()) {

			if (loginPage.getLogin().isEnabled()) {

				base.click(loginButton);

			}
		}

		base.screenCapture();

		// To Validate User is In Search Hotel Page or Not
		SearchHotelPage searchHotelPage = new SearchHotelPage();

		if (searchHotelPage.getSearchHotelText().isDisplayed()) {
			System.out.println("User_Is_In_SearchHotel Page");
			// Report - User_Is_In_SearchHotel Page
		}

		Thread.sleep(1000);

		// To Validate User Credentials are valid or Not
		base.UserWriteExcel(searchHotelPage.getSearchHotelText(), 4, 3, "User Successfully Logged In");

		// how to Select
		WebElement location = searchHotelPage.getLocation();
		base.selectByValue(location, base.readExcel(1, 4));

		WebElement hotel = searchHotelPage.getHotel();
		base.selectByValue(hotel, base.readExcel(1, 5));

		WebElement roomType = searchHotelPage.getRoomType();
		base.selectByValue(roomType, base.readExcel(1, 6));

		WebElement roomNos = searchHotelPage.getRoomNos();
		base.selectByVisibleText(roomNos, base.readExcel(1, 7));

		WebElement checkIn = searchHotelPage.getCheckIn();
		base.sendKeysByJava(checkIn, base.readExcel(1, 8));

		WebElement checkOut = searchHotelPage.getCheckOut();
		base.sendKeysByJava(checkOut, base.readExcel(1, 9));

		WebElement noOfAdults = searchHotelPage.getAdultsPerRoom();
		base.selectByVisibleText(noOfAdults, base.readExcel(1, 10));

		WebElement noOfChild = searchHotelPage.childPerRoom();
		base.selectByVisibleText(noOfChild, base.readExcel(1, 11));

		if (searchHotelPage.submitButton().isDisplayed()) {
			if (searchHotelPage.submitButton().isEnabled()) {
				WebElement submitButton = searchHotelPage.submitButton();
				base.click(submitButton);
			}
		}
		Thread.sleep(3000);

		SelectHotelPage selectHotelPage = new SelectHotelPage();

		if (selectHotelPage.getSelectHotelText().isDisplayed()) {
			System.out.println("User is in Select Hotel Page");
		}
		base.UserWriteExcel(selectHotelPage.getSelectHotelText(), 4, 5, "User is in Select Hotel Page");

		WebElement radioButton = selectHotelPage.getRadioButton();
		base.click(radioButton);

		if (selectHotelPage.getcontinueButton().isDisplayed()) {
			if (selectHotelPage.getcontinueButton().isEnabled()) {
				WebElement continueButton = selectHotelPage.getcontinueButton();
				base.click(continueButton);
			}
		}

		Thread.sleep(2000);

		BookHotelPage bookHotel = new BookHotelPage();
		if (bookHotel.getBookHotelText().isDisplayed()) {
			System.out.println("User is in Book Hotel Page");
		}
		base.UserWriteExcel(bookHotel.getBookHotelText(), 4, 6, "User is in Book Hotel Page");

		WebElement firstName = bookHotel.getFirstName();
		base.sendKeysByJava(firstName, base.readExcel(1, 12));

		WebElement lastName = bookHotel.getLastName();
		base.sendKeysByJava(lastName, base.readExcel(1, 13));

		WebElement address = bookHotel.getAddress();
		base.sendKeysByJava(address, base.readExcel(1, 14));

		WebElement ccNum = bookHotel.getccNum();
		base.sendKeysByJava(ccNum, base.readExcel(1, 15));

		WebElement ccType = bookHotel.getccType();
		base.selectByValue(ccType, base.readExcel(1, 16));

		WebElement ccExpMonth = bookHotel.getccExpMonth();
		base.selectByVisibleText(ccExpMonth, base.readExcel(1, 17));

		WebElement ccExpYear = bookHotel.getccExpYear();
		base.sendKeysByJava(ccExpYear, base.readExcel(1, 18));

		WebElement ccCvv = bookHotel.getccCvv();
		base.sendKeysByJava(ccCvv, base.readExcel(1, 19));

		if (bookHotel.getBookButton().isDisplayed()) {
			WebElement bookButton = bookHotel.getBookButton();
			base.click(bookButton);
		}
		Thread.sleep(5000);

		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		WebElement orderId = bookingConfirmationPage.getOrderId();
		Thread.sleep(4000);
		System.out.println(base.getAttributeByJava(orderId));

		if (bookingConfirmationPage.getBookingConfirmationText().isDisplayed()) {
			System.out.println("Booking Confirmed");
		}
		base.UserWriteExcel(orderId, 4, 7, "Booking Confirmed");

		WebElement myItenaryButton = bookingConfirmationPage.getMyItenaryButton();
		base.click(myItenaryButton);

		Thread.sleep(2000);
		MyItenaryPage myItenary = new MyItenaryPage();
		WebElement myItenaryText = myItenary.getBookedItenaryText();

		if (myItenary.getBookedItenaryText().isDisplayed()) {
			System.out.println("User is in My Itenary Page");
		}
		base.UserWriteExcel(myItenaryText, 4, 8, "User is in My Itenary Page");
		
		Thread.sleep(3000);

		WebElement cancelOrderId = myItenary.getCancelOrderID();

		if (myItenary.getCancelOrderID().isDisplayed()) {
			if (myItenary.getCancelOrderID().isEnabled()) {
				base.click(cancelOrderId);
				System.out.println("Order has been Cancelled Successfully");
			}
			else {
				System.out.println("Order not Cancelled Successfully");
			}
		}

		Thread.sleep(2000);

		myItenary.alertCommand("Accept");

		Thread.sleep(3000);		

		LogoutPage logoutPage = new LogoutPage();

		WebElement logoutButton = logoutPage.getLogoutButton();
		base.click(logoutButton);

		if (logoutPage.getLogoutPageText().isDisplayed()) {
			System.out.println("User Successfully Logged out");
		} else {
			System.out.println("User not successfully Logged out");
		}
	}
}

/*
 * // To Validate User is in Login Page or Not WebElement UserLogin =
 * driver.findElement(By.xpath("//td[text()='Existing User Login - Build 1']"));
 * if (UserLogin.isDisplayed()) { System.out.println("User is in Login Page ");
 * // Report - User is in Login Page if
 * (UserLogin.getText().contains("Build 1")) {
 * 
 * System.out.println("User_Is_In_Build 1 "); // Report - User_Is_In_Build 1
 * 
 * } } Thread.sleep(2000);
 * 
 * // To Validate User is in Login Page give result in Excel
 * //base.writeExcel(UserLogin, 4, 1); base.UserWriteExcel(UserLogin, 4, 1,
 * "Logged in Successfully"); WebElement userName =
 * driver.findElement(By.id("username")); base.sendKeysByJS(userName,
 * base.readExcel(1, 2)); base.screenCapture();
 * 
 * WebElement password = driver.findElement(By.id("password"));
 * base.sendKeysByJava(password, base.readExcel(1, 3)); base.screenCapture();
 * 
 * WebElement loginButton = driver.findElement(By.id("login"));
 * 
 * // To Validate Login Button if (loginButton.isDisplayed()) {
 * 
 * if (loginButton.isEnabled()) { base.click(loginButton); } }
 * Thread.sleep(2000); base.screenCapture();
 * 
 * //To Validate User is In Search Hotel Page or Not WebElement searchHotel =
 * driver.findElement(By.xpath("//td[text()='Search Hotel ']")); if
 * (searchHotel.isDisplayed()) {
 * System.out.println("User_Is_In_SearchHotel Page"); //Report -
 * User_Is_In_SearchHotel Page }
 * 
 * 
 * // To Validate User Credentials are valid or Not
 * base.UserWriteExcel(searchHotel, 4, 3,"User Successfully Logged In");
 * 
 * // how to Select WebElement location = driver.findElement(By.id("location"));
 * base.selectByValue(location, base.readExcel(1, 4));
 * 
 * WebElement hotels = driver.findElement(By.id("hotels"));
 * base.selectByVisibleText(hotels, base.readExcel(1, 5));
 * 
 * WebElement roomType = driver.findElement(By.id("room_type"));
 * base.selectByVisibleText(roomType, base.readExcel(1, 6));
 * 
 * WebElement noOfRooms = driver.findElement(By.id("room_nos"));
 * base.selectByVisibleText(noOfRooms, base.readExcel(1, 7));
 * 
 * WebElement checkInDate = driver.findElement(By.id("datepick_in"));
 * base.sendKeysByJS(checkInDate, base.readExcel(1, 8));
 * 
 * WebElement checkOutDate = driver.findElement(By.id("datepick_out"));
 * base.sendKeysByJS(checkOutDate, base.readExcel(1, 9));
 * 
 * WebElement noOfAdults = driver.findElement(By.name("adult_room"));
 * base.selectByVisibleText(noOfAdults, base.readExcel(1, 10));
 * 
 * WebElement noOfChilds = driver.findElement(By.id("child_room"));
 * base.selectByVisibleText(noOfChilds, base.readExcel(1, 11));
 * base.screenCapture();
 * 
 * WebElement submit = driver.findElement(By.id("Submit"));
 * if(submit.isDisplayed()) { if(submit.isEnabled()) { base.click(submit); } }
 * Thread.sleep(2000);
 * 
 * //To Validate whether you are in Select Hotel Page
 * 
 * WebElement selectHotel =
 * driver.findElement(By.xpath("//td[text()='Select Hotel ']"));
 * if(selectHotel.isDisplayed()) {
 * System.out.println("User is in Select Hotel Page"); // Report User is in
 * Select Hotel Page
 * 
 * } base.UserWriteExcel(selectHotel, 4, 5, "User is in Select Hotel Page");
 * 
 * WebElement continueButton =
 * driver.findElement(By.xpath("//input[@id='continue']")); WebElement
 * selectHotelRadioButton = driver.findElement(By.id("radiobutton_0"));
 * if(continueButton.isDisplayed()) { if(continueButton.isEnabled()) {
 * base.click(selectHotelRadioButton); base.click(continueButton); } }
 * Thread.sleep(2000); base.screenCapture();
 * 
 * WebElement bookHotel =
 * driver.findElement(By.xpath("//td[text()='Book A Hotel ']"));
 * if(bookHotel.isDisplayed()) {
 * System.out.println("User is in Book Hotel Page");
 * 
 * } WebElement firstName = driver.findElement(By.id("first_name"));
 * base.sendKeysByJS(firstName, base.readExcel(1, 12));
 * 
 * WebElement lastName = driver.findElement(By.id("last_name"));
 * base.sendKeysByJS(lastName, base.readExcel(1, 13));
 * 
 * WebElement billAddress = driver.findElement(By.id("address"));
 * base.sendKeysByJava(billAddress, base.readExcel(1, 14));
 * 
 * WebElement ccNum = driver.findElement(By.id("cc_num"));
 * base.sendKeysByJava(ccNum, base.readExcel(1, 15));
 * 
 * WebElement ccType = driver.findElement(By.id("cc_type"));
 * base.selectByValue(ccType, base.readExcel(1, 16));
 * 
 * WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
 * base.selectByVisibleText(ccExpMonth, base.readExcel(1, 17));
 * 
 * Thread.sleep(2000);
 * 
 * WebElement ccExpYear = driver.findElement(By.name("cc_exp_year"));
 * base.selectByVisibleText(ccExpYear, base.readExcel(1, 18));
 * 
 * Select select1=new Select(ccExpYear); select1.selectByIndex(15);
 * 
 * WebElement cvv = driver.findElement(By.id("cc_cvv"));
 * base.sendKeysByJava(cvv, base.readExcel(1, 19));
 * 
 * WebElement bookButton = driver.findElement(By.id("book_now"));
 * if(bookButton.isDisplayed()) { if(bookButton.isEnabled())
 * base.click(bookButton); }
 * 
 * Thread.sleep(6000);
 * 
 * WebElement orderId = driver.findElement(By.id("order_no")); String
 * orderIdInfo = orderId.getText(); System.out.println(orderIdInfo);
 * 
 * 
 * if(orderId.isDisplayed()) { base.UserWriteExcel(orderId, 4, 6,
 * "Booking Confirmed"); }
 * 
 * WebElement myItenary = driver.findElement(By.id("my_itinerary"));
 * if(myItenary.isDisplayed()) { if(myItenary.isEnabled()) {
 * base.click(myItenary); } } Thread.sleep(4000); WebElement bookedItenary =
 * driver.findElement(By.xpath("//td[text()='Booked Itinerary']")); if(
 * bookedItenary.isDisplayed()) {
 * System.out.println("User is in Booked Itenary Page"); }
 * 
 * WebElement cancelOrder =
 * driver.findElement(By.xpath("//input[@value='7L948PO6B4']")); WebElement
 * confirmCancel = driver.findElement(By.id("btn_id_1257479"));
 * if(cancelOrder.isDisplayed()) { if(cancelOrder.isEnabled()) {
 * base.click(cancelOrder); base.click(confirmCancel); } }
 * base.alertAccept(confirmCancel); Thread.sleep(3000);
 * 
 * base.UserWriteExcel(cancelOrder, 4, 8, "Order Cancelled"); WebElement
 * logoutButton = driver.findElement(By.id("logout"));
 * if(logoutButton.isDisplayed()) { if(logoutButton.isEnabled()) {
 * base.click(logoutButton); } } WebElement loggedOut = driver.findElement(By.
 * xpath("//td[text()='You have successfully logged out. ']"));
 * if(base.readExcel(1, 21).equals(base.getCurrentUrl())){
 * System.out.println("User Successfully Logged Off"); }
 * base.UserWriteExcel(loggedOut, 4, 10, "User SuccessFully Logged Off");
 * base.screenCapture();
 * 
 * base.UserWriteExcel(bookedItenary, 4, 7, "User is in Booked Itenary Page" );
 * if(orderId.isDisplayed()) { if(orderId.isEnabled()) { orderId.click(); } }
 * 
 * // // // To Switch to First Windows // base.windowsHandling(1); // // // To
 * get First WindowsID // String firstChildID = base.getWindowsID(1); //
 * base.switchWindows(firstChildID); // // or //
 * base.switchWindows(base.getWindowsID(1)); // // base.scroll(location,
 * "Down"); // // // base.scroll(location, "Up");
 */
