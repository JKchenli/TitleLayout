package com.cl.titlelayout.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import androidx.annotation.ColorInt

/**
 * @author Chenli
 * @Date 2021/1/17
 * @Description
 */
object TitleLayoutConfig {
    private const val DEFAULT_TITLE_TEXT_COLOR = "#000000"
    private const val DEFAULT_TITLE_TEXT_SIZE = 18f
    private const val DEFAULT_TITLE_TEXT_STYLE = Typeface.NORMAL
    private const val DEFAULT_OPERATION_TEXT_COLOR = "#000000"
    private const val DEFAULT_OPERATION_TEXT_SIZE = 14f
    private const val DEFAULT_OPERATION_TEXT_STYLE = Typeface.NORMAL

    private var titleTextColor: Int = Color.parseColor(DEFAULT_TITLE_TEXT_COLOR)
    private var titleTextSize: Float = DEFAULT_TITLE_TEXT_SIZE
    private var titleTextStyle: Int = DEFAULT_TITLE_TEXT_STYLE
    private var operationTextColor: Int = Color.parseColor(DEFAULT_OPERATION_TEXT_COLOR)
    private var operationTextSize: Float = DEFAULT_OPERATION_TEXT_SIZE
    private var operationTextStyle: Int = DEFAULT_OPERATION_TEXT_STYLE

    internal fun getTitleTextColor(): Int {
        return titleTextColor
    }

    internal fun getTitleTextSize(context: Context): Float {
        return convertSpToPx(titleTextSize, context.resources)
    }

    internal fun getTitleTextStyle(): Int {
        return titleTextStyle
    }

    internal fun getOperationTextColor(): Int {
        return operationTextColor
    }

    internal fun getOperationTextSize(context: Context): Float {
        return convertSpToPx(operationTextSize, context.resources)
    }

    internal fun getOperationTextStyle(): Int {
        return titleTextStyle
    }

    private fun convertSpToPx(sp: Float, resources: Resources): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics)
    }

    fun initTitleConfig(
        @ColorInt titleTextColor: Int,
        titleTextSize: Int,
        titleTextStyle: Int = DEFAULT_TITLE_TEXT_STYLE
    ): TitleLayoutConfig {
        this.titleTextColor = titleTextColor
        this.titleTextSize = titleTextSize.toFloat()
        this.titleTextStyle = titleTextStyle
        return this
    }

    fun initOperationConfig(
        @ColorInt operationTextColor: Int,
        operationTextSize: Int,
        operationTextStyle: Int = DEFAULT_OPERATION_TEXT_STYLE
    ): TitleLayoutConfig {
        this.operationTextColor = operationTextColor
        this.operationTextSize = operationTextSize.toFloat()
        this.operationTextStyle = operationTextStyle
        return this
    }

    fun reductionConfig() {
        this.titleTextColor = Color.parseColor(DEFAULT_TITLE_TEXT_COLOR)
        this.titleTextSize = DEFAULT_TITLE_TEXT_SIZE
        this.operationTextColor = Color.parseColor(DEFAULT_OPERATION_TEXT_COLOR)
        this.operationTextSize = DEFAULT_OPERATION_TEXT_SIZE
    }

}