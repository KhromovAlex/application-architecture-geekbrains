package com.example.applicationarchitecturegeekbrains

class MainPresenter(
    val view: MainView,
    val model: CountersModel
) {

    init {
        view.showCounter1(counter = "0")
        view.showCounter2(counter = "0")
        view.showCounter3(counter = "0")
    }

    fun countUp1() {
        view.showCounter1((++model[0]).toString())
    }

    fun countUp2() {
        view.showCounter2((++model[1]).toString())
    }

    fun countUp3() {
        view.showCounter3((++model[2]).toString())
    }

}
