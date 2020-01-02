package ke.co.studentlist.ui.ui

import androidx.lifecycle.ViewModel
import ke.co.studentlist.ui.data.repository.StudentRepository
import ke.co.studentlist.ui.utils.lazyDeferred

class StudentsViewModel( private val repository: StudentRepository)  : ViewModel() {

        val student  by lazyDeferred {
                   repository.fetchStudentsFromRoomDatabase()
          }
}
