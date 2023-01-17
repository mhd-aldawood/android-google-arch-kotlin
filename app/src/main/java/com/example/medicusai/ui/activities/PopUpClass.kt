package com.example.medicusai.ui.activities

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import com.example.medicusai.R
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.view.Gravity
import android.widget.TextView
import android.view.View.OnTouchListener
import android.view.MotionEvent
import android.view.View

class PopUpClass     //    PopUpClassBinding binding;
//ViewDataBinding binding;
    (  //PopupWindow display method
    var text: String
) {
    fun showPopupWindow(view: View) {


        //Create a View object yourself through inflater
        val inflater =
            view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.pop_up_window, null)
        val view1 = popupView.findViewById<View>(R.id.root)
        view1.setBackgroundColor(Color.parseColor("#80000000"))

        //Specify the length and width through constants
        val width = LinearLayout.LayoutParams.MATCH_PARENT
        val height = LinearLayout.LayoutParams.MATCH_PARENT

        //Make Inactive Items Outside Of PopupWindow
        val focusable = true

        //Create a window with our parameters
        val popupWindow = PopupWindow(popupView, width, height, focusable)

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        //Initialize the elements of our window, install the handler
        val test2 = popupView.findViewById<TextView>(R.id.titleText)
        test2.text = text


        //Handler for clicking on the inactive zone of the window
        popupView.setOnTouchListener { v, event -> //Close the window when clicked
            popupWindow.dismiss()
            true
        }
    }
}