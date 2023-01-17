package com.example.medicusai.ui.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.medicusai.R
import com.example.medicusai.databinding.FragmentDetailBiomarkBinding
import com.example.medicusai.model.Biomarker
import com.example.medicusai.ui.activities.PopUpClass

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailBiomarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailBiomarkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewPinding:FragmentDetailBiomarkBinding

    public var biomarker : Biomarker? = null
        get() = field
       set(value) {
            field = value
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPinding.date.text=biomarker?.date.toString()
        viewPinding.info.text=biomarker?.info.toString()
        viewPinding.category.text=biomarker?.category.toString()
        viewPinding.insight.text=biomarker?.insight.toString()
        var s="your result is "+biomarker?.value.toString()
        viewPinding.value.text=s
        viewPinding.value.setTextColor(Color.parseColor(biomarker?.color.toString()))

        viewPinding.symbol.text=biomarker?.symbol.toString()
        viewPinding.symbolColored.text= biomarker?.symbol.toString()
        viewPinding.symbolColored.setTextColor(Color.parseColor(biomarker?.color.toString()))

        var drawable = viewPinding.symbolColored.background as (GradientDrawable)
        drawable.mutate()
        drawable.setStroke(5, Color.parseColor(biomarker?.color.toString()))
        var color="#80"+biomarker?.color.toString().split("#")[1]

        drawable.setColor(Color.parseColor(color))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewPinding=FragmentDetailBiomarkBinding.inflate(inflater, container, false)
        viewPinding.FrameLayout.setOnClickListener(View.OnClickListener {
            var popUpClass = PopUpClass(biomarker?.info.toString())
            popUpClass.showPopupWindow(it);

//            val ft: FragmentTransaction = activity?.supportFragmentManager?.beginTransaction()!!
//            var frag=PopupFragment()
//                frag.info=biomarker?.info.toString()
//            ft.replace(R.id.your_placeholder, frag, "t1")
////            ft.addToBackStack("t1")
//            ft.commit()
        })
        return viewPinding.root

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailBiomarkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailBiomarkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}