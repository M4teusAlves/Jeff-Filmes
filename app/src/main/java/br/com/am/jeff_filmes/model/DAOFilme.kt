package br.com.am.jeff_filmes.model

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class DAOFilme(banco: Banco){

    var banco : Banco
    init {
        this.banco = banco
    }
    fun inserirFilme(filme : Filme): Boolean {
        val db_insercao = this.banco.writableDatabase
        var valores = ContentValues().apply{
            put("titulo", filme.titulo)
            put("valor", filme.valor)
        }
        val confirmaInsercao = db_insercao?.insert("Filme",  null, valores)
        Log.i("Teste","Inserção: "+confirmaInsercao)
        if(confirmaInsercao != null){
            if(confirmaInsercao.toInt() == -1){
                return false
            }
        }
        return true
    }


    fun mostrarFilmes(): List<Filme>{
        val listaFilmes = ArrayList<Filme>()
        val db_leitura = this.banco.readableDatabase
        var cursor = db_leitura.rawQuery("select * from Filme",null)
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow("id"))
                val titulo = getString(getColumnIndexOrThrow("titulo"))
                val valor = getFloat(getColumnIndexOrThrow("valor"))
                Log.i("Teste","ID: "+id+" - Título: "+titulo)
                listaFilmes.add(Filme(id,titulo,valor))
            }
        }
        cursor.close()
        return(listaFilmes)
    }

    fun atualizarFilme(filme : Filme){
        val db_atualizacao = this.banco.writableDatabase
        var valores = ContentValues().apply {
            put("titulo", filme.titulo)
            put("valor", filme.valor)
        }
        val condicao = "id = "+filme.id
        val confirmaAtualizacao = db_atualizacao.update("Filme", valores, condicao, null)
        Log.i("Teste", "Atualização: $confirmaAtualizacao")
    }

    fun excluirFilme(filme : Filme){
        val db_exclusao = this.banco.readableDatabase
        val condicao = "id = "+filme.id
        val confirmaExclusao = db_exclusao.delete("Filme", condicao, null)
        Log.i("Teste","Após a exclusão: "+confirmaExclusao)
    }

}