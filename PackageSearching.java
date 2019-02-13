package Frontend;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Library.Utility;

public class PackageSearching {
	WebDriver driver;
@Test
	
	public void packageSearchBooking() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
         
        driver = new ChromeDriver();
        //Navigate to dreamtrip site
        driver.get("https://test25.qa.dreamtrips.com/");
        driver.manage().window().maximize();
        //Member Login
        String BeforeLogin=driver.findElement(By.xpath("//*[@id='div_homeDetails']/div[1]/section/div[1]/h3")).getText();
        boolean BeforLogin=driver.findElement(By.xpath("//*[@id='div_homeDetails']/div[1]/section/div[1]/h3")).getText() != null;
        if(BeforLogin){
        	System.out.println("Before Login "+BeforeLogin + " is displaying");
        }
        else{
        System.out.println("Before Login " + BeforeLogin + " is not displaying");
        }
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(".//a[@data-test-id='header-mobile-member-link']")).click();
        driver.findElement(By.id("popupusernameheader")).sendKeys("67467564");
        driver.findElement(By.id("popuppasswordheader")).sendKeys("67467564Test1!");
        driver.findElement(By.id("p_lt_ctl00_DTLogonForm_Login1_LoginButton_Header")).click();
        String Expected=driver.findElement(By.xpath(".//h4[contains(.,'DreamTrips')]")).getText();
        Assert.assertEquals("DREAMTRIPS", Expected);
        // searching Package
        Thread.sleep(5000);
        boolean AfterLogin=driver.findElement(By.xpath("//*[@id='div_homeDetails']/div[1]/section/div[1]")).getText() != null;
        if(AfterLogin){
        	System.out.println("After Login "+BeforeLogin + " is not displaying");
        }
        else{
        System.out.println("After Login " + BeforeLogin + " is  displaying");
        }
        Thread.sleep(2000);
        driver.findElement(By.id("cookie-close-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//input[@id='KeywordTextBox']")).sendKeys("BlueOcean");
        Thread.sleep(3000);
        Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
		//WebElement DetailsIconLink = driver.findElement(By.xpath(".//a[contains(.,'Details')]"));
		//Actions action = new Actions(driver);
		//action.moveToElement(DetailsIconLink).click().click().build().perform();
		//DetailsIconLink.click();
		//driver.findElement(By.xpath("//*[@id='divProductView']/div/div/a[2]")).click();
		//driver.findElement(By.xpath(".//a[contains(.,'Details')]")).click();
		
		try {
		    WebElement button = driver.findElement(By.xpath("//*[@id='divProductView']/div/div/a[2]"));
		            button.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
		    WebElement button = driver.findElement(By.xpath("//*[@id='divProductView']/div/div/a[2]"));
		            button.click();
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//div[@id='bookit']//div//a")).click();
        Thread.sleep(5000);
        WebElement ReserveBtn=driver.findElement(By.xpath(".//tbody/tr[2]/td/div"));
        if(ReserveBtn.isDisplayed()){
        	ReserveBtn.click();
        }
        //driver.findElement(By.xpath(".//tbody/tr[2]/td/div")).click();
        Thread.sleep(3000);
        WebElement TwoRoomSelect=driver.findElement(By.xpath(".//select[@id='RoomSearchOptionDropDown']"));
        Select  twoRoomsSel=new Select(TwoRoomSelect);
        twoRoomsSel.selectByValue("2");
        Thread.sleep(3000);
        WebElement NoRoomSel=driver.findElement(By.xpath(".//select[@id='NoOfRoomsDropDownList']"));
        Select TwoRooms=new Select(NoRoomSel);
        TwoRooms.selectByValue("2");
        Thread.sleep(3000);
        WebElement Room1=driver.findElement(By.xpath(".//select[@id='NoOfAdultsDropDownList1']"));
        Select  Room1AdultSel=new Select(Room1);
        Room1AdultSel.selectByValue("1");
        Thread.sleep(3000);
        WebElement Room2=driver.findElement(By.xpath(".//select[@id='NoOfAdultsDropDownList2']"));
        Select  Room2AdultSel=new Select(Room2);
        Room2AdultSel.selectByValue("1");
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(".//a[@id='PackageCheckAvailability']")).click();
        Thread.sleep(8000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        System.out.println("Window is vertically scrolled by 800 pixels");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath(".//a[@id='btncontinueprimary']")).click();
        Thread.sleep(15000);
        //Room 1
        System.out.println(driver.getCurrentUrl());
        WebElement room1Lastname= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[2]/div[2]/div[1]/div/div[@class='col-sm-3 col-md-3']/label[contains(.,'Surname/Last Name')]/../div/input"));
        room1Lastname.click();
        room1Lastname.clear();
        room1Lastname.sendKeys("Nikhil");
        WebElement room1Firstname= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[2]/div[2]/div[1]/div/div[@class='col-sm-4 col-md-3']/label[contains(.,'Given/First Name')]/../div/input"));
        room1Firstname.click();
        room1Firstname.clear();
        room1Firstname.sendKeys("Reddy C");
        WebElement room1Email= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']/div[5]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Email Address:')]/../../../div[@class='col-sm-4  col-xs-12']/div/input"));
        room1Email.click();
        room1Email.clear();
        room1Email.sendKeys("testdrive.adm@gmail.com");
      //Selecting DOB
        Thread.sleep(5000);
        WebElement room1monthSelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']/div[3]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Date of Birth:')]/../../../div[@class='col-sm-9 col-md-10 col-xs-12']/div/label[contains(.,'mm')]/../div/span/select"));
        Select room1mmselect=new Select(room1monthSelect);
        room1mmselect.selectByVisibleText("08");
        
        WebElement room1daySelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']/div[3]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Date of Birth:')]/../../../div[@class='col-sm-9 col-md-10 col-xs-12']/div/label[contains(.,'dd')]/../div/span/select"));
        Select room1ddselect=new Select(room1daySelect);
        room1ddselect.selectByVisibleText("31");
        
        WebElement room1yearSelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']/div[3]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Date of Birth:')]/../../../div[@class='col-sm-9 col-md-10 col-xs-12']/div/label[contains(.,'yyyy')]/../div/span/select"));
        Select room1yyyyselect=new Select(room1yearSelect);
        room1yyyyselect.selectByVisibleText("1999");
        
       //Gender
        WebElement room1Female= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']//div[4]/div[@class='col-sm-12 col-xs-12']/div//div[2]/div/label[2][contains(.,'Female')]"));
        room1Female.click();
        //PhoneType
        WebElement room1phoneSelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']//div[6]//div[@class='col-sm-12  col-xs-12']/div/div/div/label[contains(.,'Phone Number:')]/../../../div[@class='col-sm-4 col-md-3 col-xs-12']/div/span/select "));
        Select room1mobileselect=new Select(room1phoneSelect);
        room1mobileselect.selectByVisibleText("Mobile");
        
        WebElement enterMobileNo=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 1')]/../../../../div[@class='wv-roominn']//div[6]//div[@class='col-sm-12  col-xs-12']/div/div/div/label[contains(.,'Phone Number:')]/../../../div[@class='col-sm-5 col-md-4 col-xs-12']/div/input"));
        enterMobileNo.sendKeys("1234567890");
        //Room 2
        js.executeScript("window.scrollBy(0,1000)");
        System.out.println("Window is vertically scrolled by 1000 pixels");
        WebElement room2Lastname= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 2')]/../../../../div[2]/div[2]/div[1]/div/div[@class='col-sm-3 col-md-3']/label[contains(.,'Surname/Last Name')]/../div/input"));
        room2Lastname.sendKeys("Akhil");
        WebElement room2Firstname= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 2')]/../../../../div[2]/div[2]/div[1]/div/div[@class='col-sm-4 col-md-3']/label[contains(.,'Given/First Name')]/../div/input"));
        room2Firstname.sendKeys("Reddy C");
        WebElement room2Email= driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 2')]/../../../../div[@class='wv-roominn']/div[5]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Email Address:')]/../../../div[@class='col-sm-4  col-xs-12']/div/input"));
        room2Email.sendKeys("testdrive.adm@gmail.com");
      //Selecting DOB
        Thread.sleep(5000);
        WebElement room2monthSelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 2')]/../../../../div[@class='wv-roominn']/div[3]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Date of Birth:')]/../../../div[@class='col-sm-9 col-md-10 col-xs-12']/div/label[contains(.,'mm')]/../div/span/select"));
        Select room2mmselect=new Select(room2monthSelect);
        room2mmselect.selectByVisibleText("12");
        
        WebElement room2daySelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 2')]/../../../../div[@class='wv-roominn']/div[3]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Date of Birth:')]/../../../div[@class='col-sm-9 col-md-10 col-xs-12']/div/label[contains(.,'dd')]/../div/span/select"));
        Select room2ddselect=new Select(room2daySelect);
        room2ddselect.selectByVisibleText("21");
        
        WebElement room2yearSelect=driver.findElement(By.xpath(".//div[@class='wv-roomwcont']/div[1]/div/div/h4[contains(.,'Room 2')]/../../../../div[@class='wv-roominn']/div[3]//div/div[@class='col-sm-3 col-md-2 col-xs-12 ']/div/label[contains(.,'Date of Birth:')]/../../../div[@class='col-sm-9 col-md-10 col-xs-12']/div/label[contains(.,'yyyy')]/../div/span/select"));
        Select room2yyyyselect=new Select(room2yearSelect);
        room2yyyyselect.selectByVisibleText("1997");
        
      //Credit card credentials
        driver.findElement(By.xpath(".//input[@id='CCHolderNameTextBox']")).sendKeys("CNIKHIL");
        driver.findElement(By.xpath(".//input[@id='CCNumberTextBox']")).click();
        driver.findElement(By.xpath(".//input[@id='CCNumberTextBox']")).sendKeys("4111111111111111");
        driver.findElement(By.xpath(".//input[@id='CVVNumberTextBox']")).click();
        driver.findElement(By.xpath(".//input[@id='CVVNumberTextBox']")).sendKeys("123");
        WebElement monthCardSelect=driver.findElement(By.xpath(".//select[@id='ExpirationMonthDropDown']"));
        Select MMCardselect=new Select(monthCardSelect);
        MMCardselect.selectByVisibleText("12");
        WebElement yearCardSelect=driver.findElement(By.xpath(".//select[@id='ExpirationYearDropDown']"));
        Select YYCardselect=new Select(yearCardSelect);
        YYCardselect.selectByVisibleText("2018");
        //Billing Address
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//input[@id='BillingAddress1TextBox']")).click();
        driver.findElement(By.xpath(".//input[@id='BillingAddress1TextBox']")).clear();
        driver.findElement(By.xpath(".//input[@id='BillingAddress1TextBox']")).sendKeys("GlobalCity");
        driver.findElement(By.xpath(".//input[@id='BillingCityTextBox']")).click();
        driver.findElement(By.xpath(".//input[@id='BillingCityTextBox']")).clear();
        driver.findElement(By.xpath(".//input[@id='BillingCityTextBox']")).sendKeys("Plano");
        driver.findElement(By.xpath(".//input[@id='BillingStateTextBox']")).click();
        driver.findElement(By.xpath(".//input[@id='BillingStateTextBox']")).clear();
        driver.findElement(By.xpath(".//input[@id='BillingStateTextBox']")).sendKeys("Texas");
        driver.findElement(By.xpath(".//input[@id='BillingZipTextBox']")).click();
        driver.findElement(By.xpath(".//input[@id='BillingZipTextBox']")).clear();
        driver.findElement(By.xpath(".//input[@id='BillingZipTextBox']")).sendKeys("450102");
        js.executeScript("window.scrollBy(0,800)");
        System.out.println("Window is vertically scrolled by 800 pixels");
        driver.findElement(By.xpath(".//input[@id='chktermscondition1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//button[@id='Submit1']")).click();
        Thread.sleep(5000);
        //Verifying the Booking
        WebElement BookingConfirm=driver.findElement(By.xpath("//div[@class='wv-note'][contains(.,'Booking Confirmation number is')]"));
        String BookingConfirmText=driver.findElement(By.xpath("//div[@class='wv-note'][contains(.,'Booking Confirmation number is')]")).getText();
        String orderconfirm=driver.findElement(By.xpath("//div[@class='wv-note']/span")).getText();
        //Assert.assertEquals("Order Confirmation", orderconfirm);
        if(BookingConfirm.isDisplayed()){
        	 //Assert.assertEquals("Booking Confirmation number is", BookingConfirmText);
        	 System.out.println("Booking order number is "+orderconfirm);
             System.out.println(driver.getCurrentUrl());
             Thread.sleep(3000);
             driver.quit();
        }
        else{
        System.out.println("Booking Order is failed");
        System.out.println(orderconfirm);
        System.out.println(driver.getCurrentUrl());
        }
	}
	@AfterMethod
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
		
		Utility.captureScreenshot(driver, result.getName());
		}
	//driver.quit();
	}
}
