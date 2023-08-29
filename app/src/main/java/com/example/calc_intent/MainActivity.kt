package com.example.calc_intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc_intent.ui.theme.Calc_IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Home()



        }
    }
}

@Composable
fun Home() {
    val context = LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            //.color = Color(0xFFEFB8C8),
            .background(Color.Black)
    )
    {
        Text(
            text = "Calc Intent",
            //color = Color.Black,
            color = Color(0xFFEFB8C8),
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp
            )

//        IconButton(onClick = { /*TODO*/ })
//        {
//
//
//        }
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = { context.startActivity(android.content.Intent(context,CalculatorActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
            ) {
            Text(text = "calculator")

            
        }

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = {  context.startActivity(android.content.Intent(context,IntentActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Intent")
        }

    }


}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()

}