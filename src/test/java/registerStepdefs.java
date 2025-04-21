import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;


public class registerStepdefs {

    WebDriver driver = new FirefoxDriver();

    //Öppnar upp webbsidan
    @Given("I have the website up")
    public void iHaveTheWebsiteUp() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

    }

    //Skriver in födelsedatum
    @When("I enter a valid birthdate")
    public void iEnterAValidBirthdate() {
        driver.findElement(By.id("dp")).sendKeys("04/03/2000");
    }

    //Skriver in namn
    @When("I enter a valid first name")
    public void iEnterAValidFirstName() {
        driver.findElement(By.id("member_firstname")).sendKeys("uj");
    }

    //Skriver in efternamn
    @When("I enter a valid last name")
    public void iEnterAValidLastName() {
        driver.findElement(By.id("member_lastname")).sendKeys("uj");
    }

    //Skriver in email
    @When("I enter a valid email address")
    public void iEnterAValidEmailAdress() {
        driver.findElement(By.id("member_emailaddress")).sendKeys("uj@mail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("uj@mail.com");
    }

    //Skriver in giltigt lösenord i båda fälten
    @When("I enter a valid password")
    public void iEnterAValidPassword() {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("password1");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("password1");
    }

    //Skriver in olika lösenord för scenario 3
    @When("I enter different passwords")
    public void iEnterDifferentPasswords() {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("password1");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("password2");


    }


    //Klickar i TaC
    @When("I click terms and conditions")
    public void iClickTermsAndConditions() {
        driver.findElement(By.id("signup_form")).click();
        driver.findElement(By.cssSelector("html body div.bg-met div.page-wrapper div.container div.portlet-body div.signUp-cont--center.row div.col-sm-12 div.portlet.light div.portlet-body.form div.form-body form#signup_form.login-form div.row div.col-xs-12 div.md-checkbox.margin-top-10 div.md-checkbox label span.box")).click();
    }

    //Klickar i CoE
    @When("I click the code of ethics box")
    public void iClickTheCodeOfEthicsBox() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    //Klickar i verifiering av ålder
    @When("I click I am eighteen years of age box")
    public void iClickIAmEighteenYearsOfAgeBox() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();

    }


    //Klickar på skapa account knappen
    @When("I click confirm and join")
    public void iClickConfirmAndJoin() {
        driver.findElement(By.name("join")).click();
    }


    //Skapar account funktionen för Scenario 1
    @Then("I registered a new account")
    public void iRegisteredANewAccount() throws InterruptedException {

        driver.findElement(By.name("join")).click();
        WebElement lockerButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/a"));
        String expected = "GO TO MY LOCKER";
        String actual = lockerButton.getText();
        assertEquals(expected, actual);
    }

    //Verifiering av glömt fylla i efternamn i Scenario 2
    @Then("I get result you forgot your last name")
    public void iGetResultYouForgotYourLastName() {
        WebElement lastNameReq = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span"));
        String actual = lastNameReq.getText();
        String expected = "Last Name is required";
        assertEquals(expected, actual);
    }


    //Verifiering av fel olika lösenord för Scenario 3
    @Then("I get result your passwords arent matching")
    public void iGetResultYourPasswordsArentMatching() {
        WebElement passwordWrong = driver.findElement(By.cssSelector("span.field-validation-error:nth-child(3) > span:nth-child(1)"));
        String actual = passwordWrong.getText();
        String expected = "Password did not match";
        assertEquals(expected, actual);
    }


    //Verifiering av glömt klicka i TaC i Scenario 4
    @Then("I get result you must agree to terms and conditions")
    public void iGetResultYouMustAgreeToTermsAndConditions() {
        WebElement youMust = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span/span"));
        String actual = youMust.getText();
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        assertEquals(expected, actual);
    }
}
