import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

// Open Browser
// Open Browser
WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/Cura Pages/CuraPage MakeAppointmentValidation OR/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.setText(findTestObject('Object Repository/Cura Pages/CuraPage MakeAppointmentValidation OR/Page_CURA Healthcare Service/input_username'), 
    'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/Cura Pages/CuraPage MakeAppointmentValidation OR/Page_CURA Healthcare Service/input_password'), 
    'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Object Repository/Cura Pages/CuraPage MakeAppointmentValidation OR/Page_CURA Healthcare Service/button_Login'))

// Verify the presence of the dropdown
WebUI.verifyElementPresent(findTestObject('Dropdown/select_Tokyo CURA Healthcare Center                            Hongkong CURA Healthcare Center                            Seoul CURA Healthcare Center'), 
    10)

WebUI.delay(2 // Adjust the delay as needed
    )

// Verify the presence of the radio button
WebUI.verifyElementPresent(findTestObject('radiobutton/input_Medicaid_programs'), 10)

// Verify that the radio button is not checked
boolean isRadioButtonNotChecked = WebUI.verifyElementNotChecked(findTestObject('radiobutton/input_Medicaid_programs'), 10)

if (isRadioButtonNotChecked) {
    println('Radio button is not checked')

    // Check the radio button
    WebUI.check(findTestObject('radiobutton/input_Medicaid_programs'))

    println('Radio button checked')

    // Verify whether the radio button is checked or not
    boolean isRadioButtonChecked = WebUI.verifyElementChecked(findTestObject('radiobutton/input_Medicaid_programs'), 0)

    if (isRadioButtonChecked) {
        // If the radio button is checked, uncheck it
        WebUI.uncheck(findTestObject('radiobutton/input_Medicaid_programs'))
        println('Radio button was checked. Unchecking it.')
    } else {
        println('Radio button was not checked. No need to uncheck.')
    }
} else {
    println('Radio button is already checked. No need to check again.')
}

WebUI.closeBrowser()

