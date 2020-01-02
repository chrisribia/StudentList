package ke.co.studentlist.ui.data.network.Response

import ke.co.studentlist.ui.data.db.entity.Students

data class StudentsResponse(
    var error: Boolean,
    var Students : List<Students>
)