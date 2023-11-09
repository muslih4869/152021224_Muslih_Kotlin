package com.example.midterm_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fCalculator.newInstance] factory method to
 * create an instance of this fragment.
 */
class fCalculator : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var bmiTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_f_calculator, container, false)

        val weightEditText = view.findViewById<EditText>(R.id.weightEditText)
        val heightEditText = view.findViewById<EditText>(R.id.heightEditText)
        val bmiTextView = view.findViewById<TextView>(R.id.bmiTextView)

        val calculateButton: Button = view.findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            calculateBMI()
        }

        return view
    }
    private fun calculateBMI() {

        val weightText = weightEditText.text.toString()
        val heightText = heightEditText.text.toString()

        if (weightText.isNotEmpty() && heightText.isNotEmpty()) {
            val weight = weightText.toDouble()
            val height = heightText.toDouble()

            val bmi = weight / (height * height)
            bmiTextView.text = "Your BMI: $bmi"
        } else {
            bmiTextView.text = "Please enter both weight and height."
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fCalculator.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fCalculator().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}