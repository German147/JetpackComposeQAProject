package pages

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

class LoginScreenPage(
    private val rule: ComposeContentTestRule
) {
    //elements semantic
    private val usernameInput = rule.onNodeWithTag("username_input")
    private val passwordInput = rule.onNodeWithTag("password_input")
    private val loginButton = rule.onNodeWithTag("login_button")
    private val errorMessage = rule.onNodeWithTag("error_message")
    private val welcomeText = rule.onNodeWithTag("welcome_text")


    fun enterUserName(username: String){
        usernameInput.performTextInput(username)
    }

    fun enterPassword(pass: String){
        passwordInput.performTextInput(pass)
    }

    fun tapLogin(){
        loginButton.performClick()
    }

    fun loginAs(username: String, pass: String){
        enterUserName(username)
        enterPassword(pass)
        tapLogin()

    }

    //assertions
    fun asserInitialState(){
        usernameInput.assertIsDisplayed()
        passwordInput.assertIsDisplayed()
        loginButton.assertIsDisplayed()
    }

    fun assertErrorIsShown() {
        rule.waitUntil(timeoutMillis = 3_000)
        {
            rule.onAllNodesWithTag("welcome_text").fetchSemanticsNodes().isNotEmpty()
        }
        welcomeText.assertIsDisplayed()
    }

    fun assertWelcomeMessage(){
        rule.waitUntil(timeoutMillis = 3_000){
            rule.onAllNodesWithTag("welcome_text").fetchSemanticsNodes().isNotEmpty()
        }
        welcomeText.assertIsDisplayed()
    }
    fun assertInvalidCredentialsError() {
        rule.waitUntil(timeoutMillis = 3_000) {
            rule.onAllNodesWithTag("error_message")
                .fetchSemanticsNodes().isNotEmpty()
        }

        errorMessage
            .assertIsDisplayed()
            .assertTextContains("Invalid credentials")
    }

}