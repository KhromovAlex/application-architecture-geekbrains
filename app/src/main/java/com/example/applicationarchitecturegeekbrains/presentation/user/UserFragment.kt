package com.example.applicationarchitecturegeekbrains.presentation.user

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.App
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.R.layout.fragment_user
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepositoryFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(fragment_user), UserView {

    companion object {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .apply {
                    arguments = bundleOf(
                        ARG_USER_LOGIN to userId
                    )
                }

    }

    private val argUserLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private var userLogin: TextView? = null

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = argUserLogin,
            userRepository = GitHubUserRepositoryFactory.create(requireContext()),
            router = App.router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userLogin = requireActivity().findViewById(R.id.userLogin)
        userLogin?.setOnClickListener(::clickOnUser)
    }

    private fun clickOnUser(view: View?) {
        presenter.displayRepositories()
    }

    override fun showUser(user: GitHubUser) {
        userLogin?.text = user.login
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}
