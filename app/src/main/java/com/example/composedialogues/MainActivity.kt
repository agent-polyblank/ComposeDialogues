package com.example.composedialogues

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedialogues.components.SimpleAlertDialogWithReturnCallback
import com.example.composedialogues.ui.theme.MaterialDialoguesTheme




class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.onOpenDialogClicked()
        setContent {
            // Delegate to observe the showDialog state in viewModel
            val ctx = LocalContext.current.applicationContext
            val showDialogState: Boolean by viewModel.showDialog.collectAsState()

            MaterialDialoguesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SimpleAlertDialogWithReturnCallback(
                        show = showDialogState,
                        onDismiss = viewModel::onDialogDismiss,
                        onSubmit = {
                            viewModel.onDialogueSubmit(it)
                            Toast.makeText(ctx.applicationContext, it, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialDialoguesTheme {
        Greeting("Android")
    }
}