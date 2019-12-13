package id.go.bppt.ptik.trainingkotlin.pegawai

import androidx.lifecycle.LiveData

class PegawaiRepository(private val pegawaiDao: PegawaiDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allPegawais: LiveData<List<Pegawai>> = pegawaiDao.getPegawai()

    suspend fun insert(pegawai: Pegawai) {
        pegawaiDao.insert(pegawai)
    }

    fun getSingle(nip: String): LiveData<Pegawai>
    {
        return pegawaiDao.getSinglePegawai(nip)
    }

    suspend fun update(pegawai: Pegawai){
        pegawaiDao.update(pegawai)
    }

    suspend fun delete(pegawai: Pegawai)
    {
        pegawaiDao.deleteSingle(pegawai)
    }
}