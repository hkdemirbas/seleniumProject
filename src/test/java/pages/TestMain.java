package pages;

import org.junit.Before;
import org.junit.Test;
import util.Driver;

public class TestMain extends Driver {
    SignUpPage signUp;

    @Before
    public void before() {
        signUp = new SignUpPage(driver);
    }

    @Test
    public void test(){
        signUp.signUpSuccess();
        driver.close();
        signUp.signUpAgain();
        driver.close();
        signUp.signUpWrongPass();
        driver.close();
    }

}
