package com.cl.titlelayout.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * @author Chenli
 * @Date 2021/6/20
 * @Description
 */
class CellView constructor(
    private var context: Context,
    cellIcon: Drawable? = null,
    cellText: String? = null,
    private var cellTextColor: Int,
    private var cellTextSize: Float
) {
    private var textView: TextView? = null
    private var iconView: ImageView? = null

    init {
        cellText?.let {
            initTextView(it)
        } ?: cellIcon?.let {
            initIconView(it)
        }
    }

    fun getContent(): View? = textView ?: iconView ?: null

    fun setText(text: String, textColor: Int? = cellTextColor, textSize: Float? = cellTextSize) {
        textColor?.let { cellTextColor = it }
        textSize?.let { cellTextSize = it }
        iconView?.let {
            initTextView(text)
            resetView(it, textView!!)
            iconView = null
        } ?: textView?.let {
            setTextViewData(it, text)
        }
    }

    fun setIcon(icon: Drawable) {
        textView?.let {
            initIconView(icon)
            resetView(it, iconView!!)
            textView = null
        } ?: iconView?.let {
            setIconViewData(it, icon)
        }
    }

    private fun resetView(view: View, otherView: View) {
        if (view.parent is ViewGroup) {
            (view.parent as ViewGroup).addView(
                otherView,
                (view.parent as ViewGroup).indexOfChild(view)
            )
        }
    }

    private fun initTextView(text: String) {
        setTextViewData(textView ?: run {
            return@run buildTextView().also { cellView ->
                textView = cellView
            }
        }, text)
    }

    private fun initIconView(icon: Drawable) {
        setIconViewData(iconView ?: run {
            return@run buildIconView().also { cellView ->
                iconView = cellView
            }
        }, icon)
    }

    private fun buildTextView(): TextView {
        return TextView(context)
    }

    private fun buildIconView(): ImageView {
        return ImageView(context)
    }

    private fun setIconViewData(imageView: ImageView, icon: Drawable) {
        imageView.apply {
            setImageDrawable(icon)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            layoutParams = ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun setTextViewData(textView: TextView, text: String) {
        textView.apply {
            gravity = Gravity.CENTER
            this.text = text
            setTextColor(cellTextColor)
            setTextSize(TypedValue.COMPLEX_UNIT_PX, cellTextSize)
            layoutParams = ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

}