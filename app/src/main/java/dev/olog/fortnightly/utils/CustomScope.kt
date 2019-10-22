package dev.olog.fortnightly.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@Suppress("FunctionName")
fun CustomScope(dispatcher: CoroutineDispatcher): CoroutineScope =
    CoroutineScope(SupervisorJob() + dispatcher)