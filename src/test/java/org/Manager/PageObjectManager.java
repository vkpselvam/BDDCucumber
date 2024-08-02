package org.Manager;

import org.Page.BookHotelPage;
import org.Page.BookingConfirmationPage;
import org.Page.LoginPage;
import org.Page.LogoutPage;
import org.Page.MyItenaryPage;
import org.Page.SearchHotelPage;
import org.Page.SelectHotelPage;

public class PageObjectManager {
	
	private LoginPage loginPage;
	private SelectHotelPage selectHotelPage;
	private SearchHotelPage searchHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private MyItenaryPage myItenaryPage;
	private LogoutPage logoutPage;
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}
	
	public SearchHotelPage getSearchHotelPage() {
		return(searchHotelPage==null)? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}
	
	public BookHotelPage getBookHotelPage() {
		return(bookHotelPage==null)? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}
	
	public BookingConfirmationPage getBookingConfirmationPage() {
		return(bookingConfirmationPage==null)? bookingConfirmationPage = new BookingConfirmationPage() : bookingConfirmationPage;
	}
	
	public MyItenaryPage getmyItenaryPage() {
		return(myItenaryPage==null)? myItenaryPage = new MyItenaryPage() : myItenaryPage;
	}
	
	public LogoutPage getLogoutPage() {
		return(logoutPage==null)? logoutPage = new LogoutPage() : logoutPage;
	}
	
}
