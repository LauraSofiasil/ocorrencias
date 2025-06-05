package br.senai.sp.jandira.registro_ocorrencia.screens

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
import br.senai.sp.jandira.registro_ocorrencia.model.Turma
import br.senai.sp.jandira.registro_ocorrencia.model.TurmasResult
import br.senai.sp.jandira.registro_ocorrencia.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun galeriaTurmasScreen(navController: NavController?){

    //Variável que aguarda
    var turmaList = remember{
        mutableStateOf(listOf<Turma>())
    }

    //Obter um retrofict Factory
    var  callTurmas = RetrofitFactory()
        .getTurmaService()
        .listAll()

    //Enviar a requisição
    callTurmas.enqueue(object : Callback<TurmasResult> {

        override fun onResponse(p0: Call<TurmasResult>, response: Response<TurmasResult>) {
            turmaList.value = response.body()!!.results
        }

        override fun onFailure(p0: Call<TurmasResult>, response: Throwable) {
            TODO("Not yet implemented")
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
                .background(Color(0x5C000000))
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(top = 80.dp)
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
                                text = "Pesquise uma turma",
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
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .padding(start = 55.dp)
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Ano:   ",
                            fontSize = 10.sp,
                            color = Color.White
                        )
                        Column (
                            modifier = Modifier
                                .width(15.dp)
                                .height(15.dp)
                                .background(Color.White),
                        ){
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = Color(0xffB7B7B7)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .height(10.dp)
                            .fillMaxWidth()
                            .padding(start = 50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Curso:  ",
                            fontSize = 10.sp,
                            color = Color.White
                        )
                        Column (
                            modifier = Modifier
                                .width(15.dp)
                                .height(25.dp)
                                .background(Color.White),
                        ){
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = Color(0xffB7B7B7)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(turmaList.value){
                    CardTurmas(
                        nome = it.nome,
                    )
                }
            }

            CardTurmas(
                nome = "DS2A",
            )
            CardTurmas(
                nome = "DS2A",
            )
            CardTurmas(
                nome = "DS2A",
            )
            CardTurmas(
                nome = "DS2A",
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                horizontalArrangement = Arrangement.SpaceBetween
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
                        text = "Remover turma",
                        color = Color.White,
                        fontSize = 15.sp,

                        )
                }
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
                        text = "Adicionar turma",
                        color = Color.White,
                        fontSize = 14.sp,

                        )
                }
            }
        }
    }

}

@Preview
@Composable
private fun galeriaTurmasScreenPreview(){
    galeriaTurmasScreen(null)
}