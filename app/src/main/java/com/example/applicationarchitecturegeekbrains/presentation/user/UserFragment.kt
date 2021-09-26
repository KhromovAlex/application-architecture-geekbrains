package com.example.applicationarchitecturegeekbrains.presentation.user

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.GitHubUserRepository
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {
    private var argId: Int? = null

    private lateinit var userLogin: TextView

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(userId = argId, userRepository = GitHubUserRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            argId = it.getInt(ARG_ID)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userLogin = requireActivity().findViewById(R.id.userLogin)
    }

    companion object {
        private const val ARG_ID = "user id"

        @JvmStatic
        fun newInstance(userId: Int) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, userId)
                }
            }

    }

    override fun showLogin(user: GitHubUser) {
        userLogin.text = user.login
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

}
