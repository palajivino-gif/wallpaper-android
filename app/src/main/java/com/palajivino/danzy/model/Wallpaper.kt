package com.palajivino.danzy.model

import androidx.annotation.DrawableRes

/**
 * A single wallpaper backed by a local drawable resource.
 *
 * @param id        Stable unique id, used as the favorites key.
 * @param title     Display title.
 * @param category  One of [Categories].
 * @param resId     Drawable resource id of the local image.
 */
data class Wallpaper(
    val id: String,
    val title: String,
    val category: String,
    @param:DrawableRes @field:DrawableRes val resId: Int
)

/** A wallpaper paired with its current favorite state for the UI/adapter. */
data class WallpaperUi(
    val wallpaper: Wallpaper,
    val isFavorite: Boolean
)

/** Category labels. Keep in sync with strings.xml category names. */
object Categories {
    const val ALL = "All"
    const val NATURE = "Nature"
    const val ABSTRACT = "Abstract"
    const val AMOLED = "AMOLED"
    const val MOTIVATION = "Motivation"
    const val SPACE = "Space"

    /** Order shown in the chip bar (ALL first). */
    val ALL_ORDERED = listOf(ALL, NATURE, ABSTRACT, AMOLED, SPACE, MOTIVATION)
}
