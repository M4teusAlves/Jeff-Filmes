package br.com.am.jeff_filmes.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Send
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
import androidx.navigation.NavController
import br.com.am.jeff_filmes.Screen
import br.com.am.jeff_filmes.model.Banco
import br.com.am.jeff_filmes.model.Transition

@Composable
fun HomeScreen(
    navController: NavController,
    banco : Banco,
){


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {



        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            Row (modifier = Modifier
                .background(Color(97, 47, 116), RectangleShape)
                .fillMaxWidth()
                .height(50.dp)
                .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically){
                Text(text = "Jeff-imóveis", color = Color.White)
            }
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(10.dp), verticalAlignment = Alignment.CenterVertically) {



                    Icon(Icons.Filled.AccountCircle, contentDescription = null, modifier = Modifier
                        .height(100.dp)
                        .width(100.dp))

                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Seja bem-vindo Jefferson")
//
                }
                Row (){
                    Botao(texto = "   Criar\nLocação", paint = Icons.Filled.Home, nav = navController, route = Screen.Insert.route, "Cadastrar")
                    Botao(texto = "  Minhas\nLocações", paint = Icons.Filled.List, nav = navController, route = Screen.List.route, "Cadastrar")

                }


            }

        }

    }
}

@Composable
fun Botao(texto:String, paint: ImageVector, nav:NavController, route:String, contexto:String, ){
    Column(modifier = Modifier
        .height(120.dp)
        .width(100.dp)
        .clickable {
            nav.navigate(route)
            Transition.contexto = contexto

        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box (modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .background(Color(220, 220, 220), CircleShape),){
            Icon(paint , contentDescription = null, modifier = Modifier.fillMaxSize())
        }

        Text(text = texto)


    }
}