package singleton

import BaseTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class SingletonTest : BaseTest() {

    @Test
    fun `Given 2 vars pointing to Singleton, When compared for equality, Then vars evaluate to equal`() {
        // GIVEN
        val singletonOne = Singleton
        val singletonTwo = Singleton
        // WHEN // THEN
        singletonOne shouldBeEqualTo singletonTwo
    }

    @Test
    fun `Given 2 vars created from Singleton init method, When compared for equality, Then vars evaluate to equal`() {
        // GIVEN
        val singletonOne = Singleton.getSingletonInstance()
        val singletonTwo = Singleton.getSingletonInstance()
        // WHEN // THEN
        singletonOne shouldBeEqualTo singletonTwo
    }
}