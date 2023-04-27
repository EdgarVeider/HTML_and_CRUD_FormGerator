
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