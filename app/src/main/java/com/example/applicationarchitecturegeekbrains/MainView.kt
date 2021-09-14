package com.example.applicationarchitecturegeekbrains

interface MainView {

    /**
     * Показывает счетчик на экране по номеру.
     * @param index номер счетчика
     * @param counter новое значение счетчика
     */
    fun showCounter(index: Int, counter: String)
}
