package ke.co.studentlist.ui.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ke.co.studentlist.ui.data.repository.StudentRepository

@Suppress("UNCHECKED_CAST")
class StudentsViewModelFactory(
    private val repository: StudentRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentsViewModel(repository) as T
    }
}