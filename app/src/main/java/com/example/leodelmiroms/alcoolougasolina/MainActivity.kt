package com.example.leodelmiroms.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var gasolinaEditText: EditText
    lateinit var alcoolEditText: EditText
    lateinit var moreRentableText: TextView
    lateinit var calculateButton: Button
    val ACCEPTABLE_PERCENTAGE = 0.7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gasolinaEditText = findViewById(R.id.gasolina_input_price)
        gasolinaEditText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        alcoolEditText = findViewById(R.id.alcool_input_price)
        alcoolEditText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        moreRentableText = findViewById(R.id.more_rentable_text)
        calculateButton = findViewById(R.id.calculate_button)

        calculateButton.setOnClickListener {
            val gasolinaInputPrice = gasolinaEditText.text.toString()
            val alcoolInputPrice = alcoolEditText.text.toString()

            if (gasolinaInputPrice == null || gasolinaInputPrice.equals("") ){
                moreRentableText.setText(R.string.field_empty)
            } else if (alcoolInputPrice == null || alcoolInputPrice.equals("")) {
                moreRentableText.setText(R.string.field_empty)
            } else {
                calculate(gasolinaInputPrice, alcoolInputPrice)
            }
        }
    }

    fun calculate(gasolinaPrice:String, alcoolPrice: String){
        val alcoolIdealPrice = gasolinaPrice.toDouble() * ACCEPTABLE_PERCENTAGE

        if (alcoolIdealPrice >= alcoolPrice.toDouble()){
            moreRentableText.setText(R.string.better_alcool)
        }else {
            moreRentableText.setText(R.string.better_gasolina)
        }
    }
}
