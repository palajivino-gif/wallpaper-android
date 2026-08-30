package com.palajivino.danzy.data

import com.palajivino.danzy.R
import com.palajivino.danzy.model.Categories
import com.palajivino.danzy.model.Wallpaper

/**
 * Single source of truth for the wallpaper catalog.
 *
 * All images are local drawables in res/drawable-nodpi (wallpaper_1 .. wallpaper_12).
 * Replace the placeholder drawables with your own images of the same name,
 * or add new entries here pointing at your drawable resource ids.
 */
object WallpaperRepository {

    private val wallpapers: List<Wallpaper> = listOf(
        Wallpaper("w1", "Aurora Peak", Categories.NATURE, R.drawable.wallpaper_1),
        Wallpaper("w2", "Crystal Flow", Categories.ABSTRACT, R.drawable.wallpaper_2),
        Wallpaper("w3", "Emerald Orbit", Categories.AMOLED, R.drawable.wallpaper_3),
        Wallpaper("w4", "Emerald Falls", Categories.NATURE, R.drawable.wallpaper_4),
        Wallpaper("w5", "Summit Path", Categories.MOTIVATION, R.drawable.wallpaper_5),
        Wallpaper("w6", "Ringed Horizon", Categories.SPACE, R.drawable.wallpaper_6),
        Wallpaper("w7", "Infinite Galaxy", Categories.SPACE, R.drawable.wallpaper_7),
        Wallpaper("w8", "Neon Crossing", Categories.AMOLED, R.drawable.wallpaper_8),
        Wallpaper("w9", "Canyon Dawn", Categories.NATURE, R.drawable.wallpaper_9),
        Wallpaper("w10", "Arc Matrix", Categories.ABSTRACT, R.drawable.wallpaper_10),
        Wallpaper("w11", "Rise Beyond", Categories.MOTIVATION, R.drawable.wallpaper_11),
        Wallpaper("w12", "Velvet Waves", Categories.ABSTRACT, R.drawable.wallpaper_12)
    )

    /** All wallpapers in the catalog. */
    fun getWallpapers(): List<Wallpaper> = wallpapers

    /** Find one wallpaper by its stable id. */
    fun getById(id: String): Wallpaper? = wallpapers.firstOrNull { it.id == id }
}
