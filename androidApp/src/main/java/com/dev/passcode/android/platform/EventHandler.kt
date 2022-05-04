package com.dev.passcode.android.platform

interface EventHandler<E> {
    fun obtainEvent( event : E )
}