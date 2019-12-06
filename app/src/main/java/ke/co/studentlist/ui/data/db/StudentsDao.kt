package ke.co.studentlist.ui.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ke.co.studentlist.ui.data.db.entity.Students

@Dao
interface StudentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStudents(students : List<Students>)
    @Query("SELECT * FROM Students")
    fun getStudents(): LiveData<List<Students>>
}
