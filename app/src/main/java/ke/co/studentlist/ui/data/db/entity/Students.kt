package ke.co.studentlist.ui.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Students(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val reg_no : String,
    val name : String,
    val major : String,
    val phone : Int,
    val email : String

)