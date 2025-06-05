package br.senai.sp.jandira.registro_ocorrencia.service

import br.senai.sp.jandira.registro_ocorrencia.model.Alunos
import br.senai.sp.jandira.registro_ocorrencia.model.AlunosResult
import br.senai.sp.jandira.registro_ocorrencia.model.Result
import br.senai.sp.jandira.registro_ocorrencia.model.TurmasResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AlunoService {
    @Headers("Content-Type: application/json")
    @POST("alunos")
    fun insertAlunos (@Body alunos: Alunos): Call<Result>

    @GET("alunos")
    fun listAll(): Call<AlunosResult>
}