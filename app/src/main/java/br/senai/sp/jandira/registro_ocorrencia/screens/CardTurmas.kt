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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun CardTurmas(
    nome: String = "Nome da turma",
    Image: String = "https://yt3.googleusercontent.com/0cWwFDs9HatH-4hciGsPJjoRhQyI6L0pcpteLN5yl2_Vapb_AOsZiVK-JVIURCVscgBYTLeI=s900-c-k-c0x00ffffff-no-rj"
){
    Card(
        modifier = Modifier
            .padding(bottom = 14.dp)
            .fillMaxWidth()
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
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE1E1E1)),
                shape = CircleShape
            ){
                AsyncImage(
                    model = Image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .padding(start = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Turma:",
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
private fun CardTurmasPreview(){
    CardTurmas()
}