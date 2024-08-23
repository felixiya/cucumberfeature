package com.bookMyShow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import excel.ExcelUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	@Given("Launch the facebook application {string}")
	public void launch_the_facebook_application(String url) throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\pom.xml");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notifications");
		option.addArguments("disablr-popups");
		option.addArguments("--start-maximized");
         driver=new ChromeDriver(option);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	    }
		
		/*@Given("Launch the facebook application")
	public void launch_the_facebook_application() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\pom.xml");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notifications");
		option.addArguments("disablr-popups");
		option.addArguments("--start-maximized");
         driver=new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	}*/
	@Then("Validate the launched facebook application {string}")
	public void validate_the_launched_facebook_application(String url) {
		String currenturl=driver.getCurrentUrl();
		if(currenturl.startsWith(url)){
			System.out.println("Application launched successfully");
		}else {
			System.out.println("Application Not launched successfully");
		}
	    
	}

	/*@Then("Validate the launched facebook application")
	public void validate_the_launched_facebook_application() {
		String currenturl=driver.getCurrentUrl();
		if(currenturl.startsWith("https://www.facebook.com/")){
			System.out.println("Application launched successfully");
		}else {
			System.out.println("Application Not launched successfully");
		}
	}*/
	

	@Given("User click on create new accounts")
	public void user_click_on_create_new_account()  {
	
		WebElement create=driver.findElement(By.xpath("//a[text()='Create new account']"));
	    create.click();
	}

	/*@Given("User send the Firstname")
	public void user_send_the_firstname()  {
		 WebElement name=driver.findElement(By.name("firstname"));
		 //WebElement name=driver.findElement(By.xpath("//div[text()='Sign Up']//following::div//div//div//div//div//div//div//div[@class='mbm _1iy_ _a4y _3-90 lfloat _ohe']"));
		    name.sendKeys("felixiya");
		   /* TakesScreenshot ts =(TakesScreenshot)driver;
		    File sh =ts.getScreenshotAs(OutputType.FILE);
		    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\name.png");
		    FileUtils.copyFile(sh,f);}*/
	
	@Given("User send the Firstname one dim list")
	public void user_send_the_firstname_one_din_list(DataTable dataTable) {
		List<String> list=dataTable.asList();
		String inputvalue =list.get(1);
		WebElement name=driver.findElement(By.name("firstname"));
		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(inputvalue);
		
	}
	/*@Given("User send the Surname")
	public void user_send_the_surname()  {
		WebElement surname=driver.findElement(By.name("lastname"));
		//WebElement surname=driver.findElement(By.xpath("//div[text()='Sign Up']//following::div//div//div//div//div//div//div//div//div//div//div[text()='Surname']"));
	    surname.sendKeys("joseph");
	   /* TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\surname.png");
	    FileUtils.copyFile(sh,f);}*/
	
	@Given("User send the Surname one dim map")
	public void user_send_the_surname_one_dim_map(DataTable dataTable) {
		
		Map<String,String> map=dataTable.asMap(String.class,String.class);
		String inputvalue=map.get("name");
		WebElement surname=driver.findElement(By.name("lastname"));
		wait.until(ExpectedConditions.visibilityOf(surname));
		surname.sendKeys(inputvalue);
		
	}
	/*@Given("User send the Mobilenumber or email address")
	public void user_send_the_mobilenumber_or_email_address() {
		WebElement email=driver.findElement(By.name("reg_email__"));
		//WebElement email=driver.findElement(By.xpath("//div[normalize-space(text())='Mobile number or email address']"));
	    email.sendKeys("felix@gmail.com");
	   /* TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\surname.png");
	    FileUtils.copyFile(sh,f);}*/
	@Given("User send the Mobilenumber or email address {string}")
	public  void user_send_the_mobilenumber_or_email_address(String string) {
		
		WebElement email=driver.findElement(By.name("reg_email__"));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(string);
	   
	}
	/*@Given("User send new password")
	public void user_send_new_password() throws IOException {
		WebElement password=driver.findElement(By.name("reg_passwd__"));
		//WebElement password=driver.findElement(By.xpath("//input[@data-type='password']"));
		/*password.sendKeys("fel123");
		TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\password.png");
	    FileUtils.copyFile(sh,f);}*/
	@Given("User send new password {string}")
	public void user_send_new_password(String word) throws IOException {
		WebElement password=driver.findElement(By.name("reg_passwd__"));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(word);
		//password.sendKeys("fel123");
		TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\password.png");
	    FileUtils.copyFile(sh,f);
	    
	}
	    
	

	/*@Given("User Select the Date of birth")
	public void user_select_the_date_of_birth() throws IOException {
		WebElement date=driver.findElement(By.name("birthday_day"));
		Select s =new Select(date);
		s.selectByIndex(6);
		WebElement month=driver.findElement(By.name("birthday_month"));
		Select ss =new Select(month);
		ss.selectByIndex(9);
		WebElement year=driver.findElement(By.name("birthday_year"));
		Select sss =new Select(year);
		sss.selectByIndex(20);
		
		/*TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\dateofbirth.png");
	    FileUtils.copyFile(sh,f);}
	    */
	@Given("User Select the Date of birth {string} {string} {string}")
	public void user_select_the_date_of_birth(String a, String b, String c) throws IOException {
		WebElement date=driver.findElement(By.name("birthday_day"));
		int data =Integer.parseInt(a);
		Select s =new Select(date);
		s.selectByVisibleText(a);
		
		WebElement month=driver.findElement(By.name("birthday_month"));
		Select ss =new Select(month);
		ss.selectByVisibleText(b);
		
		WebElement Year=driver.findElement(By.name("birthday_year"));
		long Year1 =Integer.parseInt(c);
		Select sss = new Select(Year);
		sss.selectByVisibleText(c);
		
		TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\dateofbirth.png");
	    FileUtils.copyFile(sh,f);
	   
	}
	

	@Given("User Select the Gender")
	public void user_select_the_gender() throws IOException  {
		WebElement gender=driver.findElement(By.xpath("//span[@class='_5k_3']//span//label[text()='Female']"));
		//WebElement gender=driver.findElement(By.xpath("(//span[@class='_5k_3']//span//label[@class='_58mt'])[1]"));
        gender.click();
        TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\gender.png");
	    FileUtils.copyFile(sh,f);
		
	}
	
	/*@Given("User Select the Gender {string}")
	public void user_select_the_gender(String gen) throws IOException {
		WebElement gender=driver.findElement(By.xpath("//span[@class='_5k_3']//span//label[text()='Female']"));
		//WebElement gender=driver.findElement(By.xpath("(//span[@class='_5k_3']//span//label[@class='_58mt'])[1]"));
		gender.click();
		
        TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\gender.png");
	    FileUtils.copyFile(sh,f);
	    }*/

	@Given("User click onSing Up button")
	public void user_click_on_sing_up_button() throws IOException  {
		WebElement submit=driver.findElement(By.name("websubmit"));
		submit.click();
		TakesScreenshot ts =(TakesScreenshot)driver;
	    File sh =ts.getScreenshotAs(OutputType.FILE);
	    File f =new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\target\\screenshot\\button.png");
	    FileUtils.copyFile(sh,f);
	}
	
	
	
	
	
	
	
	}
	


	

	



	
	