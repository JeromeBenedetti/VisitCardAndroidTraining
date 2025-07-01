package com.example.visitcardandroidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcardandroidtraining.ui.theme.VisitCardAndroidTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modifier = Modifier
        enableEdgeToEdge()
        setContent {
            VisitCardAndroidTrainingTheme {
                Scaffold(modifier = modifier.fillMaxSize(),
                    containerColor = colorResource(R.color.lightgreen)) { innerPadding ->
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        NameBlock(modifier.padding(top = 280.dp))
        FooterBlock(modifier.padding(bottom = 40.dp))
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    val logo: Painter = painterResource(R.drawable.android_logo)

    Image(
        painter = logo,
        contentDescription = null,
        modifier = modifier.background(colorResource(R.color.darkbluegreen)),
    )
}

@Composable
fun NameBlock(modifier: Modifier = Modifier) {
    val nameSizeSp : TextUnit = 42.sp
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Logo(Modifier.padding(vertical = 3.dp)
            .width(120.dp)
            .aspectRatio(1f))
        Text(
            text = "Jérôme Benedetti",
            textAlign = TextAlign.Center,
            lineHeight = nameSizeSp,
            fontSize = nameSizeSp,
            fontWeight = FontWeight.W100,
            modifier = Modifier.padding(vertical = 3.dp),
        )
        Text(
            text = "Développeur Back-end et Mobile",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.darkgreen),
            modifier = Modifier.padding(top = 3.dp),
        )
    }
}

@Composable
fun FooterBlock(modifier: Modifier = Modifier) {
    val callLogo: Painter = painterResource(R.drawable.call_logo)
    val emailLogo: Painter = painterResource(R.drawable.email_logo)
    val shareLogo: Painter = painterResource(R.drawable.share_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        FooterRaw(callLogo, "+33 6 78 91 23 45")
        FooterRaw(shareLogo, "@AndroidDev", Modifier.padding(vertical = 16.dp))
        FooterRaw(emailLogo, "j.benett@mail.test")
    }
}

@Composable
fun FooterRaw(logo: Painter, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = logo,
            contentDescription = null,
            tint = colorResource(R.color.darkgreen),
        )
        Text(
            text = text,
            modifier = modifier.padding(start = 32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NameBlockPreview() {
    VisitCardAndroidTrainingTheme {
        Page()
    }
}
