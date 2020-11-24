package com.example.customviewondrawhalfcircle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class MyView : View {

    private val myViewProperties: MyViewProperties
    private val paint: Paint
    private val path = Path()
    private val arcHeight: Int

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, -1)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        myViewProperties = MyViewProperties(context, attrs)
        arcHeight = myViewProperties.arcHeight
        paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = myViewProperties.color
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()

        path.apply {
            moveTo(0F, height - arcHeight)
            lineTo(0F, 0F)
            lineTo(width, 0F)
            lineTo(width, height - arcHeight)
            arcTo(
                0F,
                height - arcHeight,
                width,
                height,
                0f,
                180F,
                false
            )
            close()
        }
        canvas.drawPath(path, paint)

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

}