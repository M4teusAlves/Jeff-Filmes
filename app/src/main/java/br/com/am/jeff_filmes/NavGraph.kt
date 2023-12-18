package br.com.am.jeff_filmes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.am.jeff_filmes.model.Banco

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    banco : Banco,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController, banco)
        }

        composable(
            route = Screen.Insert.route
        ){
            InsertScreen(navController = navController, banco)
        }

        composable(
            route = Screen.List.route
        ){
            ListScreen(navController = navController, banco)
        }

        composable(
            route = Screen.Update.route
        ){
            UpdateScreen(navController = navController, banco)
        }


    }
}