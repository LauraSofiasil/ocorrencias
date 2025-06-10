package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName

data class AlunosResult(
    @SerializedName("alunos") var results: List<Alunos>
)
