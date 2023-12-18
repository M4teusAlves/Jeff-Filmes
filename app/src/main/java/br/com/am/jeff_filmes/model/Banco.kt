package br.com.am.jeff_filmes.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Banco(context: Context) : SQLiteOpenHelper(context, "Banco", null, 1)
{
    override fun onCreate(db: SQLiteDatabase)
    {
        val nomeTabela = "Filme"
        val id = "id"
        val titulo = "titulo"
        val SQL_criacao =
            "CREATE TABLE ${nomeTabela} (" +
                    "${id} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${titulo} TEXT NOT NULL," +
                    "valor REAL NOT NULL)"
        db.execSQL(SQL_criacao)
    }
    override fun onUpgrade(db: SQLiteDatabase, versaoAntiga: Int, novaVersao: Int) {
        val SQL_exclusao = "DROP TABLE IF EXISTS Filme"
        db.execSQL(SQL_exclusao)
        onCreate(db)
    }
}