package eshop;

import framework.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TopBarPage;

public class SignOutTest extends TestBase {
    @Test
    public void signOut() {
        TopBarPage topBarPage = new TopBarPage(driver);
        Assert.assertTrue(topBarPage.isSignOutButtonVisible(3), "Sign out button is not visible");
        topBarPage.clickSignOutButton(0);

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(topBarPage.isSignOutButtonVisible(3), "Sign out button is not visible");
        softAssert.assertFalse(topBarPage.isMyAccountButtonVisible(5), "My account button is visible, but should not");
        softAssert.assertTrue(topBarPage.isSignInButtonVisible(0), "Sign in button is not visible");
        softAssert.assertAll();

    }

}
