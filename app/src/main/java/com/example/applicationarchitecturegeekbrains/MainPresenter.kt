package com.example.applicationarchitecturegeekbrains

class MainPresenter(
    val view: MainView,
    val model: CountersModel
) {

    init {
        for (index in model.indices) {
            view.showCounter(index = index, counter = "0")
        }
    }

    fun countUp(index: Int) {
        if (index > model.size - 1) return

        view.showCounter(index, (++model[index]).toString())
    }

}
