package com.example.applicationarchitecturegeekbrains.presentation.user

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.GitHubUserRepository
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {
    private var argId: Int? = null

    private val userLogin: TextView by lazy { requireActivity().findViewById(R.id.userLogin) }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(userId = argId, userRepository = GitHubUserRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            argId = it.getInt(ARG_ID)
        }
        super.onCreate(savedInstanceState)
    }

    companion object {
        private const val ARG_ID = "user id"

        fun newInstance(userId: Int): Fragment =
            UserFragment().apply {
                arguments = bundleOf(
                    ARG_ID to userId
                )
            }

    }

    override fun showLogin(user: GitHubUser) {
        userLogin.text = user.login
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun undefinedLogin() {
        Toast.makeText(context, getString(R.string.undefinedLogin), Toast.LENGTH_LONG).show()
    }

}
