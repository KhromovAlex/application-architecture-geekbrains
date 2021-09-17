package com.example.applicationarchitecturegeekbrains

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationarchitecturegeekbrains.R.layout.activity_main

class MainActivity : AppCompatActivity(activity_main), MainView {

    private val presenter: MainPresenter by lazy {
        MainPresenter(view = this, model = CountersModel)
    }

    private val buttonCounter1: Button by lazy { findViewById(R.id.btn_counter1) }
    private val buttonCounter2: Button by lazy { findViewById(R.id.btn_counter2) }
    private val buttonCounter3: Button by lazy { findViewById(R.id.btn_counter3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buttonCounter1.setOnClickListener { presenter.countUp1() }
        buttonCounter2.setOnClickListener { presenter.countUp2() }
        buttonCounter3.setOnClickListener { presenter.countUp3() }
    }

    override fun showCounter1(counter: String) {
        buttonCounter1.text = counter
    }

    override fun showCounter2(counter: String) {
        buttonCounter2.text = counter
    }

    override fun showCounter3(counter: String) {
        buttonCounter3.text = counter
    }

}
