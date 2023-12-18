package br.com.am.jeff_filmes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.am.jeff_filmes.Screen
import br.com.am.jeff_filmes.model.Banco
import br.com.am.jeff_filmes.model.DAOFilme
import br.com.am.jeff_filmes.model.Filme
import br.com.am.jeff_filmes.model.Transition

@Composable
fun ListScreen(
    navController: NavController,
    banco: Banco
){
    val daoFilme = DAOFilme(banco)
    val lista = daoFilme.mostrarFilmes()

    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background){

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Row(
                modifier = Modifier
                    .background(Color(0, 0, 132), RectangleShape)
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {
                    navController.navigate(Screen.Home.route)
                })
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Jeff-Filmes", color = Color.White)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ){
                Text(fontSize = 30.sp,text = "Lista de Filmes")
                Spacer(modifier = Modifier.height(30.dp))
                if(lista.isEmpty()){
                    Text(fontSize = 15.sp,text = "Lista vazia!!!")
                }
                LazyColumn {
                    items(lista) { f -> item(f, banco, navController)}
                }
            }

        }


    }
}


@Composable
fun item(f:Filme, banco: Banco, navController: NavController){
    val daoFilme = DAOFilme(banco)
    Row(modifier = Modifier
        .height(150.dp)
        .width(300.dp)
        .border(1.dp, Color.Gray, RoundedCornerShape(5)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Column(){
            Text(text = "ID:")
            Text(text = f.id.toString())
            Text(text = "Título:")
            Text(text = f.titulo)

        }
        Spacer(modifier = Modifier.width(30.dp))
        Column(){
            Row {
                Icon(Icons.Rounded.Delete, contentDescription = null, modifier = Modifier.clickable {
                    daoFilme.excluirFilme(f)
                    navController.navigate(Screen.List.route)
                })
                Spacer(modifier = Modifier.width(30.dp))
                Icon(Icons.Rounded.Edit, contentDescription = null, modifier = Modifier.clickable {
                    Transition.contexto = "Atualizar"
                    Transition.filme = f

                    navController.navigate(Screen.Update.route)
                })
            }

            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "Valor:")
            Text(text = "R$ "+f.valor.toString())
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}