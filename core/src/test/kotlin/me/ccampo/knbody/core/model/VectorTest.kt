package me.ccampo.knbody.core.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class VectorTest {

    @Test
    fun getLen() {
        val v1 = Vector(3.0, 4.0)
        // Expect sqrt(3^2 + 4^2) = 5
        assertThat(v1.len).isEqualTo(5.0)
    }

    @Test
    fun plus() {
        val v1 = Vector(3.0, 4.0)
        val v2 = Vector(1.0, 2.0)
        // Expect Vector(v1.x + v2.x, v1.y + v2.y) = Vector(4, 6)
        val expected = Vector(4.0, 6.0)
        assertThat(v1 + v2).isEqualTo(expected)
    }

    @Test
    fun minus() {
        val v1 = Vector(3.0, 5.0)
        val v2 = Vector(1.0, 2.0)
        // Expect Vector(v1.x - v2.x, v1.y - v2.y) = Vector(2, 3)
        val expected = Vector(2.0, 3.0)
        assertThat(v1 - v2).isEqualTo(expected)
    }

    @Test
    fun times() {
        val v1 = Vector(3.0, 5.0)
        val a = 10.0
        // Expect Vector(a * v1.x, a * v1.y) = Vector(30, 50)
        val expected = Vector(30.0, 50.0)
        assertThat(v1 * a).isEqualTo(expected)
    }

    @Test
    fun div() {
        val v1 = Vector(30.0, 50.0)
        val a = 10.0
        // Expect Vector(v1.x / a, v1.y / a) = Vector(3, 5)
        val expected = Vector(3.0, 5.0)
        assertThat(v1 / a).isEqualTo(expected)

    }

    @Test
    fun dot() {
        val v1 = Vector(3.0, 4.0)
        val v2 = Vector(1.0, 2.0)
        // Expect (v1.x * v2.x) + (v1.y * v2.y) = 11
        val expected = 11.0
        assertThat(v1 dot v2).isEqualTo(expected)
    }

    @Test
    fun zero() {
        assertThat(Vector.zero).isEqualTo(Vector(0.0, 0.0))
    }
}
