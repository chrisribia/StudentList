package ke.co.studentlist.ui.ui

import ke.co.studentlist.databinding.StudentlistitemBinding
import ke.co.studentlist.ui.data.db.entity.Students

import com.xwray.groupie.databinding.BindableItem
import ke.co.studentlist.R

class StudentItem(
    private val students : Students)
    : BindableItem<StudentlistitemBinding>(){
    override fun getLayout() = R.layout.studentlistitem

    override fun bind(viewBinding: StudentlistitemBinding, position: Int) {
        viewBinding.setStudents(students)
            }
}