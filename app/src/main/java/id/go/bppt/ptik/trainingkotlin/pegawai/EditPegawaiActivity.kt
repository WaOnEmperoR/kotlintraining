package id.go.bppt.ptik.trainingkotlin.pegawai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.go.bppt.ptik.trainingkotlin.R
import java.util.*

class EditPegawaiActivity : AppCompatActivity() {

    private lateinit var editNipView: EditText
    private lateinit var editNameView: EditText
    private lateinit var editEmailView: EditText
    private lateinit var editAlamatView: EditText
    private lateinit var editJabatanView: EditText
    private lateinit var radioGenderView: RadioGroup
    private lateinit var buttonSubmitView: Button

    private lateinit var pegawaiViewModel: PegawaiViewModel

    var nip: String = ""
    var selection: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pegawai)

        nip = intent.getStringExtra("NIP")
        Toast.makeText(this, nip, Toast.LENGTH_SHORT).show()

        editNipView = findViewById(R.id.edt_nip_edit)
        editNameView = findViewById(R.id.edt_name_edit)
        editEmailView = findViewById(R.id.edt_email_edit)
        editAlamatView = findViewById(R.id.edt_alamat_edit)
        editJabatanView = findViewById(R.id.edt_jabatan_edit)
        radioGenderView = findViewById(R.id.rg_gender_edit)
        buttonSubmitView = findViewById(R.id.btn_submit_edit)

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

        pegawaiViewModel = ViewModelProvider(this).get(PegawaiViewModel::class.java)
        pegawaiViewModel.getSingle(nip)
        pegawaiViewModel.singlePegawai?.observe(this, Observer { pegawais -> pegawais?.let {
            editNipView.setText(it.nip)
            editNameView.setText(it.name)
            editEmailView.setText(it.email)
            editAlamatView.setText(it.alamat)
            editJabatanView.setText(it.jabatan)
            if (it.gender == 0)
                radioGenderView.check(R.id.rb_male_edit)
            else
                radioGenderView.check(R.id.rb_female_edit)
        } })



        buttonSubmitView.setOnClickListener {
            val pegawai = Pegawai(
                editNipView.text.toString(),
                editNameView.text.toString(),
                editEmailView.text.toString(),
                selection,
                editAlamatView.text.toString(),
                editJabatanView.text.toString(),
                Date().toString()
            )

            pegawaiViewModel.update(pegawai)

            finish()
        }
    }

}
