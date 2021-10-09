package com.example.applicationarchitecturegeekbrains.presentation

import android.os.Bundle
import com.example.applicationarchitecturegeekbrains.App.Navigator.navigatorHolder
import com.example.applicationarchitecturegeekbrains.App.Navigator.router
import com.example.applicationarchitecturegeekbrains.presentation.converter.ConverterScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(ConverterScreen())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}
