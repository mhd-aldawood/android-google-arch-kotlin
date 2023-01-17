package com.example.medicusai.ui.interfaces

import android.view.View
import com.example.medicusai.model.Biomarker

interface OnItemClickListener  {
    fun onClick(biomarker : Biomarker)
}