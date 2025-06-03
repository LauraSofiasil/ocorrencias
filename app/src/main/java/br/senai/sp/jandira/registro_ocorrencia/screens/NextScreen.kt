package br.senai.sp.jandira.registro_ocorrencia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.senai.sp.jandira.registro_ocorrencia.R
import br.senai.sp.jandira.registro_ocorrencia.screens.NextScreen

@Composable
fun NextScreen(navController: NavController?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(R.drawable.fundo2),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color(0x80000000)) // deixa o fundo escuro
        ){
            Button(
                onClick = { navController?.navigate("home_screen") },
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(60.dp)
                    .width(300.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000))
            ) {
                Text(text = "Registro", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
private fun nextScreenPreview(){
    NextScreen(null)
}
