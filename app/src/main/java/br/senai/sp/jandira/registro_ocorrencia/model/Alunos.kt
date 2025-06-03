package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Alunos(
    var id: Int = 0,
    var nome: String = "",
    var matricula: String = "",
    @SerializedName("data_nascimento") var nascimento: String = "",
    @SerializedName("id_turma") var turma: Int = 0
)
