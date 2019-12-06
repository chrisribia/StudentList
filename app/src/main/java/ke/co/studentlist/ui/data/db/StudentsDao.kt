package ke.co.studentlist.ui.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ke.co.studentlist.ui.data.db.entity.Students

@Dao
interface StudentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStudents(students : List<Students>)
}
