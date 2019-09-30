package me.ccampo.knbody.core.util

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


class UtilFunctionsKtTest {

    @Test
    fun isWayOutOfBounds_x_true() {
        val x = 1000.0
        val y = 20.0
        val width = 100
        val height = 100
        val result = isWayOutOfBounds(x, y, width, height)
        assertThat(result).isTrue()
    }

    @Test
    fun isWayOutOfBounds_y_true() {
        val x = 20.0
        val y = 1000.0
        val width = 100
        val height = 100
        val result = isWayOutOfBounds(x, y, width, height)
        assertThat(result).isTrue()
    }

    @Test
    fun isWayOutOfBounds_x_and_y_true() {
        val x = 1000.0
        val y = 1000.0
        val width = 100
        val height = 100
        val result = isWayOutOfBounds(x, y, width, height)
        assertThat(result).isTrue()
    }

    @Test
    fun isWayOutOfBounds_x_and_y_false() {
        val x = 50.0
        val y = 20.0
        val width = 100
        val height = 100
        val result = isWayOutOfBounds(x, y, width, height)
        assertThat(result).isFalse()
    }
}
