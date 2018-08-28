package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_detalhe_produto.*
import java.text.FieldPosition

class DetalheProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

        botaoVoltarDetalheProduto.setOnClickListener{view ->
            voltarHome()
        }
    }

    fun voltarHome(){
        val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
    }




}
