package com.example.applicationarchitecturegeekbrains

import com.example.applicationarchitecturegeekbrains.di.DaggerAppComponent
import com.example.applicationarchitecturegeekbrains.scheduler.DefaultSchedulers
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .withSchedulers(DefaultSchedulers())
            .apply {
                val cicerone: Cicerone<Router> = Cicerone.create()

                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

}
