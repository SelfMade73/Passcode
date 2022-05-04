package com.dev.passcode.android.presentation.ui.components

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.passcode.android.presentation.ui.theme.AppTheme

@Composable
fun ClassicCheckBox(
    checked : Boolean,
    onCheckedChange : (Boolean) -> Unit,
    modifier : Modifier = Modifier
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        colors = CheckboxDefaults.colors(
            checkedColor = AppTheme.colors.primaryBrandColor,
            uncheckedColor = AppTheme.colors.primaryDisabledColor
        )
    )
}