

package com.example.guessgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {



    private lateinit var Ed1: EditText
    private lateinit var B1: Button

    private lateinit var Input: ArrayList<String>
    private lateinit var Phrase: String
    private lateinit var output: ArrayList<String>
    private lateinit var tv1: TextView
    private lateinit var rv2: RecyclerView


    var ind=0
    var a = 0
    var guessph = 10
    var guesslet = 10
    var ph = " "




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Input = ArrayList()
        Phrase = "hello"
        output = ArrayList()


        for(i in Phrase) {
            if(i!=' ') {
                Input.add("*")
            }

        }

        tv1 = findViewById(R.id.tv)
        rv2 = findViewById(R.id.rv2)


        rv2.adapter = itemguess(this, output)
        rv2.layoutManager = LinearLayoutManager(this)


        Ed1 = findViewById(R.id.ed1)
        B1 = findViewById(R.id.b1)


        B1.setOnClickListener {

            Guessfun()
        }


    }

    fun Guessfun() {
        ph = Ed1.text.toString()
        Ed1.text.clear()
        Ed1.clearFocus()
        if (guessph > 0 && ph != "quit") {

            if (ph == Phrase) {
                tv.text="you guessed $ph"
                output.add("you win!")
                rv2.adapter?.notifyDataSetChanged()

            } else {
                guessph--
                output.add("not correct")
                output.add("$guessph guesses remaining")
                rv2.adapter?.notifyDataSetChanged()

            }

//}
            if (guessph > 0 && ph != "quit") {
                B1.setOnClickListener {
                    Guessfun()
                }
            }
        } else {
            output.add("In Guess Character")

            rv2.adapter?.notifyDataSetChanged()
            Ed1.hint = "Enter character"
            B1.setOnClickListener {
                Guessfun2()}
        } }



    fun Guessfun2() {


        ph= Ed1.text.toString()

        Ed1.text.clear()
        Ed1.clearFocus()


            var l=Phrase.length
        var num=0
        var value:Char
        while ( l>0) {
            value=Phrase[num]
            if (ph == value.toString()) {
                Input.set(Phrase.indexOf(value), ph)
                a = a + 1

            }
            num=num+1
            l=l-1


        }
        if (a > 0) {
            tv1.text = "${Input.toString()} You Guessed $ph "
            output.add("you guessed $a $ph")
            rv2.adapter?.notifyDataSetChanged()
            a=0


        } else {
            tv1.text = "${Input.toString()} You Guessed $ph "
            guesslet--
            output.add("not correct")
            output.add("$guesslet guesses remaining")
            rv2.adapter?.notifyDataSetChanged()

        }
        if (guesslet > 0 && ph != "quit") {
        B1.setOnClickListener {
            Guessfun2()
        }}else{
            output.add("Game over")
            rv2.adapter?.notifyDataSetChanged()
        }
    }}


