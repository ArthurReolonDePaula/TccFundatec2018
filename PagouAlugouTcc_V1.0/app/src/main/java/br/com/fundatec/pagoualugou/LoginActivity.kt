package br.com.fundatec.pagoualugou

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    //val database = .getInstance()
    //val usuario = database.getReference("usuario")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        }
    fun botaoCadastrar(view : View){
        val intent = Intent(baseContext, PerfilActivity :: class.java)
            startActivity(intent)
        }
    }

