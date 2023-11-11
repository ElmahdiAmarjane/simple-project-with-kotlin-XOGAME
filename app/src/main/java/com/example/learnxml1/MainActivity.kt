package com.example.learnxml1

import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var isXTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnreset= findViewById<Button>(R.id.btnreset)
        val turn = findViewById<TextView>(R.id.turn)
        val buttons = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        fun resetgame(){
            for(btn in buttons){
                btn.text=""
            }
            turn.text="X turn"
            isXTurn=true
        }
        fun startFlowerRainAnimation() {
            val flowerRainAnimation = AnimationUtils.loadAnimation(this, R.anim.flower_rain)
            // Assuming you have a layout with id 'containerLayout' as the top-level layout
            val containerLayout = findViewById<LinearLayout>(R.id.parently)
            containerLayout.startAnimation(flowerRainAnimation)
        }
        for (button in buttons) {
            button.setOnClickListener {
                if (isXTurn && button.text=="") {
                    button.text = "X"
                    turn.text="O turn"
                    isXTurn=!isXTurn
                     if(btn1.text=="X" && btn2.text=="X" && btn3.text=="X"){
                          turn.text="X is WINNER!!!"
                         startFlowerRainAnimation()
                         Handler().postDelayed(
                             { resetgame()}, 2000
                         )

                     }
                    if(btn4.text=="X" && btn5.text=="X" && btn6.text=="X"){
                        turn.text="X is WINNER!!!"
                        resetgame()
                    }
                    if(btn7.text=="X" && btn8.text=="X" && btn9.text=="X"){
                        turn.text="X is WINNER!!!"
                        resetgame()
                    }
                }
                if(!isXTurn && button.text=="") {
                    button.text = "O"
                    turn.text="X turn"
                    isXTurn=!isXTurn
                    if(btn1.text=="O" && btn2.text=="O" && btn3.text=="O"){
                        turn.text="O is WINNER!!!"
                    }
                    if(btn4.text=="O" && btn5.text=="O" && btn6.text=="O"){
                        turn.text="O is WINNER!!!"
                    }
                    if(btn7.text=="O" && btn8.text=="O" && btn9.text=="O"){
                        turn.text="O is WINNER!!!"
                    }
                }
            }
        }

        fun replay(){
            btnreset.setOnClickListener{
                for(btn in buttons){
                    btn.text=""
                }
                turn.text="X turn"
                isXTurn=true
            }
        }



        replay()

    }
}
