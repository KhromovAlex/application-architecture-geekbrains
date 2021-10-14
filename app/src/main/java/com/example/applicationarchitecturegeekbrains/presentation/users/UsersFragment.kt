package com.example.applicationarchitecturegeekbrains.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import com.example.applicationarchitecturegeekbrains.presentation.users.adapter.UsersAdapter
import com.example.applicationarchitecturegeekbrains.scheduler.DefaultSchedulers
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UsersFragment : AbsFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.UserClickListener {
    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepository

    private var userList: RecyclerView? = null
    private val userAdapter: UsersAdapter = UsersAdapter(this)

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = gitHubUserRepository,
            router = router,
            schedulers = DefaultSchedulers()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userList = requireActivity().findViewById(R.id.userList)
        userList?.layoutManager = LinearLayoutManager(context)
        userList?.adapter = userAdapter
    }

    override fun showUsers(list: List<GitHubUser>) {
        userAdapter.submitList(users = list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickUser(user: GitHubUser) {
        presenter.displayUser(user = user)
    }

}
