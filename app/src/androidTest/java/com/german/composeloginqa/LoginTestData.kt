package com.german.composeloginqa

data class LoginTestData(
    val username: String,
    val password: String,
    val shouldSucceed: Boolean
)