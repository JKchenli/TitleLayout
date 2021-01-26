package com.cl.titlelayout.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
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

    private var titleTextView: TextView? = null
    private var titleIconView: ImageView? = null
    private var titleIcon: Drawable?
    private var titleText: String?

    private var leftIcon1: Drawable?
    private var leftText1: String?
    private var leftIcon2: Drawable?
    private var leftText2: String?
    private var leftIcon3: Drawable?
    private var leftText3: String?
    private var leftTextView1: TextView? = null
    private var leftIconView1: ImageView? = null
    private var leftTextView2: TextView? = null
    private var leftIconView2: ImageView? = null
    private var leftTextView3: TextView? = null
    private var leftIconView3: ImageView? = null

    private var rightIcon1: Drawable?
    private var rightText1: String?
    private var rightIcon2: Drawable?
    private var rightText2: String?
    private var rightIcon3: Drawable?
    private var rightText3: String?
    private var rightTextView1: TextView? = null
    private var rightIconView1: ImageView? = null
    private var rightTextView2: TextView? = null
    private var rightIconView2: ImageView? = null
    private var rightTextView3: TextView? = null
    private var rightIconView3: ImageView? = null

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
        titleText = attr.getString(R.styleable.TitleLayout_title_titleText)
        titleIcon = attr.getDrawable(R.styleable.TitleLayout_title_titleIcon)
        leftIcon1 = attr.getDrawable(R.styleable.TitleLayout_title_leftIcon1)
        leftText1 = attr.getString(R.styleable.TitleLayout_title_leftText1)
        leftIcon2 = attr.getDrawable(R.styleable.TitleLayout_title_leftIcon2)
        leftText2 = attr.getString(R.styleable.TitleLayout_title_leftText2)
        leftIcon3 = attr.getDrawable(R.styleable.TitleLayout_title_leftIcon3)
        leftText3 = attr.getString(R.styleable.TitleLayout_title_leftText3)
        rightIcon1 = attr.getDrawable(R.styleable.TitleLayout_title_rightIcon1)
        rightText1 = attr.getString(R.styleable.TitleLayout_title_rightText1)
        rightIcon2 = attr.getDrawable(R.styleable.TitleLayout_title_rightIcon2)
        rightText2 = attr.getString(R.styleable.TitleLayout_title_rightText2)
        rightIcon3 = attr.getDrawable(R.styleable.TitleLayout_title_rightIcon3)
        rightText3 = attr.getString(R.styleable.TitleLayout_title_rightText3)
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
        getTitleView()?.let { addView(it) }
        addLeftLayoutView()
        addRightLayoutView()
        attr.recycle()
    }

    private fun buildTextView(text: String, isTitle: Boolean = false): TextView {
        return TextView(context).apply {
            gravity = Gravity.CENTER
            this.text = text
            if (isTitle) {
                setTextColor(titleTextColor)
                setTextSize(TypedValue.COMPLEX_UNIT_PX, titleTextSize)
            } else {
                setTextColor(operationTextColor)
                setTextSize(TypedValue.COMPLEX_UNIT_PX, operationTextSize)
            }
            layoutParams = LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun buildIconView(icon: Drawable): ImageView {
        return ImageView(context).apply {
            setImageDrawable(icon)
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            layoutParams = LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    fun getTitleView(): View? {
        if (titleText != null) {
            titleTextView ?: run { titleTextView = buildTextView(titleText!!, true) }
            return titleTextView
        } else if (titleIcon != null) {
            titleIconView ?: run { titleIconView = buildIconView(titleIcon!!) }
            return titleIconView
        }
        return null
    }

    fun getLeftView1(): View? {
        if (leftIcon1 != null) {
            leftIconView1 ?: run { leftIconView1 = buildIconView(leftIcon1!!) }
            return leftIconView1
        } else if (leftText1 != null) {
            leftTextView1 ?: run { leftTextView1 = buildTextView(leftText1!!) }
            return leftTextView1
        }
        return null
    }

    fun getLeftView2(): View? {
        if (leftIcon2 != null) {
            leftIconView2 ?: run { leftIconView2 = buildIconView(leftIcon2!!) }
            return leftIconView2
        } else if (leftText2 != null) {
            leftTextView2 ?: run { leftTextView2 = buildTextView(leftText2!!) }
            return leftTextView2
        }
        return null
    }

    fun getLeftView3(): View? {
        if (leftIcon3 != null) {
            leftIconView3 ?: run { leftIconView3 = buildIconView(leftIcon3!!) }
            return leftIconView2
        } else if (leftText3 != null) {
            leftTextView3 ?: run { leftTextView3 = buildTextView(leftText3!!) }
            return leftTextView3
        }
        return null
    }

    fun getRightView1(): View? {
        if (rightIcon1 != null) {
            rightIconView1 ?: run { rightIconView1 = buildIconView(rightIcon1!!) }
            return rightIconView1
        } else if (rightText1 != null) {
            rightTextView1 ?: run { rightTextView1 = buildTextView(rightText1!!) }
            return rightTextView1
        }
        return null
    }

    fun getRightView2(): View? {
        if (rightIcon2 != null) {
            rightIconView2 ?: run { rightIconView2 = buildIconView(rightIcon2!!) }
            return rightIconView2
        } else if (rightText2 != null) {
            rightTextView2 ?: run { rightTextView2 = buildTextView(rightText2!!) }
            return rightTextView2
        }
        return null
    }

    fun getRightView3(): View? {
        if (rightIcon3 != null) {
            rightIconView3 ?: run { rightIconView3 = buildIconView(rightIcon3!!) }
            return rightIconView3
        } else if (rightText3 != null) {
            rightTextView3 ?: run { rightTextView3 = buildTextView(rightText3!!) }
            return rightTextView3
        }
        return null
    }

    private fun addLeftLayoutView() {
        getLeftView1()?.let { addView(it) }
        getLeftView2()?.let { addView(it) }
        getLeftView3()?.let { addView(it) }
    }

    private fun addRightLayoutView() {
        getRightView1()?.let { addView(it) }
        getRightView2()?.let { addView(it) }
        getRightView3()?.let { addView(it) }
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
        val titleView = getTitleView()
        titleView?.layout(
            (measuredWidth - titleView.measuredWidth) / 2, 0,
            (measuredWidth + titleView.measuredWidth) / 2, titleView.measuredHeight
        )
        //leftView位置
        val leftView1 = getLeftView1()
        leftView1?.layout(
            0, 0, leftView1.measuredWidth, leftView1.measuredHeight
        )
        val leftStart1 = leftView1?.measuredWidth ?: 0
        val leftView2 = getLeftView2()
        leftView2?.layout(
            leftStart1, 0, leftStart1 + leftView2.measuredWidth, leftView2.measuredHeight
        )

        val leftStart2 = leftStart1 + (leftView2?.measuredWidth ?: 0)
        val leftView3 = getLeftView3()
        leftView3?.layout(
            leftStart2, 0, leftStart2 + leftView3.measuredWidth, leftView3.measuredHeight
        )
        //rightView位置
        val rightView1 = getRightView1()
        rightView1?.layout(
            measuredWidth - rightView1.measuredWidth, 0, measuredWidth, rightView1.measuredHeight
        )
        val rightEnd1 = measuredWidth - (rightView1?.measuredWidth ?: 0)
        val rightView2 = getRightView2()
        rightView2?.layout(
            rightEnd1 - rightView2.measuredWidth, 0,
            rightEnd1, rightView2.measuredHeight
        )
        val rightEnd2 = rightEnd1 - (rightView2?.measuredWidth ?: 0)
        val rightView3 = getRightView3()
        rightView3?.layout(
            rightEnd2 - rightView3.measuredWidth, 0,
            rightEnd2, rightView3.measuredHeight
        )
    }
}