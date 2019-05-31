package com.petrlr14.mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.petrlr14.mvvm.database.daos.GitHubDAO
import com.petrlr14.mvvm.database.entities.GitHubRepo

@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun repoDao():GitHubDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {
            //TODO("Si la instancia no es nula devuelve la INSTANCE db")
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            //TODO("Si la instancia es nula la crea y la devuelve asegurando que no es nula !! db")
            else{
            synchronized(this) {
                INSTANCE = Room
                    .databaseBuilder(context, RoomDB::class.java, "Repo_Database")
                    .build()
                return INSTANCE!!}
            }

        }

    }

}