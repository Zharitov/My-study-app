package study.rtvx.mystudyapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.Array
import kotlin.random.Random


class GameLevel : AppCompatActivity() {



    private val arrayOne = arrayOf(
        R.drawable.edible1,
        R.drawable.inedible1,
        R.drawable.edible2,
        R.drawable.inedible2,
        R.drawable.edible3,
        R.drawable.inedible3,
        R.drawable.edible4,
        R.drawable.inedible4,
        R.drawable.edible5,
        R.drawable.inedible5,
        R.drawable.edible6,
        R.drawable.inedible6,
        R.drawable.edible7,
        R.drawable.inedible7,
        R.drawable.edible8,
        R.drawable.inedible8,
        R.drawable.edible9,
        R.drawable.inedible9,
        R.drawable.edible10,
        R.drawable.inedible10
    )
    private val strong = arrayOf(
        1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0
    )


        private val arrayOneSize = arrayOne.size



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_level)

        var point:Int = 0
        var score: TextView = findViewById(R.id.level_score)

    //Вывод картинки в левую часть
        val left:ImageView=findViewById(R.id.img_left)
        var leftRand = Random.nextInt(arrayOneSize)
        var leftStrong:Int = strong[leftRand]
        left.setImageResource(arrayOne[leftRand])

    //Вывод картинки в правую часть
        val right:ImageView=findViewById(R.id.img_right)
        var rightRand = Random.nextInt(arrayOneSize)
        var rightStrong:Int = strong[rightRand]
        right.setImageResource(arrayOne[rightRand])

      while (rightStrong==leftStrong) {
          rightRand = Random.nextInt(arrayOneSize)
          rightStrong = strong[rightRand]
          right.setImageResource(arrayOne[rightRand])
       }

      //Нажатие на левую картинку
        left.setOnClickListener{
            if (leftStrong>rightStrong){
                point += 1
                score.text = "$point"
            } else {
                if (point==0){
                    point=0}
                else {
                    point -= 1
                    score.text = "$point" }
                    }
            leftRand = Random.nextInt(arrayOneSize)
            leftStrong = strong[leftRand]
            left.setImageResource(arrayOne[leftRand])
            rightRand = Random.nextInt(arrayOneSize)
            rightStrong = strong[rightRand]
            right.setImageResource(arrayOne[rightRand])
            while (rightStrong==leftStrong) {
                rightRand = Random.nextInt(arrayOneSize)
                rightStrong = strong[rightRand]
                right.setImageResource(arrayOne[rightRand])
            }

            if (point==10){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                val text = "Поздравляю! Вы прошли игру!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
        //Нажатие на правую кнопку
        right.setOnClickListener{
            if (leftStrong<rightStrong){
                point += 1
                score.text = "$point"
            } else {
                if (point==0){
                    point=0}
                else {
                    point -= 1
                    score.text = "$point" }
            }
            leftRand = Random.nextInt(arrayOneSize)
            leftStrong = strong[leftRand]
            left.setImageResource(arrayOne[leftRand])
            rightRand = Random.nextInt(arrayOneSize)
            rightStrong = strong[rightRand]
            right.setImageResource(arrayOne[rightRand])
            while (rightStrong==leftStrong) {
                rightRand = Random.nextInt(arrayOneSize)
                rightStrong = strong[rightRand]
                right.setImageResource(arrayOne[rightRand])
            }
            if (point==10){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                val text = "Поздравляю! Вы прошли игру!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }






    }
    }


