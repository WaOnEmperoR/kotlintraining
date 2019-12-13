package id.go.bppt.ptik.trainingkotlin.pegawai

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import id.go.bppt.ptik.trainingkotlin.R
import id.go.bppt.ptik.trainingkotlin.roomsample.NewWordActivity
import id.go.bppt.ptik.trainingkotlin.roomsample.WordListAdapter
import id.go.bppt.ptik.trainingkotlin.roomsample.WordViewModel

class PegawaiActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private lateinit var pegawaiViewModel: PegawaiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pegawai)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_pegawai)
        val adapter = PegawaiListAdapter(this, onClickListener = this::viewPegawai)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        pegawaiViewModel = ViewModelProvider(this).get(PegawaiViewModel::class.java)
        pegawaiViewModel.allPegawais.observe(this, Observer { pegawais -> pegawais?.let { adapter.setPegawais(it) } })

        val fab = findViewById<FloatingActionButton>(R.id.fab_pegawai)
        fab.setOnClickListener {
            val intent = Intent(this@PegawaiActivity, NewPegawaiActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK)
        {
            val nip = data?.getStringExtra("REPLY_NIP")
            val name = data?.getStringExtra("REPLY_NAME")
            val email = data?.getStringExtra("REPLY_EMAIL")
            val gender: Int? = data?.getIntExtra("REPLY_GENDER", 0)
            val alamat = data?.getStringExtra("REPLY_ALAMAT")
            val jabatan = data?.getStringExtra("REPLY_JABATAN")
            val timestamp = data?.getStringExtra("REPLY_TIMESTAMP")

            gender?.let {
                val pegawai = Pegawai(
                    nip.toString(),
                    name.toString(),
                    email.toString(),
                    it,
                    alamat.toString(),
                    jabatan.toString(),
                    timestamp.toString()
                )

                pegawaiViewModel.insert(pegawai)
            }
        }
        else
        {
            Toast.makeText(
                applicationContext,
                "Terjadi Kesalahan!!",
                Toast.LENGTH_LONG).show()
        }
    }

    fun viewPegawai(view: View, pegawai: Pegawai){
        Toast.makeText(
            applicationContext,
            "Nama : " + pegawai.name + " NIP : " +pegawai.nip,
            Toast.LENGTH_LONG).show()

        val nip:String = pegawai.nip
        val intent = Intent(this, EditPegawaiActivity::class.java)
        intent.putExtra("NIP", nip)
        startActivity(intent)
    }
}
