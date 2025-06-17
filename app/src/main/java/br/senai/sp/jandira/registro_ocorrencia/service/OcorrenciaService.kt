package br.senai.sp.jandira.registro_ocorrencia.service


import br.senai.sp.jandira.registro_ocorrencia.model.Ocorrencias
import br.senai.sp.jandira.registro_ocorrencia.model.Result
import br.senai.sp.jandira.registro_ocorrencia.model.ocorrenciaResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface OcorrenciaService {
    @Headers("Content-Type: application/json")
    @POST("ocorrencia")
    fun insertOcorrencia (@Body ocorrencia: Ocorrencias): Call<ocorrenciaResult>

    @GET("ocorrencia")
    fun listAll(): Call<ocorrenciaResult>
}