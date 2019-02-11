package dk.cphbusiness.rationalcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var calculator: Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) calculator = Calculator()
        else calculator =
            savedInstanceState.getSerializable("calculator") as Calculator? ?: Calculator()

        setContentView(R.layout.activity_main)
        // val eb = findViewById<Button>(R.id.enterButton)
        enterButton.setOnClickListener {
            val number = editText2.text.toString().toLongOrNull()
            if (number == null) {
                val top = calculator.stack1
                calculator.push(top)
                }
            else calculator.enter(number)
            updateStack()
            editText2.setText("")
            }
        updateStack()
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("calculator", calculator)
        }

    override fun onPause() {
        super.onPause()
      }

    fun checkInput() {
        val number = editText2.text.toString().toLongOrNull()
        if (number != null) {
            calculator.enter(number)
            editText2.setText("")
            }
        }

    fun updateStack() {
        stack4.setText(calculator.stack4.text)
        stack3.setText(calculator.stack3.text)
        stack2.setText(calculator.stack2.text)
        stack1.setText(calculator.stack1.text)
        }

    fun doOperation(view: View) {
        checkInput()
        when (view) {
            minusButton -> calculator.minus()
            plusButton -> calculator.plus()
            timesButton -> calculator.times()
            divButton -> calculator.div()
            // divButton -> calculator = calculator.nyDiv()
            }
        updateStack()
        }
    }
