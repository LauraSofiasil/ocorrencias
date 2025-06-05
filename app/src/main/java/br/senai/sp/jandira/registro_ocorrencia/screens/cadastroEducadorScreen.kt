package br.senai.sp.jandira.projetofinal.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import br.senai.sp.jandira.registro_ocorrencia.R
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import br.senai.sp.jandira.registro_ocorrencia.model.Educador
import br.senai.sp.jandira.registro_ocorrencia.model.ResultEducador
import br.senai.sp.jandira.registro_ocorrencia.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



@Composable
fun HomeScreen(navController: NavController?) {
    var nome = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var senha = remember { mutableStateOf("") }
    var confirm = remember { mutableStateOf("") }
    var palavra = remember { mutableStateOf("") }
    var cargo = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.fundo2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
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
                text = stringResource(R.string.educador),
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )

            TextField(
                value = nome.value,
                onValueChange = { nome.value = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.nome),
                        fontSize = 19.sp,
                        color = Color.Gray

                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp,
                        vertical = 18.dp),

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
                value = cargo.value,
                onValueChange = { cargo.value = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.cargo),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp,
                        vertical = 15.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), //Mostra um teclado de número
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
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.email),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp,
                        vertical = 15.dp),

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
                value = senha.value,
                onValueChange = { senha.value = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.senha),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp,
                        vertical = 15.dp),

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
                value = confirm.value,
                onValueChange = { confirm.value = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.confirm),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp,
                        vertical = 15.dp),

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
                value = palavra.value,
                onValueChange = { palavra.value = it },
                placeholder = {
                    Text(
                        text = stringResource(R.string.chav),
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(horizontal = 20.dp,
                        vertical = 10.dp),

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
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {

                    val educadorBody = Educador(
                        nome = nome.value,
                        email = email.value,
                        senha = senha.value,
                        palavra = palavra.value,
                        cargo = cargo.value.toIntOrNull()?: 0 // Converter o texto para Int
                    )
                    val sendEducador = RetrofitFactory()
                        .getEducadorService()
                        .insertEducador(educadorBody)

                    sendEducador.enqueue(object : Callback<ResultEducador> {
                        override fun onResponse(
                            p0: Call<ResultEducador>,
                            p1: Response<ResultEducador>
                        ) {
                            Log.d("Sucesso", "Cadastrado com sucesso")
                        }

                        override fun onFailure(p0: Call<ResultEducador>, p1: Throwable) {
                            Log.d("Erro", "Não foi possivel cadastrar: ${p1.message}")
                        }

                    })

                    navController?.navigate("galeria_turma")

                },
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF800000)
                )
            ) {
                Text(text = "Finalizar Cadastro",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
            }



        }
        }
    }



@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(null)
}
