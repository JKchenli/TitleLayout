package com.cl.titlelayout.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.SparseArray
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import com.cl.titlelayout.R

/**
 * @author Chenli
 * @Date 2021/1/13
 * @Description
 */
class TitleLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {

    var titleView: CellView
    var rightView = SparseArray<CellView>()
    var leftView = SparseArray<CellView>()

    /**
     *
     */
    @ColorInt
    private var titleTextColor: Int

    @Dimension
    private var titleTextSize: Float

    @ColorInt
    private var operationTextColor: Int

    @Dimension
    private var operationTextSize: Float

    init {
        val attr = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout, 0, 0)
        val titleText = attr.getString(R.styleable.TitleLayout_title_titleText)
        val titleIcon = attr.getDrawable(R.styleable.TitleLayout_title_titleIcon)
        val leftIcon1 = attr.getDrawable(R.styleable.TitleLayout_title_leftIcon1)
        val leftText1 = attr.getString(R.styleable.TitleLayout_title_leftText1)
        val leftIcon2 = attr.getDrawable(R.styleable.TitleLayout_title_leftIcon2)
        val leftText2 = attr.getString(R.styleable.TitleLayout_title_leftText2)
        val leftIcon3 = attr.getDrawable(R.styleable.TitleLayout_title_leftIcon3)
        val leftText3 = attr.getString(R.styleable.TitleLayout_title_leftText3)
        val rightIcon1 = attr.getDrawable(R.styleable.TitleLayout_title_rightIcon1)
        val rightText1 = attr.getString(R.styleable.TitleLayout_title_rightText1)
        val rightIcon2 = attr.getDrawable(R.styleable.TitleLayout_title_rightIcon2)
        val rightText2 = attr.getString(R.styleable.TitleLayout_title_rightText2)
        val rightIcon3 = attr.getDrawable(R.styleable.TitleLayout_title_rightIcon3)
        val rightText3 = attr.getString(R.styleable.TitleLayout_title_rightText3)
        titleTextColor =
            attr.getColor(
                R.styleable.TitleLayout_title_titleTextColor,
                TitleLayoutConfig.getTitleTextColor()
            )
        titleTextSize = attr.getDimension(
            R.styleable.TitleLayout_title_titleTextSize,
            TitleLayoutConfig.getTitleTextSize(context)
        )
        operationTextColor =
            attr.getColor(
                R.styleable.TitleLayout_title_operationTextColor,
                TitleLayoutConfig.getOperationTextColor()
            )
        operationTextSize = attr.getDimension(
            R.styleable.TitleLayout_title_operationTextSize,
            TitleLayoutConfig.getOperationTextSize(context)
        )
        titleView = CellView(context, this, titleIcon, titleText, titleTextColor, titleTextSize)
        var left1 =
            CellView(context, this, leftIcon1, leftText1, operationTextColor, operationTextSize)
        var left2 =
            CellView(context, this, leftIcon2, leftText2, operationTextColor, operationTextSize)
        var left3 =
            CellView(context, this, leftIcon3, leftText3, operationTextColor, operationTextSize)
        leftView.put(1, left1)
        leftView.put(2, left2)
        leftView.put(3, left3)
        var right1 =
            CellView(context, this, rightIcon1, rightText1, operationTextColor, operationTextSize)
        var right2 =
            CellView(context, this, rightIcon2, rightText2, operationTextColor, operationTextSize)
        var right3 =
            CellView(context, this, rightIcon3, rightText3, operationTextColor, operationTextSize)
        rightView.put(1, right1)
        rightView.put(2, right2)
        rightView.put(3, right3)
        attr.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)

        measureChildren(widthMeasureSpec, heightMeasureSpec)

        for (child in 0 until childCount) {
            getChildAt(child).apply { minimumWidth = measuredHeight }
        }

        setMeasuredDimension(sizeWidth, sizeHeight)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun onLayout(change: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        //titleView位置
        val titleView = titleView.getContent()
        titleView?.layout(
            (measuredWidth - titleView.measuredWidth) / 2, 0,
            (measuredWidth + titleView.measuredWidth) / 2, titleView.measuredHeight
        )
        //leftView位置
        val leftView1 = leftView[1].getContent()
        leftView1?.layout(
            0, 0, leftView1.measuredWidth, leftView1.measuredHeight
        )
        val leftStart1 = leftView1?.measuredWidth ?: 0
        val leftView2 = leftView[2].getContent()
        leftView2?.layout(
            leftStart1, 0, leftStart1 + leftView2.measuredWidth, leftView2.measuredHeight
        )

        val leftStart2 = leftStart1 + (leftView2?.measuredWidth ?: 0)
        val leftView3 = leftView[3].getContent()
        leftView3?.layout(
            leftStart2, 0, leftStart2 + leftView3.measuredWidth, leftView3.measuredHeight
        )
        //rightView位置
        val rightView1 = rightView[1].getContent()
        rightView1?.layout(
            measuredWidth - rightView1.measuredWidth, 0, measuredWidth, rightView1.measuredHeight
        )
        val rightEnd1 = measuredWidth - (rightView1?.measuredWidth ?: 0)
        val rightView2 = rightView[2].getContent()
        rightView2?.layout(
            rightEnd1 - rightView2.measuredWidth, 0,
            rightEnd1, rightView2.measuredHeight
        )
        val rightEnd2 = rightEnd1 - (rightView2?.measuredWidth ?: 0)
        val rightView3 = rightView[3].getContent()
        rightView3?.layout(
            rightEnd2 - rightView3.measuredWidth, 0,
            rightEnd2, rightView3.measuredHeight
        )
    }
}