package dk.cphbusiness.rationalcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val eb = findViewById<Button>(R.id.enterButton)
        enterButton.setOnClickListener {
            val number: Long = editText2.text.toString().toLongOrNull() ?: 0L
            calculator.enter(number)
            updateStack()
            editText2.setText("")
            }
        divButton.setOnClickListener {
            checkInput()
            calculator.div()
            updateStack()
            }
        plusButton.setOnClickListener {
            calculator.plus()
            updateStack()
            }
        timesButton.setOnClickListener {
            calculator.times()
            updateStack()
            }
        minusButton.setOnClickListener {
            calculator.minus()
            updateStack()
            }
        }

    fun checkInput() {
        val number = editText2.text.toString().toLongOrNull()
        if (number != null) {
            calculator.enter(number)
            editText2.setText("")
            }
        }

    fun updateStack() {
        stack2.setText(calculator.stack2.text)
        stack1.setText(calculator.stack1.text)
        }
}
