package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;


public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    By btnSignUp = By.xpath("//a[contains(text(),'ÜYE OL')]");
    By txtName = By.id("name");
    By txtLastName = By.id("lastName");
    By txtEmail = By.id("email");
    By txtPassword = By.id("password");
    By btnServiceContract = By.cssSelector(".serviceContractPopup");
    By btnModalYes = By.id("btnModalYesCallback");
    By btnCommunicationContract = By.cssSelector("label[for='communicationContract']");
    By btnExplicitConsentContract = By.cssSelector(".explicitConsentContractPopup");
    By btnSubmit = By.cssSelector(".btn-submit");
    By txtPassError = By.cssSelector("p#password-error");
    By txtEmailError = By.cssSelector("p#email-error");

    String HatalıEmail = "Hatalı email";
    String HatalıPassword = "Hatalı password";

    public SignUpPage signUpSuccess() {

        click(btnSignUp);
        writeText(txtName, 0, "testUser");
        writeText(txtLastName, 0, "testLastName");
        writeText(txtEmail, 0, "jajixov653@game4hr.com");
        writeText(txtPassword, 0, "123456Tt");
        click(btnServiceContract);
        click(btnModalYes);
        click(btnCommunicationContract);
        click(btnExplicitConsentContract);
        click(btnModalYes);
        click(btnSubmit);
        click(btnModalYes);
        return this;
    }

    public SignUpPage signUpAgain() {

        click(btnSignUp);
        writeText(txtName, 0, "testUser");
        writeText(txtLastName, 0, "testLastName");
        writeText(txtEmail, 0, "jajixov653@game4hr.com");
        writeText(txtPassword, 0, "123456Tt");
        click(btnServiceContract);
        click(btnModalYes);
        click(btnCommunicationContract);
        click(btnExplicitConsentContract);
        click(btnModalYes);
        click(btnSubmit);
        click(btnModalYes);
        try {
            if (readText(txtEmailError).equals(HatalıEmail));{System.out.print("Geçerli bir e-posta girmelisiniz");}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public SignUpPage signUpWrongPass () {

        click(btnSignUp);
        writeText(txtName, 0, "testUser");
        writeText(txtLastName, 0, "testLastName");
        writeText(txtEmail, 0, "nigama3864@iconzap.com");
        writeText(txtPassword, 0, "123456789"); //password kuralına aykırı
        click(btnServiceContract);
        click(btnModalYes);
        click(btnCommunicationContract);
        click(btnExplicitConsentContract);
        click(btnModalYes);
        try {
            if (readText(txtPassError).equals(HatalıPassword)) ;
            {
                System.out.print("Şifren 8-20 karakter arasında olmalıdır. Büyük harf, küçük harf ve rakam içermelidir.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
      }
    }

