package br.senai.sp.jandira.registro_ocorrencia.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.registro_ocorrencia.R
import br.senai.sp.jandira.registro_ocorrencia.model.Alunos
import br.senai.sp.jandira.registro_ocorrencia.model.AlunosResult
import br.senai.sp.jandira.registro_ocorrencia.model.Ocorrencias
import br.senai.sp.jandira.registro_ocorrencia.model.Turma
import br.senai.sp.jandira.registro_ocorrencia.model.TurmasResult
import br.senai.sp.jandira.registro_ocorrencia.model.ocorrenciaResult
import br.senai.sp.jandira.registro_ocorrencia.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun DadosAlunoScreen(navController: NavController?){

    val nomeAluno = remember { mutableStateOf("") }

    val matriculaAluno = remember { mutableStateOf("") }

    val nascimento = remember { mutableStateOf("") }

    var alunosList = remember { mutableStateOf(listOf<Alunos>()) }

    //Obter um retrofict Factory
    var callAlunos = RetrofitFactory()
        .getAlunoService()
        .listAll()

    //Enviar a requisição
    callAlunos.enqueue(object : Callback<AlunosResult> {
        override fun onResponse(p0: Call<AlunosResult>, response: Response<AlunosResult>) {
            val body = response.body()
            Log.e("test", alunosList.value.toString())
            if (body != null && body.results != null){
                Log.e("Sucesso", "Entrou nos alunos")
                alunosList.value = body.results

                // Aqui pegamos o nome da turma a partir do primeiro aluno
                if (body.results.isNotEmpty()) {
                    val alunoNomeApi = body.results[0].nome ?: "Aluno Desconhecida"
                    nomeAluno.value = alunoNomeApi
                }

                if (body.results.isNotEmpty()) {
                    val alunoMatriculaApi = body.results[0].matricula ?: "Aluno Desconhecida"
                    matriculaAluno.value = alunoMatriculaApi
                }

                if (body.results.isNotEmpty()) {
                    val alunoNascimentoApi = body.results[0].nascimento ?: "Aluno Desconhecida"
                    nascimento.value = alunoNascimentoApi
                }



            }else{
                Log.e("Erro", "Resposta inválida ou vazia")
                alunosList.value = emptyList() // garante que não seja null
            }
        }

        override fun onFailure(p0: Call<AlunosResult>, response: Throwable) {
            Log.e("Erro", "Não foi possível listar os alunos: ${response.message}")
        }

        override fun toString(): String {
            return "`<no name provided>`()"
        }
    })

    /////////////////Histórico//////////////////////////////

//    var ocorrenciaList = remember { mutableStateOf(listOf<Ocorrencias>()) }
//
//    //Obter um retrofict Factory
//    var callOcorrencia = RetrofitFactory()
//        .getOcorrenciaService()
//        .listAll()
//    //Enviar a requisição
//    callOcorrencia.enqueue(object : Callback<ocorrenciaResult> {
//        override fun onResponse(p0: Call<ocorrenciaResult>, response: Response<ocorrenciaResult>) {
//            val body = response.body()
//            Log.e("test", ocorrenciaList.value.toString())
//            if (body != null && body.results != null){
//                Log.e("Sucesso", "Entrou nos alunos")
//                ocorrenciaList.value = body.results
//
//            }else{
//                Log.e("Erro", "Resposta inválida ou vazia")
//                ocorrenciaList.value = emptyList() // garante que não seja null
//            }
//        }
//
//        override fun onFailure(p0: Call<ocorrenciaResult>, response: Throwable) {
//            Log.e("Erro", "Não foi possível listar os alunos: ${response.message}")
//        }
//    })

    ///////////////////////////////////////////////////////

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF800000))
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x4D800000))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Aluno",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            Card(
                modifier = Modifier
                    .size(186.dp),
                shape = CircleShape
            ){
                Image(
                    painter = painterResource(R.drawable.foto),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            //Nome
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = nomeAluno.value,
                        fontSize = 14.sp,
                        color = Color(0xFFCBCACA)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(top = 46.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
            //Matrícula
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = matriculaAluno.value,
                        fontSize = 14.sp,
                        color = Color(0xffD7D7D7)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(top = 20.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                //Nascimento
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = nascimento.value,
                            fontSize = 14.sp,
                            color = Color(0xffD7D7D7)
                        )
                    },
                    modifier = Modifier
                        .width(153.dp)
                        .padding(top = 20.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.width(30.dp))

                //Turma
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = "DS4A",
                            fontSize = 14.sp,
                            color = Color(0xffD7D7D7)
                        )
                    },
                    modifier = Modifier
                        .width(153.dp)
                        .padding(top = 20.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    )
                )
            }
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Desenvolvimento de sistemas",
                        fontSize = 14.sp,
                        color = Color(0xffD7D7D7)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(top = 20.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(5.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
            Box(){
                TextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(
                            text = stringResource(R.string.historico),
                            fontSize = 14.sp,
                            color = Color(0xffD7D7D7)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(top = 20.dp)
                        .height(110.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    ),
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 300.dp, top = 35.dp)
                        .size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DeleteOutline,
                        contentDescription = "",
                        tint = Color(0xFFBEBDBD)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(45.dp)
                        .width(156.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF800000)
                    )
                ) {
                    Text(
                        text = "Remover aluno",
                        color = Color.White,
                        fontSize = 12.sp,

                        )
                }

                Spacer(modifier = Modifier.width(15.dp))

                Button(
                    onClick = {
                        navController?.navigate("registro")
                    },
                    modifier = Modifier
                        .height(45.dp)
                        .width(164.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF800000)
                    )
                ) {
                    Text(
                        text = "Registrar ocorrência",
                        color = Color.White,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun DadosAlunoScreenPrreview(){
    DadosAlunoScreen(null)
}