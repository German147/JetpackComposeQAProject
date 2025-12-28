package pages

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

class LoginScreenPage(override val rule: ComposeContentTestRule) : BasePage(rule) {
    //elements semantic
    private val usernameInput = rule.onNodeWithTag("username_input")
    private val passwordInput = rule.onNodeWithTag("password_input")
    private val loginButton = rule.onNodeWithTag("login_button")
    private val errorMessage = rule.onNodeWithTag("error_message")
    private val welcomeText = rule.onNodeWithTag("welcome_text")


    fun enterUserName(username: String) {
        usernameInput.performTextInput(username)
    }

    fun enterPassword(pass: String) {
        passwordInput.performTextInput(pass)
    }

    fun tapLogin() {
        loginButton.performClick()
    }

    fun loginAs(username: String, pass: String) {
        enterUserName(username)
        enterPassword(pass)
        tapLogin()

    }

    //assertions
    fun asserInitialState() {
        usernameInput.assertIsDisplayed()
        passwordInput.assertIsDisplayed()
        loginButton.assertIsDisplayed()
    }

    fun assertErrorIsShown() {
        waitForNodeWithTag("welcome_text")
        welcomeText.assertIsDisplayed()
    }

    fun assertWelcomeMessage() {
       waitForNodeWithTag("welcome_text")
        welcomeText.assertIsDisplayed()
    }

    fun assertInvalidCredentialsError() {
      waitForNodeWithTag("error_message")

        errorMessage
            .assertIsDisplayed()
            .assertTextContains("Invalid credentials")
    }

}