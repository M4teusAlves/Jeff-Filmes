package br.com.am.jeff_filmes

sealed class Screen(val route:String){
    object Home: Screen("home_screen")
    object Insert: Screen("insert_screen")
    object List: Screen("list_screen")
    object Update: Screen("update_screen")
}