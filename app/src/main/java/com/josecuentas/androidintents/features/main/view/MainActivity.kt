package com.josecuentas.androidintents.features.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.josecuentas.androidintents.databinding.ActivityMainBinding
import com.josecuentas.androidintents.features.main.adapter.UserAdapter
import com.josecuentas.androidintents.features.main.model.UserModel
import com.josecuentas.androidintents.features.userdetail.view.UserDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
    }

    private fun setupUi() {
        setupAdapter()
        setupRecycler()
    }

    private fun setupAdapter() {
        userAdapter = UserAdapter(
            onClick = { user ->
                /*val intent = Intent(baseContext, UserDetailActivity::class.java).apply {
                    putExtra(UserModel.BUNDLE, user)
                }
                startActivity(intent)*/
                startActivity(UserDetailActivity.getOpenIntent(baseContext, user))
            }
        )
        userAdapter.users = getDummyUsers()
    }

    private fun setupRecycler() {
        binding.recyclerUser.layoutManager = LinearLayoutManager(baseContext)
        binding.recyclerUser.adapter = userAdapter
    }

    private fun getDummyUsers(): List<UserModel> {
        return listOf(
            UserModel(1, "Yhonn"),
            UserModel(2, "Juan")
        )
    }

}