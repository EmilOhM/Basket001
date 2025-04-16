import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

import java.time.Duration;


public class registerStepdefs {

    WebDriver driver = new FirefoxDriver();

    @Given("I have the website up")
    public void iHaveTheWebsiteUp() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        // 2 | setWindowSize | 2560x1368 |  |
        driver.manage().window().setSize(new Dimension(2560, 1368));
        // 3 | type | id=dp | 04/03/2000 |

    }

    @When("I enter a valid birthdate")
    public void iEnterAValidBirthdate() {
        driver.findElement(By.id("dp")).sendKeys("04/03/2000");
        // 4 | type | id=member_firstname | uj |
    }
    @When("I enter a valid first name")
    public void iEnterAValidFirstName() {
        driver.findElement(By.id("member_firstname")).sendKeys("uj");
        // 5 | type | id=member_lastname | uj |
    }

    @When("I enter a valid last name")
    public void iEnterAValidLastName() {
        driver.findElement(By.id("member_lastname")).sendKeys("uj");
        // 6 | type | id=member_emailaddress | uj@mail.com |
    }

    @When("I enter a valid email address")
    public void iEnterAValidEmailAdress() {
        driver.findElement(By.id("member_emailaddress")).sendKeys("uj@mail.com");
        // 7 | type | id=member_confirmemailaddress | uj@mail.com |
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("uj@mail.com");
        // 8 | type | id=signupunlicenced_password | password |
    }

    @When("I enter a valid password")
    public void iEnterAValidPassword() {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("password1");
        // 9 | type | id=signupunlicenced_confirmpassword | password1 |
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("password1");
        // 10 | click | css=.row:nth-child(12) > .col-xs-12 |  |
    }
    @When("I enter different passwords")
    public void iEnterDifferentPasswords() {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("password1");
        // 9 | type | id=signupunlicenced_confirmpassword | password1 |
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("password2");
        // 10 | click | css=.row:nth-child(12) > .col-xs-12 |  |
    }




    @When("I click terms and conditions")
    public void iClickTermsAndConditions() {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]")).click();
        // 13 | click | css=.md-checkbox:nth-child(7) .box |  |
    }

    @When("I click the code of ethics box")
    public void iClickTheCodeOfEthicsBox() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }



    @When("I click confirm and join")
    public void iClickRegisterWithoutEnteringLastName() {
        driver.findElement(By.name("join")).click();
    }


    @Then("I registered a new account")
    public void iRegisteredANewAccount() throws InterruptedException {

        driver.findElement(By.name("join")).click();
        WebElement lockerButton= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/a"));
        String expected="GO TO MY LOCKER";
        String actual= lockerButton.getText();
        assertEquals(expected,actual);
    }


        @Then("I get result your passwords arent matching")
        public void iGetResultYouPasswordsArentMatching () {
            WebElement passwordWrong = driver.findElement(By.cssSelector("span.field-validation-error:nth-child(3) > span:nth-child(1)"));
            String actual = passwordWrong.getText();
            String expected = "Password did not match";
            assertEquals(expected, actual);
        }

        @Then("I get result you must agree to terms and conditions")
        public void iGetResultYouMustAgreeToTermsAndConditions () {
            WebElement youMust = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span/span"));
            String actual = youMust.getText();
            String expected = "You must confirm that you have read and accepted our Terms and Conditions";
            assertEquals(expected, actual);
        }



    @Then("I get result you forgot your last name")
    public void iGetResultYouForgotYourLastName() {
        WebElement lastNameReq = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span"));
        String actual = lastNameReq.getText();
        String expected = "Last Name is required";
        assertEquals(expected, actual);
    }







     /* @And("I enter my information")
    public void iEnterMyInformation() {
        driver.findElement(By.id("dp")).sendKeys("04/03/2000");
        // 4 | type | id=member_firstname | uj |
        driver.findElement(By.id("member_firstname")).sendKeys("uj");
        // 5 | type | id=member_lastname | uj |
        driver.findElement(By.id("member_lastname")).sendKeys("uj");
        // 6 | type | id=member_emailaddress | uj@mail.com |
        driver.findElement(By.id("member_emailaddress")).sendKeys("uj@mail.com");
        // 7 | type | id=member_confirmemailaddress | uj@mail.com |
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("uj@mail.com");
        // 8 | type | id=signupunlicenced_password | password |
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("password1");
        // 9 | type | id=signupunlicenced_confirmpassword | password1 |
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("password1");
        // 10 | click | css=.row:nth-child(12) > .col-xs-12 |  |
        driver.findElement(By.cssSelector(".row:nth-child(12) > .col-xs-12")).click();
        // 11 | click | css=.md-checkbox > .md-checkbox:nth-child(1) .box |  |
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
        // 12 | click | css=.md-checkbox:nth-child(2) > label > .box |  |
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
        // 13 | click | css=.md-checkbox:nth-child(7) .box |  |
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
        // 14 | click | name=join |  |

    }*/
}
