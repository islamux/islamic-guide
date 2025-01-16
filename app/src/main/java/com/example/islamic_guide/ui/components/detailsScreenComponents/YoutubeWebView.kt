import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun YouTubeWebView(url: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient() // Handle page navigation within the WebView
                settings.javaScriptEnabled = true // Enable JavaScript for YouTube
                loadUrl(url) // Load the YouTube URL
            }
        },
        update = { webView ->
            webView.loadUrl(url) // Update the WebView if the URL changes
        }
    )
}