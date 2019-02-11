package dk.cphbusiness.rationalcalculator

import java.io.Serializable

class Calculator : Serializable {
    var stack4 = 0.toRational()
    var stack3 = 0.toRational()
    var stack2 = 0.toRational()
    var stack1 = 0.toRational()

    var memory = 0.toRational()

    var history: Calculator? = null

    fun enter(number: Long): Calculator = push(number.toRational())

    fun div(): Calculator {
        val active = copy()
        val top = active.pop()
        active.stack1 /= top
        return active
        }

    fun plus(): Calculator {
        val active = copy()
        val top = active.pop()
        active.stack1 += top
        return active
        }

    fun times(): Calculator {
        val active = copy()
        val top = active.pop()
        active.stack1 *= top
        return active
        }

    fun minus(): Calculator {
        val active = copy()
        val top = active.pop()
        active.stack1 -= top
        return active
        }

    fun clear(): Calculator {
        val active = copy()
        active.stack1 = 0.toRational()
        active.stack2 = 0.toRational()
        active.stack3 = 0.toRational()
        active.stack4 = 0.toRational()
        return active
        }

    fun store() {
        memory = stack1
        }

    fun recall() {
        push(memory)
        }

    fun push(rational: Rational): Calculator {
        val active = copy()
        active.stack4 = stack3
        active.stack3 = stack2
        active.stack2 = stack1
        active.stack1 = rational
        return active
        }

    private fun pop(): Rational {
        val top = stack1
        stack1 = stack2
        stack2 = stack3
        stack3 = stack4
        return top
        }

    fun copy(): Calculator {
        val copyOfThis = Calculator()
        copyOfThis.stack1 = stack1
        copyOfThis.stack2 = stack2
        copyOfThis.stack3 = stack3
        copyOfThis.stack4 = stack4
        copyOfThis.memory = memory
        copyOfThis.history = this
        return copyOfThis
        }
    }