package fundatec.com.br.pagoualugoutcc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_anuncia_produto.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    var listaProdutos = ArrayList<Produto>()
    val EDITLISTA = 7017
    val NEWLISTAPRODUTOS = 1707
    val DELETALISTA = 7071
    var database = FirebaseDatabase.getInstance()
    var listaProdutoReference = database.getReference("cadastroProduto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listHome.setOnItemClickListener { parent, view, position, id ->
            detalhe(listaProdutos.get(position), position)
        }

        listaProdutoReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listaProdutos.clear()
                dataSnapshot.children.mapNotNullTo(listaProdutos){
                    it.getValue<Produto>(Produto::class.java)
                }
                var adapter = ProdutoAdapter<Produto>(baseContext, listaProdutos)
                listHome.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {
            }
        })

        botaoLogin.setOnClickListener{ view ->
            entrarLogin()
        }

        botaoHomeAdicionarProduto.setOnClickListener { view ->
            adicionarProdutoPelaHome()
        }

        botaoHomePerfil.setOnClickListener { view ->
            entrarPerfilPelaHome()
        }
    }

    fun detalhe(produto: Produto, position: Int){
        val intent = Intent(baseContext, DetalheProdutoActivity::class.java)
            intent.putExtra("descricao", produto.descricao)
            intent.putExtra("preco", produto.preco)
            intent.putExtra("nomeProduto", produto.nomeProduto)
            intent.putExtra("position", position)
        startActivityForResult(intent, EDITLISTA)
    }

    private fun detalhe() {
        val intent = Intent(baseContext, DetalheProdutoActivity::class.java)
            intent.putExtra("descricao", " ")
            intent.putExtra("preco", " ")
            intent.putExtra("nomeProduto", " ")
            intent.putExtra("requestCode", NEWLISTAPRODUTOS)
            startActivityForResult(intent, NEWLISTAPRODUTOS)
    }


    fun entrarLogin(){
        val intent = Intent(baseContext, LoginActivity :: class.java)
            startActivity(intent)
    }

    fun adicionarProdutoPelaHome(){
        val intent = Intent(baseContext, AnunciaProdutoActivity :: class.java)
            startActivity(intent)
    }

    fun entrarPerfilPelaHome(){
        val intent = Intent(baseContext, PerfilActivity :: class.java)
            startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == NEWLISTAPRODUTOS && data != null){
            var descricao = data.getStringExtra("descricao")
            var preco = data.getStringExtra("preco")
            var nomeProduto = data.getStringExtra("nomeProduto")
            var listaDeProdutos = Produto(descricao, preco, nomeProduto)
            listaProdutos.add(listaDeProdutos)
                Toast.makeText(baseContext, nomeProduto, Toast.LENGTH_LONG).show()
            var adapter = ArrayAdapter<Produto>(baseContext, android.R.layout.simple_list_item_1, listaProdutos)
            listHome.adapter = adapter

        }else if(resultCode == EDITLISTA && data != null){
            var descricao = data.getStringExtra("descricao")
            var preco = data.getStringExtra("preco")
            var nomeProduto = data.getStringExtra("nomeProduto")
            var position = data.getIntExtra("position", 0)
            var produtoProduto = Produto(descricao, preco, nomeProduto)
            listaProdutos.set(position, produtoProduto)
                Toast.makeText(baseContext, nomeProduto, Toast.LENGTH_LONG).show()
            var adapter = ArrayAdapter<Produto>(baseContext, android.R.layout.simple_list_item_1, listaProdutos)
            listHome.adapter = adapter
        }else if(resultCode == DELETALISTA && data != null){
            var position = data.getIntExtra("position", 0)
            listaProdutos.removeAt(position)
            var adapter = ArrayAdapter<Produto>(baseContext,android.R.layout.simple_list_item_1, listaProdutos)
            listHome.adapter = adapter
        }
    }
}
