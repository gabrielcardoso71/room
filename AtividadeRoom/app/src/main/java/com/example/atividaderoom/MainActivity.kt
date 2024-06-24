package com.example.atividaderoom

import android.os.Bundle
import android.util.Log
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.atividaderoom.model.UsuarioModel
import com.example.atividaderoom.repository.UsuarioDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instancia de Room
        val usuarioDatabase = UsuarioDataBase.getDataBase(this).usuarioDAO()

        //Insert
        val retornoInsert = usuarioDatabase.insertUser(UsuarioModel().apply {
            //this.id_usuario = 1
            this.nome = "Miguel Parreiras"
            this.idade = 17
        })

        val retornoSelectMultiplo = usuarioDatabase.getAll()//Retorna todos os registros

        for(item in retornoSelectMultiplo){
            Log.d("Retorno Múltiplo", "id_usuario: ${item.id_usuario}, nome: ${item.nome}, idade: ${item.idade}")
        }


    }
}