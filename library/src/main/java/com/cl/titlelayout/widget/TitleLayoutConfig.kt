package com.cl.titlelayout.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.ColorInt
import com.cl.titlelayout.R

/**
 * @author Chenli
 * @Date 2021/1/17
 * @Description
 */
object TitleLayoutConfig {
    private const val DEFAULT_TITLE_TEXT_COLOR = "#000000"
    private const val DEFAULT_TITLE_TEXT_SIZE = 18f
    private const val DEFAULT_OPERATION_TEXT_COLOR = "#000000"
    private const val DEFAULT_OPERATION_TEXT_SIZE = 14f

    private var titleTextColor: Int = Color.parseColor(DEFAULT_TITLE_TEXT_COLOR)
    private var titleTextSize: Float = DEFAULT_TITLE_TEXT_SIZE
    private var operationTextColor: Int = Color.parseColor(DEFAULT_OPERATION_TEXT_COLOR)
    private var operationTextSize: Float = DEFAULT_OPERATION_TEXT_SIZE

    internal fun getTitleTextColor(): Int {
        return titleTextColor
    }

    internal fun getTitleTextSize(context: Context): Float {
        return convertSpToPx(titleTextSize, context.resources)
    }

    internal fun getOperationTextColor(): Int {
        return operationTextColor
    }

    internal fun getOperationTextSize(context: Context): Float {
        return convertSpToPx(operationTextSize, context.resources)
    }

    private fun convertSpToPx(sp: Float, resources: Resources): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics)
    }

    fun initTitleConfig(@ColorInt titleTextColor: Int, titleTextSize: Int): TitleLayoutConfig {
        this.titleTextColor = titleTextColor
        this.titleTextSize = titleTextSize.toFloat()
        return this
    }

    fun initOperationConfig(
        @ColorInt operationTextColor: Int,
        operationTextSize: Int
    ): TitleLayoutConfig {
        this.operationTextColor = operationTextColor
        this.operationTextSize = operationTextSize.toFloat()
        return this
    }

    fun reductionConfig() {
        this.titleTextColor = Color.parseColor(DEFAULT_TITLE_TEXT_COLOR)
        this.titleTextSize = DEFAULT_TITLE_TEXT_SIZE
        this.operationTextColor = Color.parseColor(DEFAULT_OPERATION_TEXT_COLOR)
        this.operationTextSize = DEFAULT_OPERATION_TEXT_SIZE
    }

}