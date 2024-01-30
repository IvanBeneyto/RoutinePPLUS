package com.pmdm.routinepplus.screens

private val StudentCredentials = mapOf(
    "admin" to "admin123"
)

fun isValidCredentialsStudent(username: String, password: String): Boolean {
    return StudentCredentials[username] == password
}