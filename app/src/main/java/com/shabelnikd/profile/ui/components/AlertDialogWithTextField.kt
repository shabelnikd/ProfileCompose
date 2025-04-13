package com.shabelnikd.profile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertDialogWithTextField(
    showDialog: MutableState<Boolean>,
    onConfirm: (String, String) -> Unit,
    onDismiss: () -> Unit
) {
    val textState = remember { mutableStateOf("") }
    val additionalTextState = remember { mutableStateOf("") }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Введите имя") },
            text = {
                Column(Modifier.fillMaxWidth()) {
                    TextField(
                        value = textState.value,
                        onValueChange = { textState.value = it },
                        label = { Text("Имя пользователя") }
                    )
                    Spacer(Modifier.size(10.dp))
                    TextField(
                        value = additionalTextState.value,
                        onValueChange = { additionalTextState.value = it },
                        label = { Text("Описание пользователя") }
                    )
                }
            },
            confirmButton = {
                StyledButton(
                    modifier = Modifier,
                    onClick = {
                        onConfirm(textState.value, additionalTextState.value)
                        showDialog.value = false
                        textState.value = ""
                    }
                ) {
                    Text("Подтвердить")
                }
            },
            dismissButton = {
                StyledButton(
                    modifier = Modifier,
                    onClick = {
                        showDialog.value = false
                        onDismiss()
                    }
                ) {
                    Text("Отмена")
                }
            },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        )
    }
}