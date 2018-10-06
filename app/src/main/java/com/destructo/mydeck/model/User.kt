package com.destructo.mydeck.model

data class User(val name: String,
                val profilePicturePath: String?) {
    constructor(): this("", null)
}