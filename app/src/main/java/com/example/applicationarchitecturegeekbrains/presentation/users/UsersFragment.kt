package com.example.applicationarchitecturegeekbrains.presentation.users

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.App.Navigator.router
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.presentation.users.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.UserClickListener {
    private lateinit var userList: RecyclerView
    private lateinit var userAdapter: UsersAdapter

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepository(),
            router = router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userAdapter = UsersAdapter(this)
        userList = requireActivity().findViewById(R.id.userList)
        userList.layoutManager = LinearLayoutManager(context)
        userList.adapter = userAdapter
    }

    override fun showUsers(list: List<GitHubUser>) {
        userAdapter.submitList(users = list)
    }

    override fun onClickUser(user: GitHubUser) {
        presenter.displayUser(user = user)
    }

}
