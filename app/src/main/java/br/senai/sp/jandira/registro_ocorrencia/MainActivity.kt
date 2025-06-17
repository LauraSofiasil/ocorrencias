package br.senai.sp.jandira.registro_ocorrencia


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.projetofinal.screens.CadastroAlunoScreen
import br.senai.sp.jandira.projetofinal.screens.CadastroTurmaScreen
import br.senai.sp.jandira.registro_ocorrencia.screens.DadosAlunoScreen
import br.senai.sp.jandira.registro_ocorrencia.screens.NextScreen
import br.senai.sp.jandira.registro_ocorrencia.screens.RegistrarOcorrencia
import br.senai.sp.jandira.registro_ocorrencia.screens.galeriaAlunosScreen
import br.senai.sp.jandira.registro_ocorrencia.screens.galeriaTurmasScreen

import br.senai.sp.jandira.registro_ocorrencia.ui.theme.Registro_ocorrenciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Registro_ocorrenciaTheme {
                AppNavGraph()
            }
        }
    }
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "next_screen"
    ) {
        composable("next_screen") { NextScreen(navController) }
        composable("cadastro_aluno") { CadastroAlunoScreen(navController) }
        composable("cadastro_turma") { CadastroTurmaScreen(navController) }
        composable("galeria_turma") { galeriaTurmasScreen(navController) }
        composable("galeria_aluno") { galeriaAlunosScreen(navController) }
        composable("dados_aluno") { DadosAlunoScreen(navController) }
        composable("registro") { RegistrarOcorrencia(navController) }
    }
}
