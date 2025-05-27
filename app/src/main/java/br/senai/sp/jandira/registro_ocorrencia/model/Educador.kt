package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName

data class Educador(
    var id: Int = 0,
    var nome: String = "",
    var email: String = "",
    var senha: String = "",
    @SerializedName("palavra_chave") var palavra: String = "",
    @SerializedName("id_cargo") var cargo: Int = 0
)
