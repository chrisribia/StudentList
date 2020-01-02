package ke.co.studentlist.ui.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ke.co.studentlist.ui.data.db.AppDatabase
import ke.co.studentlist.ui.data.db.entity.Students
import ke.co.studentlist.ui.data.network.MyApi
import ke.co.studentlist.ui.data.network.SafeApiRequest
import ke.co.studentlist.ui.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class StudentRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {
    private val students = MutableLiveData<List<Students>>()


    init {
        students.observeForever {
            saveStudents(it)
        }
    }

    suspend fun fetchStudentsFromRoomDatabase() : LiveData<List<Students>>{
        return withContext(Dispatchers.IO){
            fetchStudentsFromServer()
            db.getStudentDao().getStudents()
        }
    }

    suspend fun fetchStudentsFromServer() {
        try {
            val response = apiRequest { api.getStudents() }
            students.postValue(response.Students)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun saveStudents(students: List<Students>) {
        Coroutines.io {
            db.getStudentDao().saveAllStudents(students)
        }
    }
}