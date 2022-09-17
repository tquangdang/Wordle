package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the TextView for the result word
        val wordToGuess_view = findViewById<TextView>(R.id.wordToGuess)
        wordToGuess_view.text = wordToGuess

        // Set up "Guess" button
        val button = findViewById<Button>(R.id.button)

        // Set On-Click Listener
        button.setOnClickListener {
            // Set up user input
            var guess_input = findViewById<EditText>(R.id.user_input)

            // Get user's guess and convert it into an uppercase string
            var firstGuess = guess_input.text.toString().uppercase()

            // Set up TextViews\
            var user_guess1 = findViewById<TextView>(R.id.user_guess1)
            var guess1_title = findViewById<TextView>(R.id.guess1_title)
            user_guess1.text = firstGuess
            guess1_title.visibility = View.VISIBLE
            var user_guess1_check = findViewById<TextView>(R.id.user_guess1_check)
            var guess1_check = findViewById<TextView>(R.id.guess1_check)
            user_guess1_check.text = checkGuess(firstGuess)
            guess1_check.visibility = View.VISIBLE

            if (user_guess1_check.text == "OOOO") {
                wordToGuess_view.visibility = View.VISIBLE
            }
            else {
                guess_input.visibility = View.INVISIBLE
                var guess_input2 = findViewById<EditText>(R.id.user_input2)
                guess_input2.visibility = View.VISIBLE
                button.setOnClickListener{
                    var secondGuess = guess_input2.text.toString().uppercase()
                    var user_guess2 = findViewById<TextView>(R.id.user_guess2)
                    var guess2_title = findViewById<TextView>(R.id.guess2_title)
                    user_guess2.text = secondGuess
                    guess2_title.visibility = View.VISIBLE
                    var user_guess2_check = findViewById<TextView>(R.id.user_guess2_check)
                    var guess2_check = findViewById<TextView>(R.id.guess2_check)
                    user_guess2_check.text = checkGuess(secondGuess)
                    guess2_check.visibility = View.VISIBLE

                    if (user_guess2_check.text == "0000") {
                        wordToGuess_view.visibility = View.VISIBLE
                    }
                    else {
                        guess_input2.visibility = View.INVISIBLE
                        var guess_input3 = findViewById<EditText>(R.id.user_input3)
                        guess_input3.visibility = View.VISIBLE
                        button.setOnClickListener{
                            var thirdGuess = guess_input3.text.toString().uppercase()
                            var user_guess3 = findViewById<TextView>(R.id.user_guess3)
                            var guess3_title = findViewById<TextView>(R.id.guess3_title)
                            user_guess3.text = thirdGuess
                            guess3_title.visibility = View.VISIBLE
                            var user_guess3_check = findViewById<TextView>(R.id.user_guess3_check)
                            var guess3_check = findViewById<TextView>(R.id.guess3_check)
                            user_guess3_check.text = checkGuess(thirdGuess)
                            guess3_check.visibility = View.VISIBLE
                            wordToGuess_view.visibility = View.VISIBLE
                        }
                    }
                }

            }
        }



    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}


