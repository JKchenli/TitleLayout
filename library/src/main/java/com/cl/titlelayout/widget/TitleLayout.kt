package com.cl.titlelayout.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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

    private val leftLayout: LinearLayout = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        setBackgroundColor(Color.YELLOW)
    }
    private val rightLayout: LinearLayout = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        setBackgroundColor(Color.RED)
    }
    private val titleLayout: FrameLayout = FrameLayout(context).apply {
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        setBackgroundColor(Color.GREEN)
    }

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
        addView(titleLayout)
        addView(leftLayout)
        addView(rightLayout)
        addTitleView()
        addLeftLayoutView()
        addRightLayoutView()
        attr.recycle()
    }

    private fun addTitleView() {
        if (titleText != null) {
            addTitleTextView()
        } else if (titleIcon != null) {
            addTitleIconView()
        }
    }

    private fun buildTextView(): TextView {
        return TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
                50,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun buildIconView(): ImageView {
        return ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
                50,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun addLeftLayoutView() {
        if (leftIcon1 != null) {
            leftIconView1 = buildIconView().apply {
                setImageDrawable(leftIcon1)
            }
            leftLayout.addView(leftIconView1)
        } else if (leftText1 != null) {
            leftTextView1 = buildTextView().apply {
                text = leftText1
            }
            leftLayout.addView(leftTextView1)
        }
        if (leftIcon2 != null) {
            leftIconView2 = buildIconView().apply {
                setImageDrawable(leftIcon2)
            }
            leftLayout.addView(leftIconView2)
        } else if (leftText2 != null) {
            leftTextView2 = buildTextView().apply {
                text = leftText2
            }
            leftLayout.addView(leftTextView2)
        }
        if (leftIcon3 != null) {
            leftIconView3 = buildIconView().apply {
                setImageDrawable(leftIcon3)
            }
            leftLayout.addView(leftIconView3)
        } else if (leftText3 != null) {
            leftTextView3 = buildTextView().apply {
                text = leftText3
            }
            leftLayout.addView(leftTextView3)
        }
    }

    private fun addRightLayoutView() {
        if (rightIcon1 != null) {
            rightIconView1 = buildIconView().apply {
                setImageDrawable(rightIcon1)
            }
            rightLayout.addView(rightIconView1)
        } else if (rightText1 != null) {
            rightTextView1 = buildTextView().apply {
                text = rightText1
            }
            rightLayout.addView(rightTextView1)
        }
        if (rightIcon2 != null) {
            rightIconView2 = buildIconView().apply {
                setImageDrawable(rightIcon2)
            }
            rightLayout.addView(rightIconView2)
        } else if (rightText2 != null) {
            rightTextView2 = buildTextView().apply {
                text = rightText2
            }
            rightLayout.addView(rightTextView2)
        }
        if (rightIcon3 != null) {
            rightIconView3 = buildIconView().apply {
                setImageDrawable(rightIcon3)
            }
            rightLayout.addView(rightIconView3)
        } else if (rightText3 != null) {
            rightTextView3 = buildTextView().apply {
                text = rightText3
            }
            rightLayout.addView(rightTextView3)
        }
    }

    private fun addTitleIconView() {
        titleIconView = ImageView(context).apply {
            setImageDrawable(titleIcon)
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            ).apply {
                gravity = Gravity.CENTER
            }
        }
        titleLayout.addView(titleIconView)
    }

    private fun addTitleTextView() {
        titleTextView = TextView(context).apply {
            text = titleText
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            ).apply {
                gravity = Gravity.CENTER
            }
        }
        titleLayout.addView(titleTextView)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)

        measureChildren(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(sizeWidth, sizeHeight)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun onLayout(change: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        titleLayout.layout(
            (measuredWidth - titleLayout.measuredWidth) / 2,
            0,
            (measuredWidth + titleLayout.measuredWidth) / 2,
            titleLayout.measuredHeight
        )
        rightLayout.layout(
            measuredWidth - rightLayout.measuredWidth,
            0,
            measuredWidth,
            rightLayout.measuredHeight
        )
        leftLayout.layout(0, 0, rightLayout.measuredWidth, rightLayout.measuredHeight)
    }
}