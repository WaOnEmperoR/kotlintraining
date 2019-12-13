package id.go.bppt.ptik.trainingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun greeting(view: View){
        val text = findViewById<EditText>(R.id.edt_name);
        val yourname = text.text;

        val lblMessage = findViewById<TextView>(R.id.txtYourName)
        lblMessage.text = "Hello, $yourname"
    }
}
