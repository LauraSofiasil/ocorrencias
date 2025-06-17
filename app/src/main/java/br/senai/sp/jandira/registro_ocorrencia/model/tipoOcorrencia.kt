package br.senai.sp.jandira.registro_ocorrencia.model

import com.google.gson.annotations.SerializedName

data class tipoOcorrencia(
    var id: Int = 0,
    var tipo: String = ""
)
