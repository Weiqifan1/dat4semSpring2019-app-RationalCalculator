package dk.cphbusiness.rationalcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.calculator_buttons.*
import kotlinx.android.synthetic.main.calculator_keypad.*
import kotlinx.android.synthetic.main.calculator_stack.*

class MainActivity : AppCompatActivity() {
    lateinit var calculator: Calculator
    var inputValue = 0L
    var inputActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) calculator = Calculator()
        else calculator =
            savedInstanceState.getSerializable("calculator") as Calculator? ?: Calculator()

        setContentView(R.layout.activity_main)
        // val eb = findViewById<Button>(R.id.enterButton)
/*
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
*/
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
        val number = inputField.text.toString().toLongOrNull()
        if (number != null) {
            calculator.enter(number)
            inputField.setText("")
            }
        }

    fun updateStack() {
        stack4.setText(calculator.stack4.text)
        stack3.setText(calculator.stack3.text)
        stack2.setText(calculator.stack2.text)
        stack1.setText(calculator.stack1.text)
        if (inputActive) inputField.setText(inputValue.toString())
        else inputField.setText("")
        }

    fun doDigit(view: View) {
        fun updateInput(digit: Int) { inputValue = 10*inputValue + digit}
        // checkInput()
        println("${view.id}")
        when (view) {
            button0 -> updateInput(0)
            button1 -> updateInput(1)
            button2 -> updateInput(2)
            button3 -> updateInput(3)
            button4 -> updateInput(4)
            button5 -> updateInput(5)
            button6 -> updateInput(6)
            button7 -> updateInput(7)
            button8 -> updateInput(8)
            button9 -> updateInput(9)
            }
        inputActive = true
        updateStack()
        }

    fun doEnter(view: View) {
        if (inputActive) calculator = calculator.enter(inputValue)
        else {
            val top = calculator.stack1
            calculator = calculator.push(top)
            }
        inputValue = 0L
        inputActive = false
        updateStack()
        }

    fun doOperation(view: View) {
        if (inputActive) calculator = calculator.enter(inputValue)
        when (view) {
            buttonDiv -> calculator = calculator.div()
            buttonTimes -> calculator = calculator.times()
            buttonMinus -> calculator = calculator.minus()
            buttonPlus -> calculator = calculator.plus()
            buttonClear -> calculator = calculator.clear()
            buttonStore -> calculator.store()
            buttonRecall -> calculator.recall()
            buttonUndo -> {
                calculator = calculator.history ?: calculator

                // val h = calculator.history
                // if (h != null) calculator = h

                }
            }
        inputValue = 0L
        inputActive = false
        updateStack()
        }
    }
