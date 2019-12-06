package ke.co.studentlist.ui.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ke.co.studentlist.ui.data.db.entity.Students

@Database(
    entities = [Students::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getStudentDao() : StudentsDao
    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}