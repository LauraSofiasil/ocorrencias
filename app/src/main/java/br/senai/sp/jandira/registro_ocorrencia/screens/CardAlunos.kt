package br.senai.sp.jandira.registro_ocorrencia.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.annotations.SerializedName

@Composable
fun CardAlunosScreen(
    nome: String = "Nome do aluno"
){

    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .width(290.dp)
            .height(119.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xffFFFFFF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(90.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                shape = CircleShape
            ){}

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center,
                 horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Aluno:",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = nome,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardAlunosScreenPreview(){
    CardAlunosScreen()
}