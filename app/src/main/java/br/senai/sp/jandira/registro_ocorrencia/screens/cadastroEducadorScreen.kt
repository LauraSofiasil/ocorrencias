package br.senai.sp.jandira.projetofinal.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController?) {
    var nome by remember { mutableStateOf("") }
    var cargo by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    var chav by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(br.senai.sp.jandira.registro_ocorrencia.R.drawable.fundo2),
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
                value = nome,
                onValueChange = { nome = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.nome),
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
                value = cargo,
                onValueChange = { cargo = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.cargo),
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
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.cargo),
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
                value = senha,
                onValueChange = { senha = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.senha),
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
                value = confirm,
                onValueChange = { confirm = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.confirm),
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
                value = chav,
                onValueChange = { chav = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.chav),
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
                onClick = { },
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
