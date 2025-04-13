package com.shabelnikd.profile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shabelnikd.profile.R
import com.shabelnikd.profile.ui.components.AlertDialogWithTextField
import com.shabelnikd.profile.ui.components.StyledButton

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun ProfileScreen() {
    val showDialog = remember { mutableStateOf(false) }

    val fullName = remember { mutableStateOf("Данил Шабельник") }
    val username = remember { mutableStateOf("fsharp_dev") }
    val publicationsCount = remember { mutableStateOf("3") }
    val followersCount = remember { mutableStateOf("70") }
    val followingCount = remember { mutableStateOf("43") }
    val userAboutText =
        remember { mutableStateOf("Не пользуюсь инстой, поэтому она пустая :)") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = username.value, fontWeight = FontWeight.Bold) },
                windowInsets = WindowInsets(top = 20.dp)
            )
        }
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 10.dp)
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "Profile image",
                )

                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Text(fullName.value, fontSize = 14.sp, fontWeight = FontWeight.Bold)

                    Spacer(Modifier.size(width = 0.dp, height = 5.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        val textSize = 12.sp
                        val textStyle = TextStyle(lineHeight = 16.sp)

                        Text(
                            text = "${publicationsCount.value}\nпубликации",
                            fontSize = textSize,
                            style = textStyle

                        )
                        Text(
                            text = "${followersCount.value}\nподписчики",
                            fontSize = textSize,
                            style = textStyle
                        )
                        Text(
                            text = "${followingCount.value}\nподписки",
                            fontSize = textSize,
                            style = textStyle
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(10.dp))
            Text(userAboutText.value, fontSize = 14.sp)

            StyledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showDialog.value = true },
                content = {
                    Text("Редактировать профиль", fontSize = 14.sp)
                }
            )

            AlertDialogWithTextField(
                showDialog = showDialog,
                onConfirm = { text ->
                    fullName.value = text
                },
                onDismiss = {}
            )


        }
    }
}