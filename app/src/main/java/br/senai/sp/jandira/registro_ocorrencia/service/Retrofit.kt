package br.senai.sp.jandira.registro_ocorrencia.service


import br.senai.sp.jandira.registro_ocorrencia.model.ocorrenciaResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL_BASE = "http://10.107.134.37:8080/v1/registro-ocorrencias/"

    private val RETROFIT_FACTORY = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getEducadorService() : EducadorService{
        return RETROFIT_FACTORY.create(EducadorService::class.java)
    }

    fun getTurmaService() : TurmaService{
        return RETROFIT_FACTORY.create(TurmaService::class.java)
    }

    fun getAlunoService() : AlunoService{
        return RETROFIT_FACTORY.create(AlunoService::class.java)
    }

    fun getOcorrenciaService() : OcorrenciaService{
        return RETROFIT_FACTORY.create(OcorrenciaService::class.java)
    }
}