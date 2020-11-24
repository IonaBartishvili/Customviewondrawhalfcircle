package com.example.customviewondrawhalfcircle

import android.content.Context
import android.util.AttributeSet

class MyViewProperties(context: Context, attrs: AttributeSet?) {

    var color: Int
    var arcHeight : Int

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView)
        color = typedArray.getColor(R.styleable.MyView_backgroundColor, context.getColor(R.color.black))
        arcHeight = typedArray.getInteger(R.styleable.MyView_arcHeight, 0)
        typedArray.recycle()
    }
}