package com.example.weather_application.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather_application.domain.room.dao.DirectDao
import com.example.weather_application.domain.room.entites.DirectEntity


@Database(
    entities = [DirectEntity::class],
    version = 1
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun directDao(): DirectDao

}


/*
val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Copy the data
        database.execSQL("CREATE TABLE user_auth_new (id TEXT NOT NULL, first_name TEXT NOT NULL, last_name TEXT NOT NULL, rate REAL NOT NULL, reviews INTEGER NOT NULL, picture TEXT, about_me TEXT, email TEXT NOT NULL, tripsOffers INTEGER NOT NULL, tripsInvolved INTEGER NOT NULL, PRIMARY KEY(id))")
        database.execSQL("INSERT INTO user_auth_new (id,first_name,last_name,rate,reviews,picture,about_me,email,tripsOffers,tripsInvolved) " +
                "SELECT id,first_name,last_name,rate,reviews,picture,about_me,email,tripsOffers,tripsInvolved FROM user_auth")
        database.execSQL("DROP TABLE user_auth")
        database.execSQL("ALTER TABLE user_auth_new RENAME TO user_auth");

    }
}*/
