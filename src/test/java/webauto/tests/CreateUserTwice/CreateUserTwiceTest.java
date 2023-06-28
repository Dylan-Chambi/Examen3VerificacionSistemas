package webauto.tests.CreateUserTwice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateUserTwiceTest extends TestBase{

    @Test
    public void verifyCreateUserTwice(){
        String fullname = "Dylan Chambi";
        String email = "dylan" + new Date().getTime() + "@gmail.com";
        String password = "dylan123";
        
        // create account
        mainPage.signUpButton.click();
        signUpContextMenu.fullnameTextBox.setText(fullname);
        signUpContextMenu.emailTextBox.setText(email);
        signUpContextMenu.passwordTextBox.setText(password);
        signUpContextMenu.agreeTermsCheckBox.click();
        signUpContextMenu.signUpButton.click();

        Assertions.assertTrue(homePage.logoutButton.isControlDisplayed(), "ERROR: account was not created");
        
        // logout
        homePage.logoutButton.click();
        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed(), "ERROR: logout failed");
        
        // create account again
        mainPage.signUpButton.click();
        signUpContextMenu.fullnameTextBox.setText(fullname);
        signUpContextMenu.emailTextBox.setText(email);
        signUpContextMenu.passwordTextBox.setText(password);
        signUpContextMenu.agreeTermsCheckBox.click();
        signUpContextMenu.signUpButton.click();
        Assertions.assertEquals("Account with this email address already exists!", mainPage.errorMessage.getTextValue(), "ERROR: email already exists message was not displayed");
        
    }
}
