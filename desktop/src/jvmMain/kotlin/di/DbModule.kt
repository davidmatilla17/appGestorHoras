package di

import app.cash.sqldelight.db.SqlDriver
import com.davidmatillacode.common.db.Database
import com.davidmatillacode.common.db.DriverFactory
import com.davidmatillacode.common.db.createDatabase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val dbModule = DI.Module("DbModule") {
    bind<DriverFactory>() with singleton { DriverFactory()}
    bind<SqlDriver>() with singleton { instance<DriverFactory>().createDriver() }
    bind<Database>() with  singleton { createDatabase(instance()) }
}