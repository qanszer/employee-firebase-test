package com.example.crud_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.crud_test.models.EmployeeApplication
import com.example.crud_test.navigation.AppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val emp = application as EmployeeApplication
            MaterialTheme {
                AppNavigation(emp.empRepository)
            }
        }
    }
}

// ==================================================================
//                        COUNTER APPLICATION
// ==================================================================
@Composable
fun CounterComposable() {
    var count by remember {
        mutableStateOf(value = 0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("My First Counter Application")
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Text("$count")
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Row {
            Button(onClick = {
                count++
            },
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(190.dp)
            ) {
                Text("Add (+)")
            }
            Button(onClick = {
                count--
            },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .width(190.dp)
            ) {
                Text("Subtract (-)")
            }
        }

    }
}


// ==================================================================
//                           USER PROFILE
// ==================================================================
@Composable
fun ProfileComposable() {
    val name = "John Steven Maluenda"
    val bio = "IT Student at Adamson University"
    val gmail = "maluendajohnsteven@gmail.com"
    val github = "https://github.com/qanszer"

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.nord_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(Color.Black.copy(alpha = 0.70f))
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(28.dp)
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.pfp),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        Color.White.copy(alpha = 0.4f),
                        CircleShape
                    ),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                )
                Text(
                    text = bio,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(top = 5.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "About Me",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp),
                )
                Text(
                    text = "I'm striving to become a web developer.\n" +
                            "Currently self studying through a free online course called The Odin Project.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 6.dp),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "If a college degree weren't such a necessary qualification for web developer jobs, " +
                            "I wouldn't have gone to college and would have focused entirely on The Odin Project. " +
                            "I certainly wouldn't miss dealing with mandatory, completely unrelated requirements " +
                            "like being forced to learn fluent Japanese for a minor subject, study networking and " +
                            "cybersecurity despite committing to a web development track, or learn a hundred " +
                            "different programming languages and not get deep in any one of them.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 6.dp),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "I also wouldn't miss paying 45-55k every semester just to use computer labs equipped with " +
                            "4GB RAM and slow HDD computers, along with so many other things that have unnecessarily " +
                            "wasted a massive amount of my time.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 24.dp),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Get in Touch",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp),
                )
                Text(
                    text = "Mail: $gmail",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                )
                Text(
                    text = "Github: $github",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                )
            }
        }
    }
}