package br.com.am.jeff_filmes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.am.jeff_filmes.model.Transition

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertScreen(
    navController: NavController,
    banco:Banco_imoveis
){
    var titulo by remember{ mutableStateOf("") }

    var text by remember{ mutableStateOf("") }





    var tamanho by remember { mutableStateOf(0) }



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
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){

                Text(fontSize = 30.sp,text = Transition.contexto +" Filme")
                Spacer(modifier = Modifier.height(30.dp))



                TextField(
                    value = endereco,
                    onValueChange = {endereco = it},
                    placeholder = { Text(text = "Endereço")}
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = titulo,
                    onValueChange = {titulo = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "Titulo")}
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = text,
                    onValueChange = {text = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = { Text(text = "Valor de Aluguel")}
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {

                    if(!matricula.equals("") && !endereco.equals("") && !text.equals("") && Transition.inquilino != null && Transition.proprietario != null){
                        if(daoImovel.inserirImovel(Imovel(matricula, endereco, text.toDouble(), Transition.proprietario!!, Transition.inquilino!!))){
                            daoProprietario.inserirProprietario(Transition.proprietario!!)
                            daoInquilino.inserirInquilino(Transition.inquilino!!)
                            Transition.inquilino = null
                            Transition.proprietario = null
                            Transition.tipo=""
                            Transition.contexto=""
                            navController.navigate(Screen.Home.route)
                        }

                        aviso = "Matrícula já utilizado!!!"
                        tamanho = 10
                    }else{
                        tamanho = 10
                        aviso = "Preencha todos os campos!!!"
                    }



                }) {
                    Text(text = "Cadastrar")
                }

                Spacer(modifier = Modifier.height(30.dp))
                Box(modifier = Modifier
                    .background(Color.Red)){

                    Text(text = aviso, color =  Color.White)

                }
            }

        }
    }


}