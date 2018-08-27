package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_anuncia_produto.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AnunciaProdutoActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance()
    var cadastroProdutoReference = database.getReference("cadastroProduto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anuncia_produto)

        botaoAnunciarProduto.setOnClickListener { view ->
        }


        cadastroProdutoReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val produto = dataSnapshot.getValue(Produto::class.java)
                produto?.let {
                    Log.e("descricao", it.descricao)
                    Log.e("preco", it.preco)
                    Log.e("nomeProduto", it.nomeProduto)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        //salvar
        botaoAnunciarProduto.setOnClickListener { view ->
            //Snackbar.make(view, "Salvo", Snackbar.LENGTH_LONG).setAction("Sucess", null).show()
            val descricao = inputDescricao.text.toString()
            val preco = inputPreco.text.toString()
            val nomeProduto = inputNomeProduto.text.toString()
            val ProdutoDB = Produto(descricao, preco, nomeProduto)
            val key = cadastroProdutoReference.child("Produto").push().key
            cadastroProdutoReference.child(key).setValue(ProdutoDB)
            Toast.makeText(baseContext,"Produto cadastrado!", Toast.LENGTH_LONG).show()
            voltarPerfil()
        }
    }

    fun voltarPerfil(){
        val intent =  Intent(baseContext, PerfilActivity :: class.java)
            startActivity(intent)
    }
}
