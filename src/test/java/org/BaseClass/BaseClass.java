package org.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static JavascriptExecutor javascriptExecutor;
	public static File file;
	public static Workbook book;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("InValid Browser Type");
			break;
		}
	}

	public void windowMax() {
		driver.manage().window().maximize();
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void sendKeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void sendKeysByJS(WebElement element, String keysToSend) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);

	}

	public void clickByJS(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);
	}

	public void scroll(WebElement element, String scrollType) {
		javascriptExecutor = (JavascriptExecutor) driver;
		switch (scrollType) {
		case "Down":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
			break;
		case "Up":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		default:
			System.out.println("InValid Scroll Type");
			break;
		}
	}

	public Object getAttributeByJS(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		Object executeScript = javascriptExecutor.executeScript("return arguments[0].getAttribute('value')", element);
		return executeScript;
	}

	public String getAttributeByJava(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void alertAccept(WebElement element) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertCancel(WebElement element) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void screenCapture() {

		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("C:\\Users\\MyPc\\eclipse-workspace\\TestNGFramework\\Screenshots"
					+ System.currentTimeMillis() + ".png");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {

		}
	}

	public void windowsHandling(int windows) {

		// To Find CurrentWindowsID / ParentWindows ID
		String parentWindowsID = driver.getWindowHandle();

		// To Find All Windows ID
		Set<String> allWindowsID = driver.getWindowHandles();

		// To Create New Empty List
		List<String> list = new LinkedList<String>();
		// To add all the values from Set to List ( All Windows Id Added to Newly
		// Created List)
		list.addAll(allWindowsID);

		// to get Particular value Based on Index
		String childWindowsID = list.get(windows);

		// To Switch to Windows based Requirement
		driver.switchTo().window(childWindowsID);

	}

	public String getWindowsID(int windows) {

		// To Find CurrentWindowsID / ParentWindows ID
		String parentWindowsID = driver.getWindowHandle();

		// To Find All Windows ID
		Set<String> allWindowsID = driver.getWindowHandles();

		// To Create New Empty List
		List<String> list = new LinkedList<String>();
		// To add all the values from Set to List ( All Windows Id Added to Newly
		// Created List)
		list.addAll(allWindowsID);

		// to get Particular value Based on Index
		String childWindowsID = list.get(windows);

		return childWindowsID;

	}

	public void switchWindows(String windowsID) {
		driver.switchTo().window(windowsID);
	}

	public void page(String page) throws AWTException {

		Robot robot = new Robot();
		switch (page) {
		case "Up":
			robot.keyPress(KeyEvent.VK_KP_UP);
			break;
		case "Down":
			robot.keyPress(KeyEvent.VK_KP_DOWN);
			break;
		case "Left":
			robot.keyPress(KeyEvent.VK_KP_LEFT);
			break;
		case "Right":
			robot.keyPress(KeyEvent.VK_KP_RIGHT);
			break;

		default:
			System.out.println("InValid Page Function");
			break;
		}
	}

	public String readExcel(int rownum, int cellnum) {

		String value = null;

		try {

			// To Locate Where File
			file = new File("C:\\Users\\MyPc\\eclipse-workspace\\TestNGFramework\\DataBase\\Logins.xlsx");

			FileInputStream inputStream = new FileInputStream(file);

			book = new XSSFWorkbook(inputStream);

			sheet = book.getSheet("Sheet1");

			row = sheet.getRow(rownum);

			cell = row.getCell(cellnum);

			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();

				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					value = simpleDateFormat.format(dateCellValue);

				} else {

					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					value = valueOf.toString();

				}
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return value;

	}

	public void writeExcel(WebElement element, int rownum, int columnNum) throws IOException {

		cell = sheet.createRow(rownum).createCell(columnNum);

		if (element.isDisplayed()) {
			cell.setCellValue("PASS");
		} else {
			cell.setCellValue("FAILL");
		}

		FileOutputStream outputStream = new FileOutputStream(file);

		book.write(outputStream);

	}

	public void UserWriteExcel(WebElement element, int rownum, int columnNum, String value) throws IOException {

		// cell = sheet.createRow(rownum).createCell(columnNum);
		cell = sheet.getRow(rownum).createCell(columnNum);
		if (element.isDisplayed()) {

			cell.setCellValue(value);
		}

		FileOutputStream outputStream = new FileOutputStream(file);

		book.write(outputStream);
	}

}
