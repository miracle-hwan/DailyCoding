package com.miraclehwan.threadtest

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BulletSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView

//import net.nrise.wippy.commonUI.widget.ShadowView.Companion.px
//import net.nrise.wippy.util.spannable.PaddingBackgroundColorSpan

/**
 * EasySpannableString
 *
 * @param fullText 전체 텍스트
 *
 *
 * example)
 *   EasySS("테스트 입니다")
 *       .setSpanTargetText("테스트")
 *       .setSpanTextColor(Color.RED)
 *       .setSpanTextBold()
 *       .setSpanTargetText("입니다")
 *       .setSpanTextColor(Color.BLUE)
 *       .into(testtest)
 */
class EasySS(private val fullText: String) {

    private class Span(
        val what: Any,
        val start: Int,
        val end: Int,
        val flags: Int
    )

    private val ssBuilder = SpannableStringBuilder(fullText)

    private var spanTargetText: String? = null

    private val spanItemList = mutableListOf<Span>()

    fun getFullText() = fullText

    /**
     * 데코레이션할 텍스트 지정
     * @param targetString 데코레이션할 일부분 텍스트
     */
    fun setSpanTargetText(targetString: String): EasySS {
        spanTargetText = targetString
        return this
    }

    fun getSpanStartIndex(): Int {
        return spanTargetText?.let {
            fullText.indexOf(it)
        } ?: throw IllegalAccessException("spanTargetText is null")
    }

    fun getSpanEndIndex(): Int {
        return spanTargetText?.let {
            getSpanStartIndex() + it.length
        } ?: throw IllegalAccessException("spanTargetText is null")
    }

    fun setBoldSpan(start: Int, end: Int): EasySS {
        spanItemList.add(
            Span(
                StyleSpan(Typeface.BOLD),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setFullTextBold(): EasySS {
        spanItemList.add(
            Span(
                StyleSpan(Typeface.BOLD),
                0,
                fullText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setSpanTextBold(): EasySS {
        spanItemList.add(
            Span(
                StyleSpan(Typeface.BOLD),
                getSpanStartIndex(),
                getSpanEndIndex(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setColorSpan(start: Int, end: Int, color: Int): EasySS {
        spanItemList.add(
            Span(
                ForegroundColorSpan(color),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setFullTextColor(color: Int): EasySS {
        spanItemList.add(
            Span(
                ForegroundColorSpan(color),
                0,
                fullText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setSpanTextColor(color: Int): EasySS {
        spanItemList.add(
            Span(
                ForegroundColorSpan(color),
                getSpanStartIndex(),
                getSpanEndIndex(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setSpanTextClick(clickableSpan: ClickableSpan): EasySS {
        spanItemList.add(
            Span(
                clickableSpan,
                getSpanStartIndex(),
                getSpanEndIndex(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
        return this
    }

    fun setBulletText(gapWitdh: Int = 50) {
        spanItemList.add(
            Span(
                BulletSpan(gapWitdh),
                getSpanStartIndex(),
                getSpanEndIndex(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        )
    }

//    fun setSpanTextBackgroundColor(color: Int, padding: Int = 2): EasySS {
//        spanItemList.add(Span(PaddingBackgroundColorSpan(color, padding.px.toInt()), getSpanStartIndex(), getSpanEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE))
//        return this
//    }

    /**
     * @param textView targetView
     */
    fun into(textView: TextView) {
        if (spanItemList.isEmpty()) {
            throw IllegalAccessException("spanItemList is Empty. Do not use this class.")
        }
        spanItemList.forEach { span ->
            ssBuilder.setSpan(span.what, span.start, span.end, span.flags)
        }
        textView.text = ssBuilder
    }
}