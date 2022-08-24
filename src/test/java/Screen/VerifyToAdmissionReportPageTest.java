package Screen;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Centurion_University_OR.AdmissionForm;
import com.Centurion_University_OR.SignupconfirmPage;
import com.Centurion_University_OR.UploadDocument;
import com.cu.genericutility.BaseClass;
import com.cu.genericutility.BaseClass1;
import com.cu.genericutility.BaseClass2;
import com.cu.genericutility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.cu.genericutility.ListenerImplementationClass.class)

public class VerifyToAdmissionReportPageTest extends BaseClass1 {
	@Test(priority = 1)
	public void VerifyToAdmissionReportPage1Test() throws Throwable {

		boolean flag;
		ExcelUtility excel = new ExcelUtility();

		String Ad_url = driver.getCurrentUrl();
		String expResult_ad = "admsnform.php";
		SoftAssert ass = new SoftAssert();
		/*Assert.assertTrue(Ad_url.contains(expResult_ad));*/
		Reporter.log("AdmissionFormPageTest is displayed", true);
		
		ass.assertEquals("a", "b");
		ass.assertAll();
		/**
		 * Fetch all the required values from
		 */
		String St_Mob = excel.getExcelData("sheet1", 0, 1);
		String F_name = excel.getExcelData("sheet1", 1, 1);
		String F_occ = excel.getExcelData("sheet1", 2, 1);
		String M_name = excel.getExcelData("sheet1", 3, 1);
		String M_occ = excel.getExcelData("sheet1", 4, 1);
		String Pa_income = excel.getExcelData("sheet1", 5, 1);
		String state = excel.getExcelData("sheet1", 7, 1);
		String Pin = excel.getExcelData("sheet1", 8, 1);
		String MOB_NO = excel.getExcelData("Sign_up", 3, 1);
		String Address = excel.getExcelData("sheet1", 10, 1);
		String Nationality = excel.getExcelData("sheet1", 11, 1);
		String Roll_no = excel.getExcelData("sheet1", 12, 1);
		String Religion = excel.getExcelData("sheet1", 13, 1);
		String Al_branch = excel.getExcelData("sheet1", 14, 1);
		String Rank = excel.getExcelData("sheet1", 15, 1);
		String Pcm = excel.getExcelData("sheet1", 16, 1);
		String T_UN = excel.getExcelData("sheet1", 17, 2);
		String T_year = excel.getExcelData("sheet1", 18, 2);
		String T_TM = excel.getExcelData("sheet1", 19, 2);
		String T_marks_Ob = excel.getExcelData("sheet1", 20, 2);
		String T_div = excel.getExcelData("sheet1", 21, 1);
		String T_Per_Marks = excel.getExcelData("sheet1", 22, 2);
		String P_UN = excel.getExcelData("sheet1", 23, 2);
		String P_year = excel.getExcelData("sheet1", 24, 2);
		String P_TM = excel.getExcelData("sheet1", 25, 2);
		String P_marks_Ob = excel.getExcelData("sheet1", 26, 2);
		String P_div = excel.getExcelData("sheet1", 27, 2);
		String P_Per_Marks = excel.getExcelData("sheet1", 28, 2);

		AdmissionForm adm = new AdmissionForm(driver);
		adm.EnterAllValiddetails(MOB_NO, MOB_NO, F_name, F_occ, M_name, M_occ, Pa_income, MOB_NO, MOB_NO, Address,
				state, Pin, MOB_NO, Address, state, Pin, MOB_NO, Nationality, Religion, Rank, Al_branch, Roll_no, Pcm,
				T_UN, T_year, T_TM, T_marks_Ob, T_div, T_Per_Marks, P_UN, P_year, P_TM, P_marks_Ob, P_div, P_Per_Marks);

		String Doc_url = driver.getCurrentUrl();
		String expResult_doc = "documents.php";
		Assert.assertTrue(Doc_url.contains(expResult_doc));
		Reporter.log("UploadDocumentPageTest is displayed", true);

		String photo = excel.getExcelData("sheet2", 0, 1);
		String T_marksC = excel.getExcelData("sheet2", 1, 1);
		String T_Cer = excel.getExcelData("sheet2", 2, 1);
		String P_marksC = excel.getExcelData("sheet2", 3, 1);
		String P_Cer = excel.getExcelData("sheet2", 4, 1);
		String Id_proof = excel.getExcelData("sheet2", 5, 1);
		
		String Signature = excel.getExcelData("sheet2", 6, 1);

		UploadDocument upl = new UploadDocument(driver);
		upl.UploadDocument(photo, T_marksC, T_Cer, P_marksC, P_Cer, Id_proof, Signature);

		String Ad_r_url = driver.getCurrentUrl();
		String expResult_Adr = "admsnreport.php";
		Assert.assertTrue(Ad_r_url.contains(expResult_Adr));
		Reporter.log("VerifyToAdmissionReportPageTest is pass", true);
	}
}