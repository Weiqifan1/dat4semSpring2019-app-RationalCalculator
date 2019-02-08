package dk.cphbusiness.rationalcalculator

class Calculator {
    var stack4: Rational = 0.toRational()
    var stack3: Rational = 0.toRational()
    var stack2: Rational = 0.toRational()
    var stack1: Rational = 0.toRational()

    fun enter(number: Long) { push(number.toRational()) }

    fun div() {
        stack1 /= pop()
        }

    fun plus() {
        stack1 += pop()
        }

    fun times() {
        stack1 *= pop()
        }

    fun minus() {
        stack1 -= pop()
        }

    fun push(rational: Rational) {
        stack4 = stack3
        stack3 = stack2
        stack2 = stack1
        stack1 = rational
        }

    fun pop(): Rational {
        val top = stack1
        stack1 = stack2
        stack2 = stack3
        stack3 = stack4
        return top
        }
    }