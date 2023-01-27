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

    val token = "ea_RfIL5TVSgSQRqbS3AmN:APA91bGTYb_fDamLncejnXjsthSUCmykjQq3AGWDWtR_dorVkqyLa1H-8BWfPSPCDM51Ijoj-eCc-8xJZuz7dg2k9KEahE6d_pVqHiAb_Ettd6SLhdQKlfKdXyMK0lMB3g0pt6egndgb"
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "postId": 2,
          "postAuthor": "Вася",
          "text": "Дождик-дождичек, ау! Это я тебя зову. Кап-кап-кап, тарам-пам-пам! Нужен дождичек грибам! Дождик-дождичек, ау! Это я тебя зову, Чтоб грибочкам вырасти… Нужно больше сырости. Ау… Ау… Я дождик, дождик, дождичек зову! Пайрам, Па-пара-пам Ну очень нужен дождичек грибам! Ау… Ау… Я дождик, дождик, дождичек зову! Парам, па-пам Я знаю нужен дождичек грибам! Ау… Ау… Я дождик, дождик, дождичек зову! Ля-ля, Ля-ля Грибочкам очень хочется дождя! Ау… Ау… Эй дождик, я тебя зову! Везде, везде В лесу грибы мечтают о дожде! Ау… Ау… Я дождик, дождичек зову! Ееее, вездее В лесу грибы мечтают о дожде! ЕЕЕЕЕЕЕЕ!"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}