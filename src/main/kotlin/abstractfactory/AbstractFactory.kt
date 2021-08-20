package abstractfactory

import kotlin.reflect.KClass

sealed class FactoryProduct
object FooProduct : FactoryProduct()
object BarProduct : FactoryProduct()

sealed class AbstractFactory {

    companion object {

        inline fun <reified T : FactoryProduct> createFactory(): AbstractFactory =
            when (T::class) {
                BarProduct::class -> BarFactory
                FooProduct::class -> FooFactory
                else -> throw TypeNotAllowedException(T::class)
            }
    }

    abstract fun createProduct(): FactoryProduct
}

object FooFactory : AbstractFactory() {
    override fun createProduct(): FactoryProduct =
        FooProduct
}

object BarFactory : AbstractFactory() {
    override fun createProduct(): FactoryProduct =
        BarProduct
}

class TypeNotAllowedException(type: KClass<*>) : Exception("This factory cannot create factories of type ${type.java}")
