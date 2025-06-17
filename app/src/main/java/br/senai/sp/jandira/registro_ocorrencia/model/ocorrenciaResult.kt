package br.senai.sp.jandira.registro_ocorrencia.model



data class ocorrenciaResult(
 var status: Boolean = false,
 var statusCode: Int = 0,
 var message: String = ""
)
