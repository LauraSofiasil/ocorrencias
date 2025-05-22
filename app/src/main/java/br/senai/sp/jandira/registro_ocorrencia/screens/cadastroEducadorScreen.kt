package br.senai.sp.jandira.registro_ocorrencia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.registro_ocorrencia.R

@Composable
fun cadastroEducador(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.fundo),
            contentDescription = ""
        )
    }
}


@Preview
@Composable
private fun cadastroEducadorPreview(){
    cadastroEducador()
}