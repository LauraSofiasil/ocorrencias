package br.senai.sp.jandira.registro_ocorrencia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LeadingIconTab
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.registro_ocorrencia.R
import br.senai.sp.jandira.registro_ocorrencia.model.Alunos
import br.senai.sp.jandira.registro_ocorrencia.model.AlunosResult
import br.senai.sp.jandira.registro_ocorrencia.model.Turma
import br.senai.sp.jandira.registro_ocorrencia.model.TurmasResult
import br.senai.sp.jandira.registro_ocorrencia.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun galeriaAlunosScreen(){

    //Variável que aguarda
    var alunosList = remember {
        mutableStateOf(listOf<Alunos>())
    }

    //Obter um retrofict Factory
    var callAlunos = RetrofitFactory()
        .getAlunoService()
        .listAll()

    //Enviar a requisição
    callAlunos.enqueue(object : Callback<AlunosResult> {
        override fun onResponse(p0: Call<AlunosResult>, response: Response<AlunosResult>) {
            alunosList.value = response.body()!!.results
        }

        override fun onFailure(p0: Call<AlunosResult>, response: Throwable) {

        }
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.fundo3),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x595D5C5C))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF800000))
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "Turma 4B",
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 60.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(top = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.Transparent)
                ){
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = "Pesquise um aluno",
                                fontSize = 14.5.sp,
                                color = Color(0xffB7B7B7)
                            )
                        },
                        modifier = Modifier
                            .width(210.dp),
                        shape = RoundedCornerShape(5.dp),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "",
                                tint = Color(0xffB7B7B7)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xffFFFDFD),
                            unfocusedContainerColor = Color(0xffFFFDFD)
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .background(Color.Transparent)
                        .padding(start = 40.dp)
                        .padding(top = 10.dp)
                ) {
                    Text(
                        text = "Qntd de alunos: 0",
                        fontSize = 10.sp,
                        color = Color.White
                    )


                    Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Prof: XXXXX",
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                    items(alunosList.value){
                        CardAlunosScreen(
                            nome = it.nome
                        )
                    }
            }

            Spacer(modifier = Modifier.height(50.dp))

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
                    text = "Adicionar aluno",
                    color = Color.White,
                    fontSize = 15.sp,
                    
                )
            }
        }
    }
}





@Preview
@Composable
private fun galeriaAlunosScreenPreview(){
    galeriaAlunosScreen()
}