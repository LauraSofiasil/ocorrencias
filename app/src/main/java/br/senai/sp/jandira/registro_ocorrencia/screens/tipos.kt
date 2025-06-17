package br.senai.sp.jandira.registro_ocorrencia.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.registro_ocorrencia.model.tipoOcorrencia


data class Tipos(
    var id: Int = 0,
    var tipo: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipoDropdown(
    tipo: List<Tipos>,
    onTipoSelecionado: (Int?) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var selectedId by remember { mutableStateOf<Int?>(null) }

    // Box para conter o TextField e o Dropdown
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            // TextField que mostra a seleção atual e abre/fecha o menu
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                readOnly = true,
                value = selectedText,
                onValueChange = {},
                label = { Text("Selecione um tipo") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
            )

            // Menu dropdown com as opções
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                tipo.forEach { categoria ->
                    DropdownMenuItem(
                        text = { Text(categoria.tipo) },
                        onClick = {
                            selectedText = categoria.tipo
                            selectedId = categoria.id
                            expanded = false
                            onTipoSelecionado(categoria.id)
                        }
                    )
                }
            }
        }
    }
}

// Exemplo de uso
@Composable
fun TelaExemplo() {
    val categorias = remember {
        listOf(
            Tipos(id = 1, tipo = "Baixo"),
            Tipos(id = 2, tipo = "Medio"),
            Tipos(id = 3, tipo = "Alto")
        )
    }

    var categoriaSelecionadaId by remember { mutableStateOf<Int?>(null) }

    Column {
        TipoDropdown(
            tipo = categorias,
            onTipoSelecionado = { id ->
                categoriaSelecionadaId = id
                // Aqui você tem o ID da categoria selecionada
                println("Categoria selecionada ID: $id")
            }
        )

        // Exemplo de como usar o ID selecionado
        categoriaSelecionadaId?.let { id ->
            Text(
                text = "ID selecionado: $id",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


