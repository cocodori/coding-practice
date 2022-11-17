package playground.functionalkotlin.ch02

interface Box<T>
open class Language
open class JVM: Language()
class Kotlin: JVM()

val languageBox = object : Box<Language> {}
val jvmBox = object : Box<JVM> {}
val kotlinBox = object : Box<Kotlin> {}


fun main() {
    invariant(jvmBox)
    invariant(kotlinBox)
//    invariant(languageBox)
}

fun invariant(value: Box<out JVM>) {}