package me.ccampo.knbody.core.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.Test
import kotlin.test.BeforeTest

class SimulationContextTest {

    lateinit var context: SimulationContext

    @BeforeTest
    fun setUp() {
        val dt = 0.01
        context = SimulationContext(dt)
    }

    @Test
    fun run() {
        val b1 = Body(1.0, 2.0, Vector.zero, Vector.zero)
        val b2 = Body(3.0, 4.0, Vector.zero, Vector(10.0, 20.0)) // Non-zero initial velocity
        val bodies = setOf(b1, b2)
        context = SimulationContext(2.0, bodies)
        assertThat(context.bodies).isEqualTo(bodies)
        context.run()
        val b3 = b2.copy(x = Vector(20.0, 40.0))
        assertThat(context.bodies).containsOnly(b3)
    }

    @Test
    fun clear() {
        val bodies = setOf(
                Body(1.0, 2.0, Vector.zero, Vector.zero),
                Body(3.0, 4.0, Vector.zero, Vector.zero)
        )
        context = SimulationContext(0.01, bodies)
        assertThat(context.bodies).isEqualTo(bodies)
        assertThat(context.removedBodies).isEmpty()
        context.clear()
        assertThat(context.bodies).isEmpty()
        assertThat(context.removedBodies).isEmpty()
    }

    @Test
    fun reset() {
        val bodies = setOf(
                Body(1.0, 2.0, Vector.zero, Vector.zero),
                Body(3.0, 4.0, Vector.zero, Vector.zero)
        )
        context = SimulationContext(0.01, bodies)
        val b3 = Body(5.0, 6.0, Vector.zero, Vector.zero)
        context.addBody(b3)
        assertThat(context.bodies).isEqualTo(bodies + b3)
        assertThat(context.removedBodies).isEmpty()
        context.reset()
        assertThat(context.bodies).isEqualTo(bodies)
        assertThat(context.removedBodies).isEmpty()
    }

    @Test
    fun clearPositionHistory() {
        val bodies = setOf(
                Body(1.0, 2.0, Vector.zero, Vector.zero, listOf(Vector.zero)),
                Body(3.0, 4.0, Vector.zero, Vector.zero, listOf(Vector.zero))
        )
        context = SimulationContext(0.01, bodies)
        context.clearPositionHistory()

        val softly = SoftAssertions()
        context.bodies.forEach { softly.assertThat(it.positions).isEmpty() }
        softly.assertAll()
    }

    @Test
    fun addBody() {
        assertThat(context.bodies).isEmpty()
        val body = Body(1.0, 2.0, Vector.zero, Vector.zero)
        context.addBody(body)
        assertThat(context.bodies).containsOnly(body)
    }
}
