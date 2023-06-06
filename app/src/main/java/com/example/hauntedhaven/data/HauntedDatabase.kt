package com.example.hauntedhaven.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hauntedhaven.HauntedHavenApplication

@Database(entities = [HauntedPlace::class], version = 1, exportSchema = false)
abstract class HauntedDatabase : RoomDatabase() {
    abstract fun hauntedDao(): HauntedDao

    companion object {
        @Volatile
        private var INSTANCE: HauntedDatabase? = null

        fun getDatabase(context: HauntedHavenApplication): HauntedDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HauntedDatabase::class.java,
                    "haunted_database"
                )
                    .createFromAsset("database/HauntedDatabase.db") // Update the asset file path
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}



