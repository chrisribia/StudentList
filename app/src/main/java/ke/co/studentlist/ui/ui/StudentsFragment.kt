package ke.co.studentlist.ui.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import ke.co.studentlist.R
import ke.co.studentlist.ui.data.db.entity.Students
import ke.co.studentlist.ui.utils.Coroutines
import kotlinx.android.synthetic.main.students_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class StudentsFragment : Fragment(), KodeinAware {
    override val kodein by kodein()

    private lateinit var viewModel: StudentsViewModel
    private val factory: StudentsViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.students_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(StudentsViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = Coroutines.main {

        viewModel.student.await().observe(this, Observer {

            initRecyclerView(it.toStudentItem())
        })
    }


    private fun initRecyclerView(quoteItem: List<studentitem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(quoteItem)
        }

        mrecyclerview.apply {
            layoutManager = LinearLayoutManager(context)

            setHasFixedSize(true)
            adapter = mAdapter
        }


    }

    private fun List<Students>.toStudentItem() : List<studentitem>{
        return this.map {
            studentitem(it)
        }
    }

}
