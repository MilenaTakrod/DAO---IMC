package br.edu.fatecpg.appimc.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.appimc.R
import br.edu.fatecpg.appimc.dao.UserDao
import br.edu.fatecpg.appimc.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fab_voltar = findViewById<FloatingActionButton>(R.id.fab_volta)
        val txv_imc = findViewById<TextView>(R.id.txv_imc)
        val txv_user = findViewById<TextView>(R.id.txv_user)
        val user = UserDao.buscar()

        txv_user.setText("Peso: " + user.peso + " Altura: " + user.altura)
        txv_imc.setText("IMC: " + intent.getStringExtra("resposta"))

        fab_voltar.setOnClickListener {
            finish()
        }
    }
}