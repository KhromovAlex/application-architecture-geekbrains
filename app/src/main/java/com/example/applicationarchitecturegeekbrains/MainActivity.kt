package com.example.applicationarchitecturegeekbrains

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationarchitecturegeekbrains.R.layout.activity_main

class MainActivity : AppCompatActivity(activity_main), MainView {

    private val presenter: MainPresenter by lazy {
        MainPresenter(view = this, model = CountersModel)
    }

    private val counters: List<Button> by lazy {
        listOf(
            findViewById(R.id.btn_counter1),
            findViewById(R.id.btn_counter2),
            findViewById(R.id.btn_counter3),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (index in counters.indices) {
            counters[index].setOnClickListener {
                presenter.countUp(index)
            }
        }
    }

    override fun showCounter(index: Int, counter: String) {
        counters[index].text = counter
    }

}
