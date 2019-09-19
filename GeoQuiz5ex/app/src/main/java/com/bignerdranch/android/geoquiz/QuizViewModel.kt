package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {
    var currentIndex = 0
    var correct = 0
    var answered = false
    var isCheater = false
    var startNextActivity = false

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        Log.d(TAG, correct.toString())
        answered = false
        if(correct == 6){
            //start new activity
            currentIndex = 0
            startNextActivity = true
        } else {
            currentIndex = (currentIndex + 1) % questionBank.size
            if(currentIndex == 0){
                correct = 0
            }
        }
    }

    fun updateCorrect(){
        if(!answered){

            correct++
        }
    }
}