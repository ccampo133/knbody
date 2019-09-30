package me.ccampo.knbody.core.util

import kotlin.math.abs

/**
 * True if a point lies outside more than twice the length/width of some rectangular area.
 */
fun isWayOutOfBounds(x: Double, y: Double, width: Int, height: Int): Boolean {
    return abs(x) > 2 * width || abs(y) > 2 * height
}
