package id.go.bppt.ptik.trainingkotlin.pegawai

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.go.bppt.ptik.trainingkotlin.roomsample.Word
import id.go.bppt.ptik.trainingkotlin.roomsample.WordRepository
import id.go.bppt.ptik.trainingkotlin.roomsample.WordRoomDatabase
import kotlinx.coroutines.launch

class PegawaiViewModel(application: Application) : AndroidViewModel(application){

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: PegawaiRepository
    // LiveData gives us updated words when they change.
    val allPegawais: LiveData<List<Pegawai>>
    var singlePegawai: LiveData<Pegawai> ?= null

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val pegawaisDao = PegawaiRoomDatabase.getDatabase(application, viewModelScope).pegawaiDao()
        repository = PegawaiRepository(pegawaisDao)
        allPegawais = repository.allPegawais
    }

    fun insert(pegawai: Pegawai) = viewModelScope.launch {
        repository.insert(pegawai)
    }

    fun getSingle(nip: String) = viewModelScope.launch {
        singlePegawai = repository.getSingle(nip)
    }

    fun update(pegawai: Pegawai) = viewModelScope.launch {
        repository.update(pegawai)
    }

    fun delete(pegawai: Pegawai) = viewModelScope.launch {
        repository.delete(pegawai)
    }

}