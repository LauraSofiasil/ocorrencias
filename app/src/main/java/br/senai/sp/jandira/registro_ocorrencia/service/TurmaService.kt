package br.senai.sp.jandira.registro_ocorrencia.service

import br.senai.sp.jandira.registro_ocorrencia.model.Result
import br.senai.sp.jandira.registro_ocorrencia.model.Turma
import br.senai.sp.jandira.registro_ocorrencia.model.TurmasResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface TurmaService {

    @Headers("Content-Type: application/json")
    @POST("turma")
    fun insertTurma (@Body turma: Turma): Call<Result>

    @GET("turma")
    fun listAll(): Call<TurmasResult>
}