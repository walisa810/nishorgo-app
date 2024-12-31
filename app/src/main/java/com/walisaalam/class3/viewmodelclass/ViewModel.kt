package com.walisaalam.class3.viewmodelclass

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TennisScoreViewModel: ViewModel() {

    private var _teamOneScore = MutableLiveData<Int>(0)
    private var _teamTwoScore = MutableLiveData<Int>(0)
    private var _round = MutableLiveData<Int>(0)
    private var _teamOneWinCount = MutableLiveData<Int>(0)
    private var _teamTwoWinCount = MutableLiveData<Int>(0)

    val teamOneScore: LiveData<Int>
        get() = _teamOneScore
    val teamTwoScore: LiveData<Int>
        get() = _teamTwoScore
    fun addScoreToTeamOne() {
        _teamOneScore.value = _teamOneScore.value!! + 1
    }
    fun addScoreToTeamTwo() {
        _teamTwoScore.value = _teamTwoScore.value!! + 1
    }
    fun checkWinner(onRoundWinner: (String) -> Unit, onFinalWinner: (String) -> Unit) {
        val teamOne = _teamOneScore.value ?: 0
        val teamTwo = _teamTwoScore.value ?: 0
        var currentRound = _round.value ?: 0
        if( teamOne >= 10 ){
            _teamOneWinCount.value = (_teamOneWinCount.value ?: 0) + 1
            resetScores()
            onRoundWinner("Winner is Team One in round $currentRound")
            currentRound++

        } else if( teamTwo >= 10 ){

            _teamTwoWinCount.value = (_teamTwoWinCount.value ?: 0) + 1
            resetScores()
            onRoundWinner("Winner is Team Two in round $currentRound")
            currentRound++
        }
        _round.value = currentRound
        if( currentRound == 3){
            val teamOneWins = _teamOneWinCount.value ?: 0
            val teamTwoWins = _teamTwoWinCount.value ?: 0
            if (teamOneWins > teamTwoWins) {
                onFinalWinner("Winner is Team One")
            } else {
                onFinalWinner("Winner is Team Two")
            }
            resetGame()
        }

    }
    private fun resetScores(){
        _teamOneScore.value = 0
        _teamTwoScore.value = 0
    }
    private fun resetGame() {
        resetScores()
        _round.value = 0
    }



}