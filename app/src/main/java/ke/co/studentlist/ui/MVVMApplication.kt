package ke.co.studentlist.ui

import android.app.Application
import ke.co.studentlist.ui.data.db.AppDatabase
import ke.co.studentlist.ui.data.network.MyApi
import ke.co.studentlist.ui.data.network.NetworkConnectionInterceptor
import ke.co.studentlist.ui.data.repository.StudentRepository
import ke.co.studentlist.ui.ui.StudentsViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { StudentRepository(instance(), instance()) }
        bind() from provider { StudentsViewModelFactory(instance()) }


    }
}