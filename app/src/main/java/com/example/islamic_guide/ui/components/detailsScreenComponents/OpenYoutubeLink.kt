import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.islamic_guide.model.Daee

 fun openYouTubeLink(context: Context, daee: Daee) {
    val url = if (daee.name == "أحمد ديدات") {
        "https://www.youtube.com/@Deedat10/videos"
    } else {
        daee.youtubeLink
    }

    url?.let {
        // Ensure the URL starts with "http://" or "https://"
        val validUrl = if (!it.startsWith("http://") && !it.startsWith("https://")) {
            "https://$it"
        } else {
            it
        }

        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(validUrl)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            // Check if there's an app to handle the intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                // No app found to handle the link
                Toast.makeText(context, "No app found to handle this link. Please install a browser or the YouTube app.", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to open the link. Please try again.", Toast.LENGTH_SHORT).show()
        }
    } ?: run {
        // Handle the case where the URL is null
        Toast.makeText(context, "No YouTube link available for this Daee.", Toast.LENGTH_SHORT).show()
    }
}