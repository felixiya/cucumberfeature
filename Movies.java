package com.bookMyShow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excel.ExcelUtils;
import io.cucumber.core.cli.Main;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Movies {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	
	@Given("Launch the book My Show application")
	public void launch_the_book_my_show_application() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\pom.xml");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notifications");
		option.addArguments("disablr-popups");
		option.addArguments("--start-maximized");
         driver=new ChromeDriver(option);
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@Then("Validate the launched application")
	public void validate_the_launched_application() {
		String currenturl=driver.getCurrentUrl();
		if(currenturl.startsWith("https://in.bookmyshow.com/")){
			System.out.println("Application launched successfully");
		}else {
			System.out.println("Application Not launched successfully");
		}
			}
	@Given("User enters city and choose the city")
	public void user_enters_city_and_choose_the_city() {
		WebElement city=driver.findElement(By.xpath("//input[@placeholder='Search for your city']"));
		city.sendKeys("Chennai");
		WebElement chennai=driver.findElement(By.xpath("//strong[text()='Chennai']"));
		 wait.until(ExpectedConditions.visibilityOf(chennai));
		chennai.click();
	}

	@When("User clicks on Movies {String} {String}")
	public void user_clicks_on_movies(String string, String sheetname) throws IOException, InterruptedException {
		File f=new File("C:\\Users\\2RIN\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources\\Properties\\ExcelProperties");
		FileInputStream file = new FileInputStream(f); 
		Properties prop=new Properties();
		prop.load(file);
		String st=(String)prop.get(string);
		List<String>excel=ExcelUtils.excelread(st, sheetname);
		for(int i=0;i<excel.size();i++) {
			Thread.sleep(3000);
			String string2=excel.get(i);
			System.out.println(string2 );
	  WebElement Movies= driver.findElement(By.xpath("//a[text()='Movies']"));
	  wait.until(ExpectedConditions.visibilityOf(Movies)); 
	  Movies.click();
	}
	}
	
//	@Given("User click filters")
//	public void user_click_filters() {
//	   WebElement Filters=driver.findElement(By.xpath("//div[text()='Filters']"));
//	  // Filters.click();
//	   wait.until(ExpectedConditions.visibilityOf(Filters)); 
//	   Filters.click();
	//}
	@When("User Select the Tamil language")
	public void user_select_the_tamil_language() {
		WebElement Tamil= driver.findElement(By.xpath("(//div[@class='sc-1y4pbdw-6 iLzgbw'])[1]//following::div//div//div//div//div[text()='Tamil'][1]"));
		wait.until(ExpectedConditions.visibilityOf(Tamil));  
		Tamil.click();
		 //(//div[@class='sc-7o7nez-0 ehthfR'])[1] 
		////div[@class='sc-ije77g-0 jMRfhO']//parent::div//div//div//following-sibling::div//div[text()='Tamil']
	}
	@When("User click on Genres")
	public void user_click_on_genres() {
		WebElement genres=driver.findElement(By.xpath("//div[text()='Genres']"));
	    //WebElement genres=driver.findElement(By.xpath("//div[@class='sc-1y4pbdw-6 iLzgbw']//div[normalize-space(text())='Genres']"));
	    //wait.until(ExpectedConditions.visibilityOf(genres)); 
	    genres.clear();
		//(//div[@class='sc-1y4pbdw-6 iLzgbw']/following-sibling::div)[1]
	    //(//div[@class='sc-1y4pbdw-6 iLzgbw'])[2]
	}

	@When("User Selects the Drama Genres")
	public void user_selects_the_drama_genres() {
	   WebElement Drama=driver.findElement(By.xpath("//div[@class='sc-133848s-2 sc-1y4pbdw-11 bPeUKF']//following::div//div//div//div//div//div[text()='Drama']"));
	   wait.until(ExpectedConditions.visibilityOf(Drama)); 
	   Drama.click();
	}

	@When("User click on Format")
	public void user_click_on_format() {
		 WebElement Format=driver.findElement(By.xpath("//div[text()='Format']"));
		 
		 wait.until(ExpectedConditions.visibilityOf(Format)); 
		   Format.click();
	    
	}

	@When("User Select the 2D Format")
	public void user_select_the_2d_format() {
		 //WebElement d=driver.findElement(By.xpath("(//div[@class='style__FilterWrapper-sc-1y4pbdw-6 IHgid'])[3]//following::div//div[@class='sc-133848s-2 sc-1y4pbdw-12 hkAiCj'][1]"));
		WebElement d=driver.findElement(By.xpath("//div[text()='Format']//following::div//div//div//div//div[text()='2D']"));   
		wait.until(ExpectedConditions.visibilityOf(d)); 
		d.click();
	    
	   
	}

	@When("User Browse by Cinemas")
	public void user_browse_by_cinemas() {
		WebElement cinemas=driver.findElement(By.xpath("//div[@class='sc-b1h692-6 fQsxxj']//following::div//div[text()='Browse by Cinemas']"));
		wait.until(ExpectedConditions.visibilityOf(cinemas)); 
		cinemas.click();
	}

	@Then("User Validate the Displayed")
	public void user_validate_the_displayed() {
		//WebElement cinemas=driver.findElement(By.xpath("//div[@class='style__StyledText-sc-7o7nez-0 cTmWlX']"));
		  // cinemas.click();
		 // cinemas.isDisplayed();
	}
	@Given("User Select the English language")
	public void user_select_the_english_language() {
		WebElement Tamil= driver.findElement(By.xpath("(//div[@class='sc-1y4pbdw-6 iLzgbw'])[1]//following::div//div//div//div//div//div[text()='English'][1]"));
		wait.until(ExpectedConditions.visibilityOf(Tamil));  
		Tamil.click();
	}

	@Given("User Select the Malayalam language")
	public void user_select_the_malayalam_language() {
		WebElement Tamil= driver.findElement(By.xpath("(//div[@class='sc-1y4pbdw-6 iLzgbw'])[1]//following::div//div//div//div//div//div//div[text()='Malayalam'][1]"));
		wait.until(ExpectedConditions.visibilityOf(Tamil));  
		Tamil.click();
	}

	@Given("User Select the Telugu language")
	public void user_select_the_telugu_language() {
		WebElement Tamil= driver.findElement(By.xpath("(//div[@class='sc-1y4pbdw-6 iLzgbw'])[1]//following::div//div//div//div//div//div//div//div[text()='Telugu'][1]"));
		wait.until(ExpectedConditions.visibilityOf(Tamil));  
		Tamil.click();
	}

	@Given("User Select the Hindi language")
	public void user_select_the_hindi_language() {
		WebElement Tamil= driver.findElement(By.xpath("(//div[@class='sc-1y4pbdw-6 iLzgbw'])[1]//following::div//div//div//div//div//div//div//div//div[text()='Hindi'][1]"));
		wait.until(ExpectedConditions.visibilityOf(Tamil));  
		Tamil.click();
	}






}
