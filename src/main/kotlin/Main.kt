import java.util.Arrays
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaField
import kotlin.reflect.typeOf
import kotlin.reflect.jvm.*

public class Teste{
    public val number: Int

    constructor(){
        this.number = 1
    }

    fun clas_number(): Int{
        return this.number
    }
}

fun main(args: Array<String>) {
    val info1 = Informacoes()
    val info = Class.forName("Informacoes")
    val nome = info.getDeclaredFields()

    nome[0].setAccessible(true)
    val texto = nome[0].get(info1)


    val a = nome
    val b = Class.forName("Text")
    val method = b.getMethod("get_text_lenth")

    val resultado = method.invoke(texto)
    println(resultado)

//    println(info1)
//    for (field in nome){
//        field.setAccessible(true)
//        println(field.get(info1))
//    }


}