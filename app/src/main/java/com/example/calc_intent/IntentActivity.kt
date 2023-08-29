package com.example.calc_intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.calc_intent.ui.theme.Calc_IntentTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            IntentContent()


        }
    }
}

@Composable
fun IntentContent() {
    val context = LocalContext.current

    Column(
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
            color = Color(0xFF6650a4),
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                context.startActivity(takePictureIntent,Bundle(1))
            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Camera")


        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254799015354"))

                if (ContextCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    context.startActivity(intent)
                }
                      },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Call")


        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "STK")


        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val uri = Uri.parse("sms to:07456789")

                val intent = Intent(Intent.ACTION_SENDTO, uri)

                intent.putExtra("Hello", "How is today's weather")

                context.startActivity(intent)},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Text")


        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
                      },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "share")


        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "alexmainer31@gmail.com", null))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

                context.startActivity(Intent.createChooser(emailIntent, "Send email..."))
                      },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "email")


        }
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val phone = "+34666777888"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                context.startActivity(intent)
                      },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "dial")


        }
    }
}




@Preview(showBackground = true)
@Composable
fun IntentContentPreview() {
    IntentContent()

}