open class Persona(val nombre: String, var edad: Int) {
    override fun toString(): String {
        return "Persona(nombre='$nombre', edad=$edad)"
    }

    fun celebrarCumple(): String {
        edad++
        return "¡Feliz cumpleaños, $nombre! Ahora tienes $edad años."
    }
}

open class Empleado(nombre: String, edad: Int, val salarioBase: Double, var porcentajeImpuestos: Double = 10.0):
    Persona(nombre, edad) {

    open fun calcularSalario(): Double {
        val impuestos = salarioBase * (porcentajeImpuestos / 100)
        return salarioBase - impuestos
    }

    fun trabajar(): String {
        return "$nombre está trabajando."
    }

    override fun toString(): String {
        return "${super.toString()}, Empleado(salarioBase=$salarioBase, porcentajeImpuestos=$porcentajeImpuestos%)"
    }
}

class Gerente(
    nombre: String,
    edad: Int,
    salarioBase: Double,
    var bonus: Double,
    var exentoImpuesto: Boolean = false
): Empleado(nombre, edad, salarioBase) {

    init {
        porcentajeImpuestos = 33.99
    }

    override fun calcularSalario(): Double {
        val salario = salarioBase + bonus
        if(exentoImpuesto){
            return salario
        }
        else
            return super.calcularSalario()
    }

    fun administrar(): String {
        return "$nombre está administrando."
    }

    override fun toString(): String {
        return "${super.toString()}, Gerente(bonus=$bonus, exentoImpuesto=$exentoImpuesto)"
    }
}

fun main() {
    val persona = Persona("Manuel", 30)
    println(persona)
    println(persona.celebrarCumple())

    val empleado = Empleado("Carlos", 25, 50000.0)
    println(empleado)
    println("Salario: ${empleado.calcularSalario()}")
    println(empleado.trabajar())

    val gerente = Gerente("Juan", 35, 80000.0, 20000.0, true)
    println(gerente)
    println("Salario: ${gerente.calcularSalario()}")
    println(gerente.administrar())
}
