package com.example.myimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myimc.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Configura o OnClickListener para o botão usando o View Binding
        binding.bt.setOnClickListener {
            val alturaStr = binding.altura.text.toString().trim()
            val pesoStr = binding.peso.text.toString().trim()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura = alturaStr.toDouble() / 100
                val peso = pesoStr.toDouble()
                val imc = peso / (altura * altura)
                val d = DecimalFormat("#.00")

                when {
                    imc < 17 -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)}\n você está muito abaixo do peso")
                        binding.imageView.setImageResource(R.drawable.i_0)
                    }
                    imc < 18.5 -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)}\nvocê está abaixo do peso")
                        binding.imageView.setImageResource(R.drawable.i_0)
                    }
                    imc < 25 -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)} \nvocê está no peso correto")
                        binding.imageView.setImageResource(R.drawable.i_1)
                    }
                    imc < 30 -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)} \nvocê está acima do peso")
                        binding.imageView.setImageResource(R.drawable.i_2)
                    }
                    imc < 35 -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)} \nObesidade Grau I")
                        binding.imageView.setImageResource(R.drawable.i_3)
                    }
                    imc < 40 -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)} \nObesidade Grau II")
                        binding.imageView.setImageResource(R.drawable.i_4)
                    }
                    else -> {
                        binding.textView.text = ("Seu IMC é \n${d.format(imc)} \nObesidade Grau III")
                        binding.imageView.setImageResource(R.drawable.i_4)
                    }
                }
            } else {
                // Lidar com entradas em branco
                binding.textView.text = "Preencha altura e peso."
                binding.imageView.setImageResource(android.R.color.transparent) // Remover imagem
            }
        }
    }
}
