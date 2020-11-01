package com.josecuentas.androidintents.features.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josecuentas.androidintents.databinding.RowUserBinding
import com.josecuentas.androidintents.features.main.model.UserModel

class UserAdapter(private val onClick: (UserModel) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var users: List<UserModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder) { bind(users[position]) }
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    inner class UserViewHolder(val binding: RowUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserModel) {
            binding.textName.text = user.name

            binding.root.setOnClickListener {
                onClick(user)
            }
        }
    }
}