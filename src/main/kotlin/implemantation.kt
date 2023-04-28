public class Informacoes1 {
    public val nome = Text(50, "nome", false)
    public val email = Email("e_mail",false)
    public val password = Password("Password",false)
    public val id = Integer("ID",true)

    public val id_cargo = Fk("Informacoes2", "cargo_nome", "VARCHAR(50)", "nome_cargo")
}

public class Informacoes2 {
    public val cargo_nome = Text(50, "cargo_nome", true)
}