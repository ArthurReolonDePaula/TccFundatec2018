package br.com.fundatec.pagoualugou

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_adicionar_produto.*

class AdicionarProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_produto)

        botaoPostarProduto.setOnClickListener { view ->
            botaoPostarProduto(view)
        }
    }

    fun botaoPostarProduto(view : View){
        val intent = Intent(baseContext, ActivityPrincipal :: class.java)
            startActivity(intent)
    }
}
