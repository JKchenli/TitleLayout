package com.cl.titlelayout.widget

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.cl.titlelayout.R

/**
 * @author Chenli
 * @Date 2021/1/17
 * @Description
 */
object TitleLayoutConfig {
    private var titleTextColor: Int = R.color.defaultTitleTextColor
    private var titleTextSize: Int = R.dimen.defaultTitleTextSize
    private var operationTextColor: Int = R.color.defaultOperationTextColor
    private var operationTextSize: Int = R.dimen.defaultOperationTextSize

    internal fun getTitleTextColor(context: Context): Int {
        return ContextCompat.getColor(context, titleTextColor)
    }

    internal fun getTitleTextSize(context: Context): Float {
        return context.resources.getDimension(titleTextSize)
    }

    internal fun getOperationTextColor(context: Context): Int {
        return ContextCompat.getColor(context, operationTextColor)
    }

    internal fun getOperationTextSize(context: Context): Float {
        return context.resources.getDimension(operationTextSize)
    }

    fun initTitleConfig(titleTextColor: Int, titleTextSize: Int): TitleLayoutConfig {
        this.titleTextColor = titleTextColor
        this.titleTextSize = titleTextSize
        return this
    }

    fun initOperationConfig(operationTextColor: Int, operationTextSize: Int): TitleLayoutConfig {
        this.operationTextColor = operationTextColor
        this.operationTextSize = operationTextSize
        return this
    }

}