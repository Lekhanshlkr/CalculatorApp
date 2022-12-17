package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var op="" //to store the operation
    var oldNumber="" // to store the old number when an operator is clicked
    var isNewOp=true // flag variable to trigger storing the old number

    fun buNumberEvent(view: View) {
        if(isNewOp){ // if true it means we need to clear the current screen for new i/p
            etShowNumber.setText("0")
        }
        isNewOp = false // changing the flag to avoid clearing the screen when inputting consecutive values

        val buSelect = view as Button
        var buClickValue:String = etShowNumber.text.toString()
        if(buClickValue.equals("0")){
            buClickValue=""
        }
        when(buSelect.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            buDeci.id->{
                //TODO: prevent adding more than 1 dot
                buClickValue+="."
            }
            buSign.id->{
                buClickValue="-"+ buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }

    fun buOpEvent(view: View) {

        val buSelect = view as Button
        if(op.equals("")==false){ // calling equalEvent when the expression is 12+2+2
            buEqualEvent(view)    // so that it calculates 12+2 first
        }
        when(buSelect.id){
            buDiv.id->{
                op="/"
            }
            buMul.id->{
                op="*"
            }
            buSub.id->{
                op="-"
            }
            buAdd.id->{
                op="+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp=true
    }

    fun buEqualEvent(view: View) {
        var newNumber = etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
                op=""
            }
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
                op=""
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
                op=""
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
                op=""
            }
        }
        if(finalNumber==null){
            finalNumber=0.0
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buClean(view: View){
        etShowNumber.setText("0")
        isNewOp=true
    }

    fun buPercent(view: View){
        if(oldNumber.equals("")){
            etShowNumber.setText("0")
        }
        else{
            var percentNumber:Double = (etShowNumber.text.toString().toDouble()/100) * oldNumber.toDouble()
            etShowNumber.setText(percentNumber.toString())
        }
        buEqualEvent(view)
    }
}