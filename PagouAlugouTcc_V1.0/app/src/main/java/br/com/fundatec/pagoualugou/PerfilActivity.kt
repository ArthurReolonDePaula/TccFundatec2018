package br.com.fundatec.pagoualugou

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
    }

    fun botaoAdicionaProduto(view: View){
        val intent = Intent(baseContext, AdicionarProdutoActivity::class.java)
            startActivity(intent)
    }

    fun botaoLista(view : View){
        val intent = Intent(baseContext, ListaActivity :: class.java)
            startActivity(intent)
    }
}
