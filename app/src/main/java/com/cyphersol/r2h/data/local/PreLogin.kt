package com.cyphersol.r2h.data.local

data class PreLogin(
    val firstLogin: Boolean = false,
    val cnicVerified: Boolean = false,
    val cnicUploaded: Boolean = false,
    val networkAvailable: Boolean = false
)
