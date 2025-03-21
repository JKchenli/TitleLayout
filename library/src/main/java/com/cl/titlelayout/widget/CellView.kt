package com.cl.titlelayout.widget

import android.content.Context
import android.graphics.Typeface
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
class CellView(
    private var context: Context,
    private var parent: ViewGroup,
    cellIcon: Drawable? = null,
    cellText: String? = null,
    private var cellTextColor: Int,
    private var cellTextSize: Float,
    private var cellTextStyle: Int
) {
    private var textView: TextView? = null
    private var iconView: ImageView? = null

    init {
        cellText?.let {
            initTextView(it)
            parent.addView(textView)
        } ?: cellIcon?.let {
            initIconView(it)
            parent.addView(iconView)
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
        } ?: run {
            initTextView(text)
            parent.addView(textView)
        }
    }

    fun setIcon(icon: Drawable) {
        textView?.let {
            initIconView(icon)
            resetView(it, iconView!!)
            textView = null
        } ?: iconView?.let {
            setIconViewData(it, icon)
        } ?: run {
            initIconView(icon)
            parent.addView(iconView)
        }
    }

    private fun resetView(view: View, otherView: View) {
        parent.addView(otherView, parent.indexOfChild(view))
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
            layoutParams = ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            setImageDrawable(icon)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
        }
    }

    private fun setTextViewData(textView: TextView, text: String) {
        textView.apply {
            layoutParams = ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            gravity = Gravity.CENTER
            this.text = text
            setTextColor(cellTextColor)
            typeface = Typeface.create(Typeface.DEFAULT, cellTextStyle)
            setTextSize(TypedValue.COMPLEX_UNIT_PX, cellTextSize)
        }
    }

}