package fundatec.com.br.pagoualugoutcc

import android.text.Editable

class Produto() {
    var descricao : String = " "
    var preco : String = " "
    var nomeProduto : String = " "

    constructor(descricao: String, preco: String, nomeProduto: String) : this (){
        this.descricao = descricao
        this.preco = preco
        this.nomeProduto = nomeProduto
    }

    override fun toString() : String {
        return "descricao: $descricao " + "preco: $preco" + "nomeProduto $nomeProduto".toString().toString().toString()
    }


}