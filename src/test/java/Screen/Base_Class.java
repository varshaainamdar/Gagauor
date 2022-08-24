package Screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Centurian_Admission_Form_ObjectRepositaryUtility.Fetch_UserId_Pass;
import com.Centurian_Admission_Form_ObjectRepositaryUtility.Login_Page;
import com.Centurian_Admission_Form_ObjectRepositaryUtility.SignUp_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver sdriver;
	
	public WebDriver driver = null;
	//public WebDriver driver;
	/*Object Creation for Lib*/
	public WebDriverUtility wlib=new WebDriverUtility();
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public Excelutility elib=new Excelutility();


	@BeforeSuite
	public void configBS() {
		System.out.println("========================connect to DB========================");
	}



	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("======================Launch the Browser=====================");
		String RR= flib.getPropertyKeyValue("browser");
		WebDriverManager.chromedriver().setup();
		if (RR.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (RR.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Incorrect Browser");
		}		
		wlib.waitForElementInDOM(driver);	
		driver.manage().window().maximize();
		sdriver=driver;
	}



	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("===================Login to Application=======================");
		// read data from property file
		String UR = flib.getPropertyKeyValue("URL");
		// read Data from Excel Sheet 
		int intRanNum=jlib.getRanDomNumber();
		String Signupname=elib.getExcelData("Sign_up", 0, 1);
		String Signupdate=elib.getExcelData("Sign_up", 1, 1);
		String Signupemail=elib.getExcelData("Sign_up", 2, 1)+intRanNum+"@gmail.com";
		String Signupphoneno=elib.getExcelData("Sign_up", 3, 1);
		String Signupcode=elib.getExcelData("Sign_up", 4, 1);


		/* Navigate to app*/

		driver.get(UR);
		Login_Page log=new Login_Page(driver);
		log.clickSignup();
		//Step04 signup page fill the signup Details
		SignUp_Page log1=new SignUp_Page(driver);
		log1.SignUp(Signupname, Signupdate, Signupphoneno, Signupemail, Signupcode);

		//Step05Featch the user id and password 
		String Useridpassword =driver.findElement(By.xpath("//font[contains(text(),'Your User ID is')]")).getText();
		String userid =Useridpassword.substring(16,25);//user id
		String password =Useridpassword.substring(42,50);//password
		//Fetch the Data
		Fetch_UserId_Pass ioss=new Fetch_UserId_Pass(driver);
		ioss.loginToAppss();
		//Step06:login
		Login_Page log2=new Login_Page(driver);
		log2.loginToApp(userid, password);
	}

	@AfterClass
	public void configAC() {
		System.out.println("=======================Close the Browser=======================");
		driver.quit();
	}


	@AfterSuite public void configAS() {
		System.out.println("========================close DB===============================");
	}

}





