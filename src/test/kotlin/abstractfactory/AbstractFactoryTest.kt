package abstractfactory

import BaseTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class AbstractFactoryTest : BaseTest() {

    @Test
    fun `Given an AbstractFactory of FooProduct, When createProduct, Then factory and product are of expected type`() {
        // GIVEN
        val factory = AbstractFactory.createFactory<FooProduct>()

        // WHEN
        val product = factory.createProduct()

        // THEN
        factory shouldBeInstanceOf FooFactory::class
        product shouldBeInstanceOf FooProduct::class
    }

    @Test
    fun `Given an AbstractFactory of BarProduct, When createProduct, Then factory and product are of expected type`() {
        // GIVEN
        val factory = AbstractFactory.createFactory<BarProduct>()

        // WHEN
        val product = factory.createProduct()

        // THEN
        factory shouldBeInstanceOf BarFactory::class
        product shouldBeInstanceOf BarProduct::class
    }
}
