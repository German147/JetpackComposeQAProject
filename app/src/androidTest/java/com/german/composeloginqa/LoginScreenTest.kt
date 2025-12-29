package com.german.composeloginqa

import androidx.compose.ui.test.junit4.createAndroidComposeRule

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pages.LoginScreenPage

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val screenshotRule = ScreenshotOnFailureRule(composeTestRule)

    private val loginPage by lazy{
        LoginScreenPage(composeTestRule)
    }


    @Test
    fun loginScreen_initialState() {
     loginPage.asserInitialState()
    }

    @Test
    fun login_withValidCredentials(){
        loginPage.loginAs("admin","1234")
        loginPage.assertWelcomeMessage()
    }

    @Test
    fun login_withValidCredentials_Fails(){
        loginPage.loginAs("adminsde","1234")
        loginPage.assertWelcomeMessage()
    }

    @Test
    fun invalidLogin(){
        loginPage.loginAs("german","barrera")
        loginPage.assertInvalidCredentialsError()
    }

}