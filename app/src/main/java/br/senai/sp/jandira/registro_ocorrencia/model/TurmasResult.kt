package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName

data class TurmasResult(
    @SerializedName("turmas") val results: List<Turma>

)
