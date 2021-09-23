package com.example.applicationarchitecturegeekbrains.presentation.user

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.applicationarchitecturegeekbrains.R
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {
    private var argLogin: String? = null

    private lateinit var userLogin: TextView

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(argLogin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            argLogin = it.getString(ARG_LOGIN)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userLogin = requireActivity().findViewById(R.id.userLogin)
    }

    override fun showLogin(login: String) {
        userLogin.text = login
    }

    companion object {
        private const val ARG_LOGIN = "login"

        @JvmStatic
        fun newInstance(login: String) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, login)
                }
            }

    }

}
