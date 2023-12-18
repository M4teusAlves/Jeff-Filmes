package br.com.am.jeff_filmes.model

class Filme(id : Int, titulo : String, valor:Float)
{
    var id : Int
    var titulo : String
    var valor : Float
    init {
        this.id = id
        this.titulo = titulo
        this.valor = valor
    }

    override fun toString(): String {
        return (this.id.toString() + " "+ this.titulo )
    }
}