package br.com.fundatec.pagoualugou

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.database.DatabaseReference



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        botaoCadastrar.setOnClickListener { view ->
            botaoCadastrar(view)

            val database = FirebaseDatabase.getInstance()
            val myUsuario = database.getReference("Usuario")
            var usuarioBD = Usuario(inputNomeUsuario.text.toString(), inputSenha.text.toString(), inputEmail.text.toString())
            myUsuario.push().setValue(usuarioBD)
        }
    }
    fun botaoCadastrar(view : View){
        val intent = Intent(baseContext, PerfilActivity :: class.java)
            startActivity(intent)
        }
    }

