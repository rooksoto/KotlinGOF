package factory

sealed class Foo
object FooObject : Foo()
class FooClass(val data: Int) : Foo()
data class FooDataClass(val dataOne: String, val dataTwo: Int) : Foo()

sealed class Bar
object ObjectBar : Bar()
object ClassBar : Bar()
object DataClassBar : Bar()

class Factory {

    fun createAppropriateBar(
        foo: Foo
    ): Bar = when (foo) {
        FooObject -> ObjectBar
        is FooClass -> ClassBar
        is FooDataClass -> DataClassBar
    }
}
