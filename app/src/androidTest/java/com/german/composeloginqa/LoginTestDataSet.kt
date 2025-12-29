package com.german.composeloginqa


object LoginTestDataset {

    val invalidCredentials = listOf(
        LoginTestData("wrong", "wrong", false),
        LoginTestData("admin", "wrong", false),
        LoginTestData("wrong", "1234", false),
        LoginTestData("", "", false)
    )

    val validCredentials = listOf(
        LoginTestData("admin", "1234", true)
    )
}