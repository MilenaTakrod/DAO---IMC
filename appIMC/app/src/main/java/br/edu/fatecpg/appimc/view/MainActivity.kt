package br.edu.fatecpg.appimc.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appimc.R
import br.edu.fatecpg.appimc.dao.UserDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt_altura = findViewById<EditText>(R.id.edt_altura)
        val edt_peso = findViewById<EditText>(R.id.edt_peso)

        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
        val fab_avancar = findViewById<FloatingActionButton>(R.id.fab_avanca)
        val intent = Intent(this, ResultadoActivity::class.java)


        btn_calcular.setOnClickListener {
            val altura = edt_altura.text.toString().toDouble()
            val peso = edt_peso.text.toString().toDouble()
            var resposta = ""
            UserDao.salvar(peso, altura)

            val IMC = peso / (altura*altura)
            if(IMC<18.5){
                resposta = "abaixo do peso"
            }
            else if(IMC>= 18.5 && IMC<=24.9) {
                resposta = "peso normal"
            }else if(IMC>= 25 && IMC<=29.9) {
                resposta = "sobrepeso"
            } else if(IMC>=30.0 && IMC<=39.9) {
                resposta = "obesidade"
            }else {
                resposta = "obesidade grave"
            }

            intent.putExtra("resposta",resposta)
            Toast.makeText(this,"Aluno add com sucesso!",Toast.LENGTH_SHORT).show()
        }

        fab_avancar.setOnClickListener {
            startActivity(intent)
        }
    }
}