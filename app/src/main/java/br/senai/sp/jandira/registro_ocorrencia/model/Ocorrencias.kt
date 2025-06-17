package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName

data class Ocorrencias(
    var id: Int = 2,
    var relato: String = "",
    @SerializedName("id_aluno") var alunos: Int = 0,
    @SerializedName("id_tipo") var tipos: Int = 0,
    @SerializedName("id_gravidade") var gravidades: Int = 0,

    )
