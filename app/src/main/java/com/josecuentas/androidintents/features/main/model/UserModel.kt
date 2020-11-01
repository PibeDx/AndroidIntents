package com.josecuentas.androidintents.features.main.model

import java.io.Serializable

class UserModel(val userId: Int, val name: String): Serializable {
    companion object {
        const val BUNDLE = ".bundle_user_model"
    }
}