package br.senai.sp.jandira.projetofinal.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.registro_ocorrencia.R
import br.senai.sp.jandira.registro_ocorrencia.model.Result
import br.senai.sp.jandira.registro_ocorrencia.model.Turma
import br.senai.sp.jandira.registro_ocorrencia.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroTurmaScreen(navController: NavController?) {
    val nome = remember { mutableStateOf("") }
    val periodo = remember { mutableStateOf("") }
    val curso = remember { mutableStateOf("") }
    val max = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        androidx.compose.foundation.Image(
            painter = androidx.compose.ui.res.painterResource(R.drawable.fundo2),
            contentDescription = "",
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color(0x80000000))
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
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.cadastro),
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.turma),
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextField(
                        value = nome.value,
                        onValueChange = { nome.value = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.turma),
                                fontSize = 19.sp,
                                color = Color.Gray
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(65.dp),
                        shape = RoundedCornerShape(5.dp),
                        singleLine = true,
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
            }

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = max.value,
                onValueChange = { max.value = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.capacidade),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                shape = RoundedCornerShape(5.dp),
                singleLine = true,
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

            TextField(
                value = curso.value,
                onValueChange = { curso.value = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.curso),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                shape = RoundedCornerShape(5.dp),
                singleLine = true,
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

            TextField(
                value = periodo.value,
                onValueChange = { periodo.value = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.inicio),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                shape = RoundedCornerShape(5.dp),
                singleLine = true,
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

            Spacer(modifier = Modifier.height(130.dp))

            Button(
                onClick = {
                    val turmaBody = Turma(
                        nome = nome.value,
                        max = max.value.toIntOrNull()?: 0,
                        curso = curso.value,
                        periodo = periodo.value
                    )

                    val sendTurma = RetrofitFactory()
                        .getTurmaService()
                        .insertTurma(turmaBody)

                    sendTurma.enqueue(object : Callback<Result> {
                        override fun onResponse(
                            p0: Call<Result>,
                            p1: Response<Result>
                        ) {
                            Log.d("Sucesso", "Cadastrado com sucesso")
                        }

                        override fun onFailure(p0: Call<Result>, p1: Throwable) {
                            Log.d("Erro", "Não foi possivel cadastrar: ${p1.message}")
                        }

                    })
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF800000)
                )
            ) {
                Text(
                    text = stringResource(R.string.finalizar),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CadastroTurmaScreenPreview() {
    CadastroTurmaScreen(null)
}
