package com.training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	static ExtentReports report;
	static ExtentTest logger = null;
	
	public static void main(String[] args) throws InterruptedException{
		
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
		System.setProperty("webdriver.chrome.driver", "/Users/sakeerthi/Documents/chromedriver");
		WebDriver driver;
		driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://selenium-prd.firebaseapp.com");
		System.out.println("Application launched successfully");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		logger = report.startTest("Launch Application");
		logger.log(LogStatus.PASS, "Application started");
		
		WebElement email = driver.findElement(By.id("email_field"));
		email.clear();
		email.sendKeys("admin123@gmail.com");
		System.out.println("Username is entered");
		logger.log(LogStatus.PASS, "Username is entered");
		
		WebElement password = driver.findElement(By.id("password_field"));
		password.clear();
		password.sendKeys("admin123");
		System.out.println("Password is entered");
		logger.log(LogStatus.PASS, "Password is entered");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		loginButton.click();
		System.out.println("Login button is clicked Successfully");
		logger.log(LogStatus.PASS, "Login button is clicked Successfully");
		
		Thread.sleep(5000);
		
// ---------------------------------HOMETAB------------------------------------------------
		
		WebElement HomeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		HomeTab.click();
		System.out.println("HomeTab is clicked Successfully");
		logger.log(LogStatus.PASS, "Application started");
		
		//Enter the Student Registration Form
		
		WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
		Name.clear();
		Name.sendKeys("aaa");
		
		WebElement FatherName = driver.findElement(By.xpath("//input[@id='lname']"));
		FatherName.clear();
		FatherName.sendKeys("bbb");
		
		WebElement PostalAddress = driver.findElement(By.xpath("//input[@id='postaladdress']"));
		PostalAddress.clear();
		PostalAddress.sendKeys("600082");
		
		WebElement PersonalAddress = driver.findElement(By.xpath("//input[@id='personaladdress']"));
		PersonalAddress.clear();
		PersonalAddress.sendKeys("chennai");
		
		WebElement Sex = driver.findElement(By.xpath("//input[@value='female']"));
		Sex.click();
		
		//Select the city from dropdown
		Select City = new Select(driver.findElement(By.name("city")));
		City.selectByIndex(2);
		
		Select Course = new Select(driver.findElement(By.name("course")));
		Course.selectByVisibleText("MBA");
		
		Select District = new Select(driver.findElement(By.name("district")));
		District.selectByValue("goa");
		
		Select State = new Select(driver.findElement(By.name("state")));
		State.selectByIndex(1);
		
		WebElement Pincode = driver.findElement(By.id("pincode"));
		Pincode.clear();
		Pincode.sendKeys("94086");
		
		WebElement EmailId = driver.findElement(By.xpath("//input[@id='emailid']"));
		EmailId.clear();
		EmailId.sendKeys("abc@gmail.com");
		
		WebElement Submit = driver.findElement(By.xpath("//button[@class='bootbutton']"));
		Submit.click();
		System.out.println("The student form Registered Successfully");
		
	//--------------------------------------------------------------------------------------------
		
		// SwitchTo tabs
		WebElement SwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		SwitchTo.click();
		System.out.println("SwitchTo is clicked Successfully");
		logger.log(LogStatus.PASS, "SwitchTo is clicked Successfully");
		
		WebElement Alert = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		Alert.click();
		
		WebElement WindowAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		WindowAlert.click();
		Alert windowsAlert = driver.switchTo().alert();
		String alertText = windowsAlert.getText();
		System.out.println("Alert Text is " +alertText);
		Thread.sleep(5000);
		windowsAlert.accept();
		
		WebElement PromptAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
		PromptAlert.click();
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(5000);
		promptAlert.accept();
		System.out.println("Hello Harry Potter!How are you today?");
		//promptAlert.dismiss();
		//System.out.println("User cancelled the prompt ");
		
		
		
		Thread.sleep(5000);
		driver.quit();
		logger.log(LogStatus.PASS, "Exit from the Application");
		report.endTest(logger);
		report.flush();
		
	}

}
