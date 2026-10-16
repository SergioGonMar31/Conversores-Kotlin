import java.math.BigDecimal
import java.math.RoundingMode

class Conversor {
    val dolar=1.08;
    val libra=0.86;
    val yen=163.0;
    val francoSuizo=0.95;

    fun comenzar() {
        var salir = false;
        while (!salir){
            val seleccion = Depurar.leerInt(menu());
            when (seleccion) {
                1 ->divisas();
                2 ->distancias();
                3 ->temperaturas();
                4 ->salir = true;
                else -> print("Opción no válida.")
            }
        }
        print("\nconversor Cerrado.")
    }

    // Funciones con menus para cada tipo de conversion
    fun divisas() {

            var salir = false;
            while (!salir){
                val seleccion = Depurar.leerInt(menuDivisas());
                when (seleccion) {
                    1 ->print("El resultado es ${formateo(operacionDivisas(dolar))} dolares \n")
                    2 ->print("El resultado es ${formateo(operacionDivisas(libra))} libras \n")
                    3 ->print("El resultado es ${formateo(operacionDivisas(yen))} yenes \n")
                    4 ->print("El resultado es ${formateo(operacionDivisas(francoSuizo))} francos suizos \n")
                    5 -> salir = true;
                    else -> print("Opción no válida.")
                }
            }

    }
    fun distancias() {
            var salir = false;
            while (!salir){
                val seleccion = Depurar.leerInt(menuDistancias());
                when (seleccion) {
                    1 -> {
                        val km = Depurar.leerDecimal("Dime los kilometros: ")
                        val m = km*1000;
                        print("${km} kilómetros equivalen a ${formateo(m)} metros.")
                    }
                    2 -> {
                        val m = Depurar.leerDecimal("Dime los metros: ")
                        val km = m/1000;
                        print("${m} metros equivalen a ${formateo(km)} kilometros.")
                    }
                    3 -> {
                        val km = Depurar.leerDecimal("Dime los kilometros: ")
                        val millas = km*0.6213;
                        print("${km} kilómetros equivalen a ${formateo(millas)} millas.")
                    }
                    4 -> {
                        val millas = Depurar.leerDecimal("Dime las millas: ")
                        val km = millas/0.6213;
                        print("${millas} millas equivalen a ${formateo(km)} kilometros.")
                    }
                    5 -> {
                        val cm = Depurar.leerDecimal("Dime los centimetros: ")
                        val metros = cm/100;
                        print("${cm} centimetros equivalen a ${formateo(metros)} metros.")
                    }
                    6 -> salir = true;
                    else -> print("Opción no válida.")
                }
            }
    }

    fun temperaturas() {
            var salir = false;
            while (!salir){
                val seleccion = Depurar.leerInt(menuTemperatura());
                when (seleccion) {
                    1 -> {
                        val celsius = Depurar.leerDecimal("Dime los grados celsius: ")
                        val fahrenheit = celsius * 9 / 5 + 32
                        print("${celsius} grados Celcius equivalen a ${formateo(fahrenheit)} grados Farenheit.")
                    }
                    2 -> {
                        val fahrenheit = Depurar.leerDecimal("Dime los grados Farenheit: ")
                        val Celsius = (fahrenheit - 32) * 5 / 9
                        print("${fahrenheit} grados Fahrenheit equivalen a ${formateo(Celsius)} grados Celsius.")
                    }
                    3 -> {
                        var Kelvin=0.0;
                        do {
                            Kelvin = Depurar.leerDecimal("Dime los grados Kelvin (No puede ser menor de 0): ")
                        }while (Kelvin<=0.0);
                        val Celsius = Kelvin - 273.15
                        print("${Kelvin} grados Kelvin equivalen a ${formateo(Celsius)} grados Celsius.")
                    }
                    4 -> {
                        val Celsius = Depurar.leerDecimal("Dime los grados celsius: ")
                        val Kelvin = Celsius + 273.15
                        print("${Celsius} grados Celsius equivalen a ${formateo(Kelvin)} grados Kelvin.")
                    }
                    5 -> salir = true;
                    else -> print("Opción no válida.")
                }
            }
    }
    fun operacionDivisas(divisas: Double): Double {
    val euros = Depurar.leerDecimal("Dime una cantidad de euros: ");
    val resultado = euros * divisas;

      return resultado;
    }


    //Funcion que formatea los decimales a dos decimales
    fun formateo(n: Double): String {
        if (!n.isFinite()) return "indefinido"      // Para la división entre 0

        // Redondeamos a 2 decimales, lo convertimos a String y cambiamos el punto por coma.
        return BigDecimal.valueOf(n).setScale(2, RoundingMode.HALF_UP).toPlainString().replace('.', ',')
    }

    //Funcion que muestra el menu.
    fun menu(): String{
        return "\n===== CONVERSOR DE UNIDADES =====\n" +
                "1. Conversor de divisas\n" +
                "2. Conversor de distancias\n" +
                "3. Conversor de temperaturas\n" +
                "4. Salir\n" +
                "Seleccione una opción: ";
    }

    fun menuDivisas(): String{
        return "\n===== CONVERSOR DE DIVISAS =====\n" +
                "1. Euros a dólares.\n" +
                "2. Euros a libras esterlinas.\n" +
                "3. Euros a yenes.\n" +
                "4. Euros a francos suizos\n" +
                "5. Salir\n" +
                "Seleccione una opción: ";
    }

    fun menuDistancias(): String{
        return "\n===== CONVERSOR DE DISTANCIAS =====\n" +
                "1. Kilómetros a metros.\n" +
                "2. Metros a kilómetros.\n" +
                "3. Kilómetros a millas.\n" +
                "4. Millas a kilómetros.\n" +
                "5. Centímetros a metros.\n" +
                "6. Salir\n" +
                "Seleccione una opción: ";
    }

    fun menuTemperatura(): String{
        return "\n===== CONVERSOR DE TEMPERATURAS =====\n" +
                "1. Celsius a Fahrenheit.\n" +
                "2. Fahrenheit a Celsius.\n" +
                "3. Celsius a Kelvin.\n" +
                "4. Kelvin a Celsius.\n" +
                "5. Salir\n" +
                "Seleccione una opción: ";
    }
}