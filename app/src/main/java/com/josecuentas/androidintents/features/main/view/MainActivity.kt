package com.josecuentas.androidintents.features.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josecuentas.androidintents.R
import com.josecuentas.androidintents.features.main.adapter.UserAdapter
import com.josecuentas.androidintents.features.main.model.UserModel
import com.josecuentas.androidintents.features.userdetail.view.UserDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerUser: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUi()
    }

    private fun setupUi() {
        injectView()
        setupAdapter()
        setupRecycler()
    }

    private fun injectView() {
        recyclerUser = findViewById(R.id.recycler_user)
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
        recyclerUser.layoutManager = LinearLayoutManager(baseContext)
        recyclerUser.adapter = userAdapter
    }

    private fun getDummyUsers(): List<UserModel> {
        return listOf(
            UserModel(1, "Yhonn"),
            UserModel(2, "Juan")
        )
    }

}