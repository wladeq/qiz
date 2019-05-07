package com.example.qiz

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class QuizActivity : AppCompatActivity() {

    val questionsBank = listOf<Question>(
        Question(R.string.question_africa, false),
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateQuestion()

        btn_true.setOnClickListener {
            checkAnswer(true)
        }
        btn_false.setOnClickListener {
            checkAnswer(false)
        }
        next_button.setOnClickListener {
            currentIndex = (++currentIndex) % questionsBank.size
            updateQuestion()
        }
    }

    fun updateQuestion() {
        question_text_view.setText(questionsBank[currentIndex].textResId)
    }

    fun checkAnswer(answer: Boolean) {
        val check =
            if (questionsBank[currentIndex].answer == answer) R.string.correct_toast else R.string.incorrect_toast
        Toast.makeText(this, check, Toast.LENGTH_SHORT).show()

    }
}

//72