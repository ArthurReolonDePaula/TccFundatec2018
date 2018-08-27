package fundatec.com.br.pagoualugoutcc

class Produto() {
    var descricao : String = " "
    var preco : String = " "

    constructor(descricao : String, preco : String) : this (){
        this.descricao = descricao
        this.preco = preco
    }

    override fun toString() : String {
        return "descricao: $descricao " + " preco: $preco".toString().toString()
    }


}