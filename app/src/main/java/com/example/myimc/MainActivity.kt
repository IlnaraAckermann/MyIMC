package com.example.myimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //botão
        bt.setOnClickListener {
            val altura = altura.text.toString().trim().toDouble()
            val peso = peso.text.toString().trim().toDouble()
            val a=altura/100
            val imc = peso/(a*a)
            val d = DecimalFormat("#.00")
            if (imc<17){
            textView.text = ("Seu IMC é \n${d.format(imc)}\n você está muito abaixo do peso")
            imageView.setImageResource(R.drawable.i_0)
            }
            else if (imc < 18.5 && imc >= 17 ) {
            textView.text = ("Seu IMC é \n$imc\nvocê está abaixo do peso")
            imageView.setImageResource(R.drawable.i_0)
            }
            else if (imc >= 18.5 && imc < 25 ) {
                textView.text = ("Seu IMC é \n$imc \nvocê está no peso correto")
                imageView.setImageResource(R.drawable.i_1)
            }
            else if (imc >= 25 && imc < 30 ) {
                textView.text = ("Seu IMC é \n$imc \nvocê está acima do peso")
                imageView.setImageResource(R.drawable.i_2)
            }
            else if (imc >= 30 && imc < 35 ) {
                textView.text = ("Seu IMC é \n$imc \nObesidade Grau I")
                imageView.setImageResource(R.drawable.i_3)
            }
            else if (imc >= 35 && imc < 40 ) {
                textView.text = ("Seu IMC é \n$imc \nObesidade Grau II")
                imageView.setImageResource(R.drawable.i_4)
            }
            else  {
                textView.text = ("Seu IMC é \n$imc \nObesidade Grau III")
                imageView.setImageResource(R.drawable.i_4)
            }

        }

    }
}

