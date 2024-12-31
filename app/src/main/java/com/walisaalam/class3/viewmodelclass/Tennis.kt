package com.walisaalam.class3.viewmodelclass

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.walisaalam.class3.R

class Tennis :AppCompatActivity(){
    private lateinit var tvtvTeamOneScore: TextView
    private lateinit var tvtvTeamTwoScore: TextView


    private val tennisScoreViewModel: TennisScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tennis_match)
        tvtvTeamOneScore = findViewById(R.id.tvScoreOne)
        tvtvTeamTwoScore = findViewById(R.id.tvScoreTwo)

        tennisScoreViewModel.teamOneScore.observe(this, Observer  { newValue ->
            tvtvTeamOneScore.text = newValue.toString()
        })
        tennisScoreViewModel.teamTwoScore.observe(this, Observer { newValue ->
            tvtvTeamTwoScore.text = newValue.toString()
        })


        findViewById<Button>(R.id.btnTeamOne).setOnClickListener{
            tennisScoreViewModel.addScoreToTeamOne()
            tennisScoreViewModel.checkWinner(
                onRoundWinner = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                },
                onFinalWinner = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }

            )
        }
        findViewById<Button>(R.id.btnTeamTwo).setOnClickListener{
            tennisScoreViewModel.addScoreToTeamTwo()
            tennisScoreViewModel.checkWinner(
                onRoundWinner = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                },
                onFinalWinner = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
            )
        }
    }



}