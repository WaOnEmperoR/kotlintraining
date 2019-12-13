package id.go.bppt.ptik.trainingkotlin.pegawai

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "pegawai_table")
class Pegawai(
    @PrimaryKey @ColumnInfo(name = "nip") val nip: String,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "email") val email:String,
    @ColumnInfo(name = "gender") val gender:Int,
    @ColumnInfo(name = "alamat") val alamat:String?,
    @ColumnInfo(name = "jabatan") val jabatan:String?,
    @ColumnInfo(name = "timestamp") val timestamp:String
)