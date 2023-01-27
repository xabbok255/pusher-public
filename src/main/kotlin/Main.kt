import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main(args: Array<String>) {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("gsa.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val token = "doE2v71VTgC9AfrKPa1fel:APA91bHN-Ulk-J6WWzGaCJ03m5bCD5B_xJ67YxLCGCQCL3DxiiIYhFhfkCYhwtPCDIgouhmjQNk-Xu7dq_x6exlGpFGE5qxL-azDxziUIXoC3TbhkfInGatEL-FdNCnRZthT8LZGwTJk"
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Петя",
          "postId": 2,
          "postAuthor": "Вася"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}