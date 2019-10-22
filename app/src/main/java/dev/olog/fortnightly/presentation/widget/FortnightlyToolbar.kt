package dev.olog.fortnightly.presentation.widget

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import dev.olog.fortnightly.R
import dev.olog.fortnightly.presentation.extensions.clamp
import dev.olog.fortnightly.presentation.extensions.colorPrimary
import dev.olog.fortnightly.presentation.extensions.dipf
import dev.olog.fortnightly.presentation.extensions.setMargin
import dev.olog.fortnightly.utils.lazyFast
import kotlin.math.abs
import kotlin.properties.Delegates

class FortnightlyToolbar(
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs) {

    private val interpolation = AccelerateInterpolator(5f)

    private val searchView by lazyFast { findViewById<View>(R.id.search) }

    private val header1 by lazyFast { findViewById<View>(R.id.header1) } // 'The '
    private val header2 by lazyFast { findViewById<View>(R.id.header2) } // 'F'
    private val header3 by lazyFast { findViewById<View>(R.id.header3) } // 'ortnightly'
    private val headerPlaceholder by lazyFast { findViewById<View>(R.id.headerPlaceholder) } // final position

    private val maxAllowedRadius: Float by lazyFast { height / 2f }
    private val scrimTranslation: Float by lazyFast { right.toFloat() - headerPlaceholder.right.toFloat() }
    private val header2Translation: Float by lazyFast { abs(headerPlaceholder.left.toFloat() - header2.left.toFloat()) }

    private val shape = ShapeAppearanceModel.builder()
        .setBottomRightCorner(CornerFamily.CUT, context.dipf(0))

    private val drawable = MaterialShapeDrawable(shape.build()).apply {
        this.tintList = ColorStateList.valueOf(context.colorPrimary())
    }

    // keep track of all scroll
    private var allMovement = 0f
    private var radius by Delegates.observable(0f) { _, old, new ->

        if (abs(old - new) < 0.001f) {
            return@observable
        }
        drawable.shapeAppearanceModel = shape.setBottomRightCorner(CornerFamily.CUT, new).build()

        // when 'new' is low, 'ratio' will be near 0
        val ratio = new / maxAllowedRadius
        // when 'new' is low, 'invertedRatio' will be near 1
        val invertedRatio = 1f - ratio

        val accelerated = interpolation.getInterpolation(invertedRatio)
        searchView.alpha = accelerated
        header1.alpha = accelerated
        header3.alpha = accelerated

        val translation = -(header2Translation * ratio)
        header1.translationX = translation
        header2.translationX = translation
        header3.translationX = translation

        setMargin(right = (scrimTranslation * ratio).toInt())
    }

    init {
        if (!isInEditMode) {
            background = drawable
        }
    }

    /**
     * @param amount is positive when scrolling down
     */
    fun translate(amount: Int) {
        allMovement += amount
        radius = clamp(allMovement, 0f, maxAllowedRadius)
    }


}