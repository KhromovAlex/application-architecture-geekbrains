package com.example.applicationarchitecturegeekbrains.presentation.users

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment = UsersFragment()

}
