package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_anuncia_produto.*

class AnunciaProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anuncia_produto)

        botaoAnunciarProduto.setOnClickListener {view ->
            publicaProduto()
        }
    }

    fun publicaProduto(){
        val intent = Intent(baseContext, MainActivity :: class.java)
            startActivity(intent)
    }
}
