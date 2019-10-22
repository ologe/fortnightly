@file:Suppress("NOTHING_TO_INLINE")

package dev.olog.fortnightly.presentation.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.Px
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

inline fun View.setGone() {
    this.visibility = View.GONE
}

inline fun View.setVisible() {
    this.visibility = View.VISIBLE
}

inline fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.setHeight(@Px heightPx: Int) {
    val params = this.layoutParams
    when (params) {
        is FrameLayout.LayoutParams -> params.height = heightPx
        is LinearLayout.LayoutParams -> params.height = heightPx
        is RelativeLayout.LayoutParams -> params.height = heightPx
        is CoordinatorLayout.LayoutParams -> params.height = heightPx
        is ConstraintLayout.LayoutParams -> params.height = heightPx
    }
    layoutParams = params
}

fun View.setWidth(@Px heightPx: Int) {
    val params = this.layoutParams
    when (params) {
        is FrameLayout.LayoutParams -> params.width = heightPx
        is LinearLayout.LayoutParams -> params.width = heightPx
        is RelativeLayout.LayoutParams -> params.width = heightPx
        is CoordinatorLayout.LayoutParams -> params.width = heightPx
        is ConstraintLayout.LayoutParams -> params.width = heightPx
    }
    layoutParams = params
}

fun View.setMargin(
    @Px left: Int = marginLeft,
    @Px top: Int = marginTop,
    @Px right: Int = marginRight,
    @Px bottom: Int = marginBottom
) {
    val params = this.layoutParams as? ViewGroup.MarginLayoutParams ?: return
    params.topMargin = top
    params.leftMargin = left
    params.rightMargin = right
    params.bottomMargin = bottom
    layoutParams = params
}