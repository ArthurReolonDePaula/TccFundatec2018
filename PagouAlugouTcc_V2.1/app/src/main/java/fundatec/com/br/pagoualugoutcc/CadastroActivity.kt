package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        botaoCadastrar.setOnClickListener{view ->
            entrarPerfil()
        }
    }

    fun entrarPerfil(){
        val intent = Intent(baseContext, PerfilActivity :: class.java)
            startActivity(intent)
    }
}
