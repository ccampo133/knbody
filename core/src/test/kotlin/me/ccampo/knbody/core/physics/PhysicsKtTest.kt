package me.ccampo.knbody.core.physics

import me.ccampo.knbody.core.model.Body
import me.ccampo.knbody.core.model.Vector
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Percentage
import org.junit.Test

class PhysicsKtTest {

    @Test
    fun verlet_constant_accel() {
        val x = Vector(1.0, 2.0)
        val v = Vector(5.0, 5.0)
        val dt = 1.0
        // Constant acceleration as a function of position
        val a: (Vector) -> Vector = { pos -> pos * 2.0 }
        val result = verlet(x, v, dt, a)
        /*
         * Expect a Vector(x1, v1) where:
         * x1 = (x + (v * dt)) + (a(x) * (dt^2 / 2))
         * v1 = v + ((a(x) + a(x1)) * (dt / 2))
         *
         * Which in this case equals (trust me):
         * x1 = Vector(7, 9)
         * v1 = Vector(13, 16)
         */
        val expected = Pair(Vector(7.0, 9.0), Vector(13.0, 16.0))
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun gravityAcceleration() {
        val x1 = Vector(1.0, 1.0)
        val x2 = Vector(10.0, 1.0)
        val b1 = Body(10.0, 5.0, x1, Vector.zero)
        val b2 = Body(100.0, 5.0, x2, Vector.zero)
        val bodies = setOf(b1, b2)
        // This will be Newton's Law of Gravity: a = G * m2 / r^2
        val result = gravityAcceleration(x1, bodies)
        assertThat(result.y).isZero()
        assertThat(result.x).isCloseTo(1.1484553649, Percentage.withPercentage(0.00001))
    }
}
