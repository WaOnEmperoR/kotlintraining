package id.go.bppt.ptik.trainingkotlin.pegawai

import androidx.lifecycle.LiveData
import androidx.room.*
import id.go.bppt.ptik.trainingkotlin.roomsample.Word

@Dao
interface PegawaiDao {
    @Query("SELECT * from pegawai_table ORDER BY nip ASC")
    fun getPegawai(): LiveData<List<Pegawai>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pegawai: Pegawai)

    @Query("SELECT * from pegawai_table where nip=:nip")
    fun getSinglePegawai(nip:String): LiveData<Pegawai>

    @Query("DELETE FROM pegawai_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteSingle(pegawai: Pegawai)

    @Update
    suspend fun update(pegawai: Pegawai)
}