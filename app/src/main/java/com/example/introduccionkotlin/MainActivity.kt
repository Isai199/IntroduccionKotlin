package com.example.introduccionkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.introduccionkotlin.ui.theme.IntroduccionKotlinTheme

class MainActivity : ComponentActivity() {
    companion object {
        const val moneda = "EUR"
    }
    var saldo : Float = 300.54F
    var sueldo : Float = 764.82F
    var entero : Int = 62

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fecha = "01/05/1990"
        //           0123456789  es el indice de la cadena fecha, y siempre se empiesa por 0
        var nombre : String = "jota"
        var vip: Boolean = false
        var inicial: Char = 'J'

        var saludo = "Hola " + saldo.toString()

        /* OPERADORES DE CALCULO
        var a: Int = 5 + 5 // 10
        var b: Int = 10 - 2 // 8
        var c: Int = 3 * 4 // 12
        var d: Int = 10 / 5 // 2
        var e: Int = 10 % 3 // 1, No se puede dividir, se queda con el resto
        var f: Int = 10 / 6 // 1, divicion infinita, solo se mantiene la parte entera

        var aPreIncremento: Int = 5
        var bPreDecremento: Int = 5
        var cPosIncremento: Int = 5
        var dPostDecremento: Int = 5

        println(aPreIncremento)
        println(++aPreIncremento) // Incrementa primero, luego regresa
        println(aPreIncremento)

        println(bPreDecremento)
        println(--aPreIncremento)
        println(bPreDecremento)

        println(cPosIncremento)
        println(cPosIncremento++) // Primero regresa, luego incrementa
        println(cPosIncremento)

        println(dPostDecremento)
        println(dPostDecremento--)
        println(dPostDecremento)
         */

        /* OPERADORES DE COMPARACION
        a == b
        a != b
        a > b
        a < b
        a >= b
        a <= b
        */


        /* OPERADORES LOGICOS
        var a: Boolean = true
        var b: Boolean = true
        var c: Boolean = false
        var d: Boolean = false

        a && b  // && = AND
        a || b  // || = OR

        a && c
        a && c

        !d // ! = NEGACION
        */

        // If Else
        if (vip == true) saludo += ", te queremos mucho"
        else saludo += ", quieres ser vip? paga la cuota"

        mostrar_saldo()

        var dia = fecha.subSequence(0, 2).toString().toInt()
        if (dia == 1) ingresar_sueldo()


        // When
        var mes = fecha.subSequence(3, 5).toString().toInt()
        when(mes) {
            1 -> print("\n En Enero hay super oferta del 7% de interes")
            2, 3 -> print("\n En invierno no hay ofertas de inversiones")
            4, 5, 6 -> print("\n En primavera hay ofertas de inverciones con el 1.5% de interes")
            7, 8, 9 -> print("\n En verano hay ofertas de inversiones con el 2.5% de interes")
            10, 11, 12 -> print("\n En otoño hay ofertas de inversiones con el 3.5% de interes")
            else -> print("\n La fecha es erronea")
        }
        println(saludo)

        // Do While
        var pin: Int = 1234
        var intentos: Int = 0
        var clave_ingresada: Int = 1232

        do {
            println("Ingrese el PIN: ")
            println("Clave ingresada:  ${++clave_ingresada}")
            if (clave_ingresada == pin) break
            intentos++
        } while (intentos < 3 && clave_ingresada != pin)

        if (intentos == 3) println("Tarjeta Bloqueada")

        mostrar_saldo()
        ingresar_dinero(50.5F)
        retirar_dinero(40F)
        retirar_dinero(50F)
//        retirar_dinero(2000F)

        // Array y matriz
        var recibos: Array<String> = arrayOf("luz", "agua", "gas")

        recorrer_array(recibos)

        var matriz = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6,7,8,9,10),
            intArrayOf(11,12,13,14)
        )

        for (i in (0 until matriz.size)) {
            println()
            for (j in (0 until matriz[i].size))
                println("Posicion[$i][$j] : ${matriz[i][j]}")
        }

        // COLECCIONES
        var clientesVip: Set<Int> = setOf(1234, 5678, 4040)
        val setMezclado = setOf(2, 4.454, "casa", 'c')

        println("Clientes Vip")
        println(clientesVip)
        println("Numero de clientes Vip: ${clientesVip.size}")

        if (clientesVip.contains(1234)) println("1234 es VIP")
        if (clientesVip.contains(1235)) println("1235 es VIP")

        var clientes: MutableSet<Int> = mutableSetOf(1234, 5678, 4040, 8970)
        println("Clientes:")
        println(clientes)

        clientes.add(3026)
        println(clientes)

        clientes.remove(5678)
        println(clientes)

        clientes.clear()
        println(clientes)

        println("Numero de clientes: ${clientes.size}")

        var divisas: List<String> = listOf("USD", "EUR", "YEN")
        println(divisas)
        divisas.first()

        // recorrer_list(divisas)

        var bolsa: MutableList<String> = mutableListOf("Coca-cola", "Adidas", "Amazon", "Pfizer")
        println(bolsa)

        bolsa.add("Adobe")
        println(bolsa)

        bolsa.add("Nvidia")
        println(bolsa)

        bolsa.removeAt(2)
        println(bolsa)

        println(bolsa.first())
        println(bolsa.last())
        println(bolsa.elementAt(2))
        println(bolsa.none())

        println(bolsa.firstOrNull())
        //bolsa.clear()
        println(bolsa)

        println(bolsa.none())
        println(bolsa.firstOrNull())

        var mapa: Map<Int, String> = mapOf(
            1 to "España",
            2 to "Mexico",
            3 to "Colombia"
        )

        println(mapa)

        var inversiones = mutableMapOf<String, Float>()
        println(inversiones)

        var empresa: String? = null
        mostrar_saldo()
        var cantidad_a_invertir = 90F
        var index = 0

        while (saldo >= cantidad_a_invertir) {
            empresa = bolsa.elementAtOrNull(index)
            if (empresa != null) {
                saldo -= cantidad_a_invertir
                println("Se ha invertido $cantidad_a_invertir $moneda en $empresa")

                inversiones.put(empresa, cantidad_a_invertir)
            }
            else break
            index++
        }

        mostrar_saldo()

        /* PIRMER EJERCICIO
        var cuenta_regresiva = 9

        do {

            println(cuenta_regresiva)

            cuenta_regresiva--

        } while ( cuenta_regresiva >= 0)
        */

        /*SEGUNDO EJECICIO
        var numero = 0

        while (numero <= 10) {
            if (numero % 2 == 0 && numero != 0) {
                println(numero)
            }
            numero++
        }
         */

        /*TERCER EJERCICIO
        var platillos: Array<String> = arrayOf("tamales", "enchiladas", "pozole", "corundas")
        println("Platillos de comida mexicana")
        for (i in platillos) {
            println(i)
        }
         */

        /*CUARTO EJERCICIO
        var platillos: MutableMap<String, Int> = mutableMapOf(
            "tamales" to 10,
            "enchiladas" to 22,
            "pozole" to 45,
            "corundas" to 12
        )
        var tipo_moneda = "MEX"

        println("Menu comida mexicana")
        for (i in platillos) {
            println("${i.key} a ${i.value} $tipo_moneda ")
        }
         */

        /* QUINTO EJERCICIO
        var platillos = arrayOf(
            arrayOf("tamales", 10, arrayOf("hoja de maiz", "masa", "carne")),
            arrayOf("enchiladas", 22, arrayOf("tortilla", "chile rojo", "queso")),
            arrayOf("pozole", 45, arrayOf("maiz", "pollo", "verduras")),
            arrayOf("corundas", 12, arrayOf("masa", "hoja de platano", "crema", "salsa roja")),
        )
        val tipo_moneda = "MEX"

        println(platillos.size)
        println("Menu comida mexicana")
        for (i in (0 until platillos.size)) {
            for (j in (0 until  platillos[i].size)) {
                when(j) {
                    0 -> println("Platillo: ${platillos[i][j]}")
                    1 -> println("Precio: ${platillos[i][j]} $tipo_moneda")
                    2 -> {
                        var ingredientes = platillos[i][j] as Array<String>
                        println("Ingredientes:")
                        for (k in (0 until ingredientes.size)) {
                            println("${k + 1}.- ${ingredientes[k]}")
                        }
                    }
                }
            }
        }
         */

        setContent {
            IntroduccionKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    fun mostrar_saldo() {
        println("Tienes $saldo $moneda")
    }

    fun ingresar_sueldo() {
        saldo += sueldo
        println("Se ha ingresado tu sueldo de $sueldo $moneda")
        mostrar_saldo()
    }

    fun ingresar_dinero(cantidad: Float) {
        saldo += cantidad
        println("Se ha ingresado $cantidad $moneda")
        mostrar_saldo()
    }

    fun retirar_dinero(cantidad: Float) {
        if (verificarCantidad(cantidad)) {
            saldo -= cantidad
            println("Se ha echo una retirada $cantidad $moneda")
            mostrar_saldo()
        }
        else println("Cantidad superior al saldo. Imposible realizar la operación")
    }

    fun verificarCantidad(cantidad_a_retirar: Float): Boolean {
        if (cantidad_a_retirar > saldo) return false
        else return true
    }

    fun recorrer_array(array: Array<String>) {
        for (i in array)
            println(i)
        for (i in array.indices)
            println(array.get(i))
        for (i in 0 .. array.size -1)
            println("${i+1}: ${array.get(i)}")
    }

    fun recorrer_list(list: List<String>) {
        println("Uso de list")
        for (i in list)
            println(i)
        for (i in list.indices)
            println(list.get(i))
        for (i in 0 .. list.size -1)
            println("${i+1}: ${list.get(i)}")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroduccionKotlinTheme {
        Greeting("Android")
    }
}