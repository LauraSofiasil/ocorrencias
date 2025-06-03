package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName

data class Turma(
    var id: Int = 0,
    var nome: String = "",
    var periodo: String = "",
    var curso: String = "",
    @SerializedName("max_alunos") var max: Int = 0
)
