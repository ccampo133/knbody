package me.ccampo.knbody.core.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BodyTest {

    @Test
    fun isCollision_same_mass_true() {
        val b1 = Body(1.0, 2.0, Vector(1.0, 1.0), Vector.zero)
        val b2 = Body(1.0, 2.0, Vector(1.0, 1.0), Vector.zero)
        assertThat(b1 isCollision b2).isTrue()
        assertThat(b2 isCollision b1).isTrue()
    }

    @Test
    fun isCollision_same_mass_false() {
        val b1 = Body(1.0, 2.0, Vector(1.0, 1.0), Vector.zero)
        val b2 = Body(1.0, 2.0, Vector(10.0, 1.0), Vector.zero)
        assertThat(b1 isCollision b2).isFalse()
        assertThat(b2 isCollision b1).isFalse()
    }

    @Test
    fun isCollision_different_mass_true() {
        val b1 = Body(1.0, 2.0, Vector(1.0, 1.0), Vector.zero)
        val b2 = Body(10.0, 2.0, Vector(1.0, 1.0), Vector.zero)
        assertThat(b1 isCollision b2).isTrue()
        // Intentionally not symmetric in this case
        assertThat(b2 isCollision b1).isFalse()
    }

    @Test
    fun isCollision_different_mass_false() {
        val b1 = Body(1.0, 2.0, Vector(1.0, 1.0), Vector.zero)
        val b2 = Body(10.0, 2.0, Vector(10.0, 1.0), Vector.zero)
        assertThat(b1 isCollision b2).isFalse()
        assertThat(b2 isCollision b1).isFalse()
    }

    @Test
    fun empty() {
        val expected = Body(0.0, 0.0, Vector.zero, Vector.zero)
        assertThat(Body.empty).isEqualTo(expected)
    }
}
