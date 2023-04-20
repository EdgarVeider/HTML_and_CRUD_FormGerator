import com.sun.jdi.event.StepEvent
import java.io.BufferedWriter
import java.sql.Connection
import java.sql.DriverManager
import kotlin.system.exitProcess

import java.io.File
import java.io.FileWriter


// the model class
data class User(val id: Int, val name: String)

fun main(){

    var html = HTMLgerator("Cliente")
    html.FormFields(4,"Nome", "sobrenome", "email", "telefone")
    html.CreateForm()






//    val m = Model("Usuario")
//    m.Texto("nome", 10, false)
//    m.Inteiro("codigo", true)
//    m.Flutuante("preco", false)
//    m.TableCreate()
//    println(m.sql)


}

class DataBase{
    var connection : Connection
    var sql : String
    var start_flag : Boolean
    var primaryKey_flag : Boolean

    val table_name : String

    constructor(table_name: String){
        val jdbcUrl = "jdbc:mysql://localhost:3306/kotlinbd"

        this.connection = DriverManager.getConnection(jdbcUrl, "root", "161023@Fr")

        if (connection.isValid(0)){
            println("CONECTION SUCESS")
        }else{
            print("CONECTION FAILED")
        }

        this.sql = "CREATE TABLE $table_name ("

        this.table_name = table_name
        this.start_flag = true
        this.primaryKey_flag = false
    }

    fun Texto(atribute_name: String, size: Int, primaryKey : Boolean){

        if (!start_flag){
            this.sql = this.sql + ", "
        }

        this.sql = this.sql +" " + atribute_name + " VARCHAR ($size)"
        this.start_flag = false

        if ((primaryKey == true) && (this.primaryKey_flag == true)){
            println("Ja existe uma prymary Key")
            exitProcess(1)
        }

        if (primaryKey){
            this.sql = this.sql + " PRIMARY KEY"
            this.primaryKey_flag = true
        }
    }

    fun Inteiro(atribute_name: String, primaryKey : Boolean){
        if (!start_flag){
            this.sql = this.sql + ", "
        }

        this.sql = this.sql + " " + atribute_name + " INTEGER"

        if ((primaryKey == true) && (this.primaryKey_flag == true)){
            println("Ja existe uma prymary Key")
            exitProcess(1)
        }
        if (primaryKey){
            this.sql = this.sql + " PRIMARY KEY"
            this.primaryKey_flag = true
        }
    }

    fun Flutuante(atribute_name: String, primaryKey : Boolean){
        if (!start_flag){
            this.sql = this.sql + ", "
        }

        this.sql = this.sql + " " + atribute_name + " FLOAT"

        if ((primaryKey == true) && (this.primaryKey_flag == true)){
            println("Ja existe uma prymary Key")
            exitProcess(1)
        }
        if (primaryKey){
            this.sql = this.sql + " PRIMARY KEY"
            this.primaryKey_flag = true
        }
    }


    fun TableCreate(){
        this.sql = this.sql + ")"
        println("Execute ${this.sql}")

        val query = this.connection.prepareStatement(this.sql)
        query.execute()

        println("tabela contas criada")
    }


}

class HTMLgerator{
    val arquivo: File
    val fileWriter: FileWriter
    val bufferWriter: BufferedWriter

    constructor(form_name: String){
        this.arquivo = File("index.html")
        arquivo.createNewFile()

        this.fileWriter = FileWriter(arquivo)
        this.bufferWriter = BufferedWriter(fileWriter)
        bufferWriter.write("<h1>$form_name</h1>")
    }

    fun FormFields(n_fields: Int,vararg field: String){

        var i = 0
        while (i < n_fields){
            bufferWriter.write("<input type='text' placeholder='${field[i]}'><br><br>")
            i += 1
        }

    }

    fun CreateForm(){
        bufferWriter.write("<input type='submit' value='SUBMIT'>")

        bufferWriter.close()
        fileWriter.close()
    }
}


