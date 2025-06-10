package br.senai.sp.jandira.registro_ocorrencia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
import br.senai.sp.jandira.registro_ocorrencia.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrarOcorrencia() {
    val tipos = listOf("Agressão", "Furto", "Bullying")
    val gravidades = listOf("Leve", "Média", "Grave")

    var tipoSelecionado by remember { mutableStateOf("") }
    var gravidadeSelecionada by remember { mutableStateOf("") }
    var expandedTipo by remember { mutableStateOf(false) }
    var expandedGravidade by remember { mutableStateOf(false) }
    var historico by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9B2B2))

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF800000))
                .align(Alignment.TopCenter)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp, top = 78.dp)
        ) {
            Text(
                text = "Registrar Ocorrência",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(100.dp))


            ExposedDropdownMenuBox(
                expanded = expandedTipo,
                onExpandedChange = { expandedTipo = !expandedTipo },
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = tipoSelecionado,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(id = R.string.ocorrencia)) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTipo)
                    },
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                        .background(Color.White, RoundedCornerShape(8.dp))
                )
                ExposedDropdownMenu(
                    expanded = expandedTipo,
                    onDismissRequest = { expandedTipo = false }
                ) {
                    tipos.forEach { tipo ->
                        DropdownMenuItem(
                            text = { Text(tipo) },
                            onClick = {
                                tipoSelecionado = tipo
                                expandedTipo = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            ExposedDropdownMenuBox(
                expanded = expandedGravidade,
                onExpandedChange = { expandedGravidade = !expandedGravidade },
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = gravidadeSelecionada,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(id = R.string.gravidade)) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedGravidade)
                    },
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                        .background(Color.White, RoundedCornerShape(8.dp))
                )
                ExposedDropdownMenu(
                    expanded = expandedGravidade,
                    onDismissRequest = { expandedGravidade = false }
                ) {
                    gravidades.forEach { gravidade ->
                        DropdownMenuItem(
                            text = { Text(gravidade) },
                            onClick = {
                                gravidadeSelecionada = gravidade
                                expandedGravidade = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Box(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = historico,
                    onValueChange = { historico = it },
                    label = { Text(stringResource(id = R.string.historico)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.White, RoundedCornerShape(8.dp)),
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

                IconButton(
                    onClick = { historico = "" },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Limpar")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                value = data,
                onValueChange = { data = it },
                placeholder = { Text("DD/MM/AA      00:00:00") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
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

            Spacer(modifier = Modifier.height(100.dp))


            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000)),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Registrar ocorrência",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun RegistrarOcorrenciaScreenPreview() {
    RegistrarOcorrencia()
}
