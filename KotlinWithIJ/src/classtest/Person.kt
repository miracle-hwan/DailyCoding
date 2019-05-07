package classtest

fun main() {
//    val person = Person("화니", Person("당당"))
//    person.allByDefault?.also { println(it) }

    val user = User("화니", 28)
    val (name, age) = user
    println("$name. $age years of age")

    var adHoc = object {
        var x: Int = 0
        var y: Int = 1
    }
    println(adHoc.x + adHoc.y)
}

class Person(val name: String){

    val allByDefault: Int?
        get() = null

    override fun toString(): String {
        return "name : $name";
    }

    init {
        println("Init block $name")
    }

    constructor(name: String, parent: Person) : this(name) {
        println("name is $name, parent is {${parent.toString()}}")
    }
}