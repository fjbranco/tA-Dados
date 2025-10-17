package pt.ipt.dados

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pt.ipt.dados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // objecto que fará ligação aos objectos presentes na interface (XML) da app
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // instanciar o objecto dinding
        binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // se carreguei no botão alguma coisa deveria ser feita
        //findViewById<Button>(R.id.btnRodarDado).setOnClickListener {}
        binding.btnRodarDado.setOnClickListener {
            // rodar o dado
            rodarDado()
        }
    }
    /**
     * Roda o dado e actualiza a imagem
     */
    private fun rodarDado() {
        /* gera numerp aleatório de 1 a 6
        *  determinar a imagem a mostrar em função do número gerado
        *  mostra a imagem correspondente ao numero gerado
        *  actualiza o texto com o número gerado*/

        // gerar o número aleatório de 1 a 6
        val numAlatorio=(1..6).random()
        //val numAleatorio=Random.nextInt(1,7)
        //val numAleatorio=Random().nextInt(6)+1

        /** determinar a imagem a mostrar em função do número gerado*/
        val imagemResource=when(numAlatorio){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        // mostra a imagem correspondente ao numero gerado
        binding.imgViewDado.setImageResource(imagemResource)

        // actualiza o texto com o número gerado
        binding.txtViewValorDado.text=numAlatorio.toString()
    }
}