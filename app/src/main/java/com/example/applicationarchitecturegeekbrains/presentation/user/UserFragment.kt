package com.example.applicationarchitecturegeekbrains.presentation.user

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.R
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {
    private var argLogin: String? = null

    private val userLogin: TextView by lazy { requireActivity().findViewById(R.id.userLogin) }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(argLogin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            argLogin = it.getString(ARG_LOGIN)
        }
        super.onCreate(savedInstanceState)
    }

    override fun showLogin(login: String) {
        userLogin.text = login
    }

    override fun showError(error: Throwable) {
        Toast.makeText(
            requireContext(),
            error.message ?: getString(R.string.error),
            Toast.LENGTH_LONG
        ).show()
    }

    companion object {
        private const val ARG_LOGIN = "login"

        @JvmStatic
        fun newInstance(login: String): Fragment =
            UserFragment().apply {
                arguments = bundleOf(
                    ARG_LOGIN to login
                )
            }

    }

}
