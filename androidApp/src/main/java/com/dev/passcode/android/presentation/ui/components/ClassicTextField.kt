package com.dev.passcode.android.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.passcode.android.presentation.ui.theme.AppTheme

@Composable
fun ClassicTextField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions : KeyboardOptions = KeyboardOptions()
    ) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    color = AppTheme.colors.primaryTextColor,
                    fontSize = 12.sp
                )
            )
        },
        shape = RoundedCornerShape(4.dp),
        colors= TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.secondaryBackground,
            textColor = AppTheme.colors.primaryTextColor,
            cursorColor = AppTheme.colors.primaryBrandColor,
            focusedIndicatorColor = AppTheme.colors.primaryBrandColor,
            disabledIndicatorColor = AppTheme.colors.primaryBackground,
            errorIndicatorColor = AppTheme.colors.primaryWarningColor,
            unfocusedIndicatorColor = AppTheme.colors.primaryBackground,
        ),
        onValueChange = onValueChange
    )
}


@Preview
@Composable
fun ClassicTextFieldPreview() {
    ClassicTextField(
        placeholder = "Full name",
        value = "Agafonov",
        onValueChange = {}
    )
}