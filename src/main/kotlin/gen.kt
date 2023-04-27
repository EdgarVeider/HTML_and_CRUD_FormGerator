import com.sun.jdi.event.StepEvent
import java.io.BufferedWriter
import java.sql.Connection
import java.sql.DriverManager
import kotlin.system.exitProcess

import java.io.File
import java.io.FileWriter
import java.util.*
import javax.swing.text.html.HTML

class createHtml {
    val arquivo: File
    val fileWriter: FileWriter
    val bufferWriter: BufferedWriter
    val myClass = Class.forName("Informacoes")

    constructor(){
        this.arquivo = File("index.html")
        arquivo.createNewFile()

        this.fileWriter = FileWriter(arquivo)
        this.bufferWriter = BufferedWriter(fileWriter)
        bufferWriter.write("<h1>FORM<br></h1>")
    }

    fun inputs_field(){
        var fields = Arrays.toString(this.myClass.getDeclaredFields())
        fields = fields.substring(1, fields.length-1)
        var separated_fields = fields.split(",")

        for (field in separated_fields){
            if(field.indexOf("Text") != -1){
                val placeholder = field.split(".")
                bufferWriter.write("<input type='text' placeholder'${placeholder[1]}' value='${placeholder[1]}'><br><br>")
            }

            if(field.indexOf("Email") != -1){
                val placeholder = field.split(".")
                bufferWriter.write("<input type='email' placeholder'${placeholder[1]}' value='${placeholder[1]}'><br><br>")
            }

            if(field.indexOf("Password") != -1){
                val placeholder = field.split(".")
                bufferWriter.write("<input type='password' placeholder'${placeholder[1]}' value='${placeholder[1]}'><br><br>")
            }

            if(field.indexOf("Integer") != -1){
                val placeholder = field.split(".")
                bufferWriter.write("<input type='int' placeholder'${placeholder[1]}' value='${placeholder[1]}'><br><br>")
            }
        }
    }

    fun CreateForm(){
        bufferWriter.write("<input type='submit' value='SUBMIT'><br>")

        bufferWriter.close()
        fileWriter.close()
    }
}

class DataBase{
    var connection : Connection
    var sql : String

    constructor(){
        val jdbcUrl = "jdbc:mysql://localhost:3306/kotlinbd"
        this.connection = DriverManager.getConnection(jdbcUrl, "root", "161023@Fr")

        if (connection.isValid(0)){
            println("CONECTION SUCESS")
        }else{
            print("CONECTION FAILED")
        }

        this.sql = "CREATE TABLE FORM ("
    }

    fun CreateTable(){
        val info = Class.forName("Informacoes")
        val fields = info.getDeclaredFields()

        val info1 = Informacoes()
        for (field in fields){
            //field.setAccessible(true)
            println(field.type)
            val f_type = (field.type).toString()


            if(f_type.indexOf("Text") != -1){
                field.setAccessible(true)
                val texto = field.get(info1)
                val text_class = Class.forName("Text")

                var method = text_class.getMethod("get_text_lenth")
                val varchar_lenth = method.invoke(texto)  // texto é a classe acessada que vem do atributo de informacoes

                method = text_class.getMethod("get_verbose")
                val name_atribute = method.invoke(texto)

                method = text_class.getMethod("get_pk")
                val pk = method.invoke(texto)

                if (pk == true){
                    this.sql = this.sql + "$name_atribute varchar($varchar_lenth) PRIMARY KEY, "
                }else{
                    this.sql = this.sql + "$name_atribute varchar($varchar_lenth), "
                }
            }

            if(f_type.indexOf("Integer") != -1){
                field.setAccessible(true)
                val texto = field.get(info1)
                val text_class = Class.forName("Integer")

                var method = text_class.getMethod("get_verbose")
                val name_atribute = method.invoke(texto)

                method = text_class.getMethod("get_pk")
                val pk = method.invoke(texto)

                if (pk == true){
                    this.sql = this.sql + "$name_atribute int PRIMARY KEY, "
                }else{
                    this.sql = this.sql + "$name_atribute int, "
                }
            }

            if(f_type.indexOf("Email") != -1){
                field.setAccessible(true)
                val texto = field.get(info1)
                val text_class = Class.forName("Email")

                var method = text_class.getMethod("get_verbose")
                val name_atribute = method.invoke(texto)

                method = text_class.getMethod("get_pk")
                val pk = method.invoke(texto)

                if (pk == true){
                    this.sql = this.sql + "$name_atribute varchar(255) PRIMARY KEY, "
                }else{
                    this.sql = this.sql + "$name_atribute varchar(255), "
                }
            }

            if(f_type.indexOf("Password") != -1){
                field.setAccessible(true)
                val texto = field.get(info1)
                val text_class = Class.forName("Password")

                var method = text_class.getMethod("get_verbose")
                val name_atribute = method.invoke(texto)

                method = text_class.getMethod("get_pk")
                val pk = method.invoke(texto)

                if (pk == true){
                    this.sql = this.sql + "$name_atribute varchar(255) PRIMARY KEY, "
                }else{
                    this.sql = this.sql + "$name_atribute varchar(255), "
                }
            }
        }
    }

    fun Create_Database(){
        this.sql = this.sql.substring(0, this.sql.length-2)
        this.sql = this.sql + ")"
        println("Execute ${this.sql}")

        val query = this.connection.prepareStatement(this.sql)
        query.execute()

        println("tabela contas criada")
    }

}

fun main(){
    val db = DataBase()
    val html = createHtml()
    html.inputs_field()
    html.CreateForm()


    println(db.sql)
}