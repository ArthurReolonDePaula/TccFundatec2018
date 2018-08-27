package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        botaoPerfilAnunciarProduto.setOnClickListener{view ->
            anunciarProduto()
        }

        botaoPerfilLista.setOnClickListener { View ->
            listarProdutos()
        }
    }

    fun anunciarProduto(){
        val intent = Intent(baseContext, AnunciaProdutoActivity :: class.java)
            startActivity(intent)
    }

    fun listarProdutos(){
        val intent = Intent(baseContext, ListaProdutosActivity :: class.java)
            startActivity(intent)
    }
}
