package eshop;

import framework.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AuthenticationPage;
import pages.TopBarPage;

public class SignInTest extends TestBase {
    @Test
    @Parameters({"email", "password"})
    public void successfulSignIn(String email, String password) {

        TopBarPage topBarPage = new TopBarPage(driver);
        //sprawdzamy czy button jest dostępny
        Assert.assertTrue(topBarPage.isSignInButtonVisible(5), "Sign in button is not visible");
        //topBarPage.isElementVisible(topBarPage.signInButton, 5);  wtedy polea w klasie TopBarPage i metody w PageBase musi byc public
        topBarPage.clickSignInButton(0);

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        //sprawdzamy czy pole jest dostepne miekką asercja
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(authenticationPage.isEmailInputVisible(3), "Email input is not visible");
        softAssert.assertTrue(authenticationPage.isPasswordInputVisible(0), "Password input is not visible");
        softAssert.assertTrue(authenticationPage.isSubmitLoginButtonVisible(0), "Submit button is not visible");
        softAssert.assertAll();

        //wprowadzamy dane i submitujemy
        authenticationPage.enterEmail(email);
        authenticationPage.enterPassword(password);
        authenticationPage.clickSubmitLoginButton(0);
        softAssert.assertAll();

        //sprawdzamy czy My account jest dostępny
        Assert.assertTrue(topBarPage.isMyAccountButtonVisible(5), "My Account is not visible");

    }


}
