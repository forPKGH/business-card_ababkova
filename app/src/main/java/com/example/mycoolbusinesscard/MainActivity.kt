package com.example.mycoolbusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoolbusinesscard.ui.theme.MyCoolBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoolBusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            MainInfoBlock()
        }
        ContactsBlock()
    }
}

@Composable
fun MainInfoBlock(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Photo(img = painterResource(R.drawable.business_card_photo), contentDescription = stringResource(R.string.worker_name), modifier = Modifier
            .height(150.dp)
            .width(200.dp))
        Text(text = stringResource(R.string.worker_name), fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
        Text(text = stringResource(R.string.job), fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ContactsBlock(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        IconTextRow(text = stringResource(R.string.phone_number), icon = painterResource(R.drawable.phone))
        IconTextRow(text = stringResource(R.string.social_media), icon = painterResource(R.drawable.max))
        IconTextRow(text = stringResource(R.string.email), icon = painterResource(R.drawable.email))
    }
}

@Composable
fun Photo(img: Painter, modifier: Modifier = Modifier, contentDescription: String) {
    Image(
        painter = img,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun IconTextRow(text: String, icon: Painter, modifier: Modifier = Modifier, fontSize: TextUnit = 16.sp, contentDescription:String? = null) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(32.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier.width(32.dp)
        )
        Text(
            text = text,
            fontSize = fontSize,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCoolBusinessCardTheme {
        BusinessCard()
    }
}