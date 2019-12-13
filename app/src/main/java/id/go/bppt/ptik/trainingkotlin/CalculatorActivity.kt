package id.go.bppt.ptik.trainingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CalculatorActivity : AppCompatActivity() {

    var curr_state: Int = 0
    var selection: Int = 0
    var curr_input : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        curr_input = findViewById<EditText>(R.id.txtNumber)
    }

    fun addition(view: View)
    {
        val my_input = curr_input?.text.toString().toInt()
        curr_state = my_input

        selection = 1
        curr_input?.setText("0")
    }

    fun substract(view: View)
    {
        val my_input = curr_input?.text.toString().toInt()
        curr_state = my_input

        selection = 2
        curr_input?.setText("0")
    }

    fun time(view: View)
    {
        val my_input = curr_input?.text.toString().toInt()
        curr_state = my_input

        selection = 3
        curr_input?.setText("0")
    }

    fun divide(view: View)
    {
        val my_input = curr_input?.text.toString().toInt()
        curr_state = my_input

        selection = 4
        curr_input?.setText("0")
    }

    fun submit(view: View)
    {
        val my_input = curr_input?.text.toString().toInt()

        when (selection){
            1 -> {
                var result = curr_state + my_input
                curr_input?.setText("$result")
            }
            2 -> {
                var result = curr_state - my_input
                curr_input?.setText("$result")
            }
            3 -> {
                var result = curr_state * my_input
                curr_input?.setText("$result")
            }
            4 -> {
                var result = curr_state / my_input
                curr_input?.setText("$result")
            }
        }
        selection = 0
    }
}
