package com.josecuentas.androidintents.features.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josecuentas.androidintents.R
import com.josecuentas.androidintents.features.main.model.UserModel

class UserAdapter(private val onClick: (UserModel) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var users: List<UserModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder) { bind(users[position]) }
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    inner class UserViewHolder(val root: View) : RecyclerView.ViewHolder(root) {

        lateinit var textName : TextView

        fun bind(user: UserModel) {
            textName = root.findViewById(R.id.text_name)

            textName.text = user.name

            root.setOnClickListener {
                onClick(user)
            }
        }
    }
}