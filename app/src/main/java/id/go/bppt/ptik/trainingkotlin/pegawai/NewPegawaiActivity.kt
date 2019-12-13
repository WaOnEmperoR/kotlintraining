package id.go.bppt.ptik.trainingkotlin.pegawai

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import id.go.bppt.ptik.trainingkotlin.R
import java.util.*

class NewPegawaiActivity : AppCompatActivity() {

    private lateinit var editNipView: EditText
    private lateinit var editNameView: EditText
    private lateinit var editEmailView: EditText
    private lateinit var editAlamatView: EditText
    private lateinit var editJabatanView: EditText
    private lateinit var radioGenderView: RadioGroup

    var selection: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pegawai)

        editNipView = findViewById(R.id.edt_nip)
        editNameView = findViewById(R.id.edt_name)
        editEmailView = findViewById(R.id.edt_email)
        editAlamatView = findViewById(R.id.edt_alamat)
        editJabatanView = findViewById(R.id.edt_jabatan)
        radioGenderView = findViewById(R.id.rg_gender_edit)

        radioGenderView.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(applicationContext," On checked change : ${radio.text}",
                    Toast.LENGTH_SHORT).show()

                var choice = radio.text
                if (choice == "Male")
                {
                    selection = 0
                }
                else
                {
                    selection = 1
                }
            })

        val button = findViewById<Button>(R.id.btn_submit)
        button.setOnClickListener {
            val replyIntent = Intent()

            replyIntent.putExtra("REPLY_NIP", editNipView.text.toString())
            replyIntent.putExtra("REPLY_NAME", editNameView.text.toString())
            replyIntent.putExtra("REPLY_EMAIL", editEmailView.text.toString())
            replyIntent.putExtra("REPLY_GENDER", selection)
            replyIntent.putExtra("REPLY_ALAMAT", editAlamatView.text.toString())
            replyIntent.putExtra("REPLY_JABATAN", editJabatanView.text.toString())
            replyIntent.putExtra("REPLY_TIMESTAMP", Date().toString())

            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "id.go.bppt.ptik.trainingkotlin.REPLY"
    }
}
