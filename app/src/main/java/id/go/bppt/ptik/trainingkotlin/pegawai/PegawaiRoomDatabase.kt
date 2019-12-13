package id.go.bppt.ptik.trainingkotlin.pegawai

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Pegawai::class), version = 1, exportSchema = false)
abstract class PegawaiRoomDatabase : RoomDatabase() {

    abstract fun pegawaiDao(): PegawaiDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PegawaiRoomDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
        ): PegawaiRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PegawaiRoomDatabase::class.java,
                    "word_database"
                ).addCallback(PegawaiDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class PegawaiDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            PegawaiRoomDatabase.INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.pegawaiDao())
                }
            }
        }

        suspend fun populateDatabase(pegawaiDao: PegawaiDao) {
            // Delete all content here.
            pegawaiDao.deleteAll()

            var pegawai = Pegawai("1", "Mamas", "mamas@gmail.com", 0, "Haha", "Bos", "2019")
            pegawaiDao.insert(pegawai)
        }
    }

}