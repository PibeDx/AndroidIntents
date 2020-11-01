package com.josecuentas.androidintents.features.userdetail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.josecuentas.androidintents.R
import com.josecuentas.androidintents.features.main.model.UserModel

class UserDetailActivity : AppCompatActivity() {

    private lateinit var textCode: TextView
    private lateinit var textName: TextView

    private val user: UserModel by lazy { intent.extras?.getSerializable(UserModel.BUNDLE) as UserModel }

    companion object {
        fun getOpenIntent(context: Context, user: UserModel): Intent {
            return Intent(context, UserDetailActivity::class.java).apply {
                //flags = FLAG_ACTIVITY_NEW_TASK
                putExtra(UserModel.BUNDLE, user)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        textCode = findViewById(R.id.text_code)
        textName = findViewById(R.id.text_name)

        textCode.text = "Code: ${user.userId}"
        textName.text = "Name: ${user.name}"
    }

}