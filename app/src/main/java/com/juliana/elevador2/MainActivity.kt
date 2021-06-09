package com.juliana.elevador2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var andarAtual: EditText? = null
    lateinit var andar: TextView
    lateinit var pessoas: TextView
    lateinit var qualAndar: Button
    lateinit var entrar: Button
    lateinit var sair: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        andarAtual = findViewById(R.id.edtAndar)
        andar = findViewById(R.id.txtAndar)
        pessoas = findViewById(R.id.txtPessoas)
        qualAndar = findViewById(R.id.btnAndar)
        entrar = findViewById(R.id.btnEntrar)
        sair = findViewById(R.id.btnSair)

        val totalAndar = 10
        var Exibir = Elevador(0, 0)

        andar.text = "Térreo"
        pessoas.text = "0/5"

        qualAndar.setOnClickListener{

            val Andar = andarAtual?.text.toString()
            val AndarEmNumero = Andar.toIntOrNull()

            AndarEmNumero?.let {
                if (AndarEmNumero > totalAndar || AndarEmNumero < 0){
                    Toast.makeText(
                        this,"Andar não existe!", Toast.LENGTH_SHORT).show()
                }

                else{
                    Exibir.andar = AndarEmNumero

                    if(Exibir.andar == 0)
                        andar.text = "Térreo"
                    else andar.text = "${Exibir.andar} º andar"
                }

            }

        }

        entrar.setOnClickListener{

            if (Exibir.pessoas > 4)
                Toast.makeText(this, "Elevador lotado!", Toast.LENGTH_SHORT).show()
            else {
                Exibir.pessoas = Exibir.pessoas + 1
                pessoas.text = "${Exibir.pessoas}/5"
            }

        }

        sair.setOnClickListener {
            if (Exibir.pessoas == 0)
                Toast.makeText(this, "Elevador vazio!", Toast.LENGTH_SHORT).show()
            else {
                Exibir.pessoas = Exibir.pessoas - 1
                pessoas.text = "${Exibir.pessoas}/5"
            }
        }

    }

}