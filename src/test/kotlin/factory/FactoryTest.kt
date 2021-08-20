package factory

import BaseTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val testData = 9
private const val testDataOne = "testDataOne"
private const val testDataTwo = 2

class FactoryTest : BaseTest() {

    private lateinit var testSubject: Factory

    @BeforeEach
    fun setUp() {
        testSubject = Factory()
    }

    @Test
    fun `Given a FooObject, When Bar requested from Factory, Then expected Bar returned`() {
        // GIVEN
        val foo = FooObject
        val expected = ObjectBar

        // WHEN
        val actual = testSubject.createAppropriateBar(foo)

        // THEN
        actual shouldBeEqualTo expected
    }

    @Test
    fun `Given a FooClass, When Bar requested from Factory, Then expected Bar returned`() {
        // GIVEN
        val foo = FooClass(data = testData)
        val expected = ClassBar

        // WHEN
        val actual = testSubject.createAppropriateBar(foo)

        // THEN
        actual shouldBeEqualTo expected
    }

    @Test
    fun `Given a FooDataClass, When Bar requested from Factory, Then expected Bar returned`() {
        // GIVEN
        val foo = FooDataClass(dataOne = testDataOne, dataTwo = testDataTwo)
        val expected = DataClassBar

        // WHEN
        val actual = testSubject.createAppropriateBar(foo)

        // THEN
        actual shouldBeEqualTo expected
    }
}
