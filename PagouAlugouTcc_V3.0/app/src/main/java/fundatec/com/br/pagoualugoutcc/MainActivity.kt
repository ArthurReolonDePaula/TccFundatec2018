package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoLogin.setOnClickListener{ view ->
            entrarLogin()
        }
    }

    fun entrarLogin(){
        val intent = Intent(baseContext, LoginActivity :: class.java)
            startActivity(intent)
    }
}