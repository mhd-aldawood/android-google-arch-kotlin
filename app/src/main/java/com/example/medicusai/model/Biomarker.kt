package com.example.medicusai.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Biomarker {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("info")
    @Expose
    var info: String? = null

    @SerializedName("color")
    @Expose
    var color: String? = null

    @SerializedName("value")
    @Expose
    var value: String? = null

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null

    @SerializedName("insight")
    @Expose
    var insight: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null
    override fun toString(): String {
        return ("Category:" + category
                + "\tColor:" + color
                + "\tDate:" + date
                + "\tInfo:" + info
                + "\tInsight:" + insight
                + "\tSymbol:" + symbol
                + "\tValue:" + value
                + "\tId:" + id.toString())
    }
}