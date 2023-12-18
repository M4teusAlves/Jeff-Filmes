package br.com.am.jeff_filmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.am.jeff_filmes.model.Banco
import br.com.am.jeff_filmes.ui.theme.JeffFilmesTheme

class MainActivity : ComponentActivity() {

    lateinit var navController : NavHostController
    lateinit var banco: Banco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JeffFilmesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    banco = Banco(applicationContext)
                    navController = rememberNavController()
                    SetupNavGraph(navController, banco)
                }
            }
        }
    }
}

