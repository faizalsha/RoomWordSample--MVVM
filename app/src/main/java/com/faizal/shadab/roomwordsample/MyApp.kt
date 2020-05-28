package com.faizal.shadab.roomwordsample

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MyApp: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApp))
        bind<WordRoomDatabase>() with singleton { WordRoomDatabase.getDatabase(instance()) }
        bind<WordRepository>() with singleton { WordRepository(instance<WordRoomDatabase>().wordDao()) }
        bind<WordViewModelFactory>() with singleton { WordViewModelFactory(instance(), instance()) }
    }

}