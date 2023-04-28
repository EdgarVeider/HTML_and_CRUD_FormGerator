
class Text {
    public val text_lenth: Int
    val text_verbose: String
    val pk: Boolean

    constructor(text_lenth: Int, text_verbose: String, pk :Boolean){
        this.text_lenth = text_lenth
        this.text_verbose = text_verbose
        this.pk = pk
    }

    fun get_text_lenth(): Int{
        return this.text_lenth
    }

    fun get_verbose(): String {
        return this.text_verbose
    }

    fun get_pk(): Boolean{
        return this.pk
    }
}

class Integer {
    val pk: Boolean
    val text_verbose: String

    constructor(text_verbose: String, pk:Boolean){
        this.pk = pk
        this.text_verbose = text_verbose
    }

    fun get_pk(): Boolean{
        return this.pk
    }

    fun get_verbose(): String {
        return this.text_verbose
    }
}

class Email {
    val pk: Boolean
    val text_verbose: String

    constructor(text_verbose: String, pk:Boolean){
        this.pk = pk
        this.text_verbose = text_verbose
    }

    fun get_pk(): Boolean{
        return this.pk
    }

    fun get_verbose(): String {
        return this.text_verbose

    }
}

class Password{
    val pk: Boolean
    val text_verbose: String

    constructor(text_verbose: String, pk:Boolean){
        this.pk = pk
        this.text_verbose = text_verbose
    }

    fun get_pk(): Boolean{
        return this.pk
    }

    fun get_verbose(): String {
        return this.text_verbose
    }
}

class Fk{
    var referenceClass: String
    var referenecAtribute: String
    var atribute_type: String
    var atribute: String

    constructor(referecneClass: String, referenecAtribute: String, atribute_type: String,atribute: String){
        this.referenecAtribute = referenecAtribute
        this.referenceClass = referecneClass
        this.atribute_type = atribute_type
        this.atribute = atribute
    }

    fun get_referenceClass(): String{
        return this.referenceClass
    }

    fun get_referenecAtribute(): String{
        return this.referenecAtribute
    }

    fun atribute_type(): String{
        return this.atribute_type
    }

    fun get_atribute(): String{
        return this.atribute
    }
}