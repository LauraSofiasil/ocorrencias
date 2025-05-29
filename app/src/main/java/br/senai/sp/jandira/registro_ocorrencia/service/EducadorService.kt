package br.senai.sp.jandira.registro_ocorrencia.service

import br.senai.sp.jandira.registro_ocorrencia.model.Educador
import br.senai.sp.jandira.registro_ocorrencia.model.ResultEducador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface EducadorService {

    @Headers("Content-Type: application/json")
    @POST("educador")
    fun insertEducador(@Body educador: Educador): Call<ResultEducador>

}