package com.walisaalam.class3.viewmodelclass

import android.net.http.SslCertificate.saveState
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.walisaalam.class3.R

class TennisMatch : AppCompatActivity() {
    private lateinit var tvtvTeamOneScore: TextView
    private lateinit var tvtvTeamTwoScore: TextView

    private var round = 0

    private var teamOneWinCount = 0
    private var teamTwoWinCount = 0

    private var teamOneScore = 0
    private var teamTwoScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tennis_match)
        tvtvTeamOneScore = findViewById(R.id.tvScoreOne)
        tvtvTeamTwoScore = findViewById(R.id.tvScoreTwo)
        Log.d("TennisMatch", "onCreate called")

        savedInstanceState?.let{
            teamOneScore = it.getInt("teamOneScore")
            teamTwoScore = it.getInt("teamTwoScore")
            round = it.getInt("round")
            teamOneWinCount = it.getInt("teamOneWinCount")
            teamTwoWinCount = it.getInt("teamTwoWinCount")
            Log.d("TennisMatch", "State restored: $teamOneScore, $teamTwoScore")
        }

        tvtvTeamOneScore.text = teamOneScore.toString()
        tvtvTeamTwoScore.text = teamTwoScore.toString()

        findViewById<Button>(R.id.btnTeamOne).setOnClickListener{
            teamOneScore++
            tvtvTeamOneScore.text = teamOneScore.toString()
            checkWinner()
        }
        findViewById<Button>(R.id.btnTeamTwo).setOnClickListener{
            teamTwoScore++
            tvtvTeamTwoScore.text = teamTwoScore.toString()
            checkWinner()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("teamOneScore", teamOneScore)
        outState.putInt("teamTwoScore", teamTwoScore)
        outState.putInt("round", round)
        outState.putInt("teamOneWinCount", teamOneWinCount)
        outState.putInt("teamTwoWinCount", teamTwoWinCount)
        Log.d("TennisMatch", "State saved: $teamOneScore, $teamTwoScore")
    }

    private fun checkWinner(){
        if( teamOneScore >= 10 ){
            Toast.makeText(this,"Winner is TeamOne in round $round",Toast.LENGTH_LONG).show()
            round++
            teamOneWinCount++
            teamOneScore = 0
            teamTwoScore = 0
            tvtvTeamOneScore.text = teamOneScore.toString()
            tvtvTeamTwoScore.text = teamTwoScore.toString()

        } else if( teamTwoScore >= 10 ){
            Toast.makeText(this,"Winner is TeamTwo in round $round",Toast.LENGTH_LONG).show()
            round++
            teamTwoWinCount++
            teamOneScore = 0
            teamTwoScore = 0
            tvtvTeamOneScore.text = teamOneScore.toString()
            tvtvTeamTwoScore.text = teamTwoScore.toString()
        }
        if( round == 3){
            if( teamOneWinCount > teamTwoWinCount){
                Toast.makeText(this,"Winner is TeamOne",Toast.LENGTH_LONG).show()
                teamOneScore = 0
                teamTwoScore = 0
                tvtvTeamOneScore.text = teamOneScore.toString()
                tvtvTeamTwoScore.text = teamTwoScore.toString()
                round = 0
            } else{
                Toast.makeText(this,"Winner is TeamTwo",Toast.LENGTH_LONG).show()
                teamOneScore = 0
                teamTwoScore = 0
                tvtvTeamOneScore.text = teamOneScore.toString()
                tvtvTeamTwoScore.text = teamTwoScore.toString()
                round = 0
            }
        }
    }

}