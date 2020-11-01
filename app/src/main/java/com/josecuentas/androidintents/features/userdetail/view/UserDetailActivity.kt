package com.josecuentas.androidintents.features.userdetail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.josecuentas.androidintents.databinding.ActivityUserDetailBinding
import com.josecuentas.androidintents.features.main.model.UserModel

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

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
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textCode.text = "Code: ${user.userId}"
        binding.textName.text = "Name: ${user.name}"
    }

}