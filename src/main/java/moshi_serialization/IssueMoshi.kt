package moshi_serialization

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import java.nio.file.Files
import java.nio.file.Path
import java.util.*


data class Issue(
    val url: String,
    val id: Long,
    val number: Long,
    val title: String,
    val labels: List<Label> = listOf<Label>(),
    val milestone: Milestone?,
    val assignees: List<User> = listOf<User>(),
    val state: State,
    val comments: Long = 0L,
    @Json(name = "created_at") val createdAt: Date,
    @Json(name = "closed_at") val closedAt: Date?,
    val body: String = ""
)

enum class State {
    @Json(name = "open") OPEN,
    @Json(name = "closed") CLOSED
}

data class Label(
    val url: String,
    val id: Long,
    val name: String,
    val color: String = "46DF1B"
)

data class Milestone(
    val url: String,
    val id: Long,
    val title: String,
    val creator: User,
    @Json(name = "open_issues") val openCount: Long = 0L,
    @Json(name = "closed_issues") val closedCount: Long = 0L,
    @Json(name = "created_at") val createdAt: Date,
    @Json(name = "due_on") val dueOn: Date?
)

data class User(val url: String, val login: String)

fun readFile(file: String?): String {
    return Files.readString(file?.let { Path.of(it) })
}

fun constructIssueMoshi(fileJsonString: String?) {
    if (fileJsonString != null) {
        val moshi = Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .add(Date::class.java, com.squareup.moshi.adapters.Rfc3339DateJsonAdapter().nullSafe())
            .build()

        val issueAdapter = moshi.adapter(Issue::class.java)
        val issue = issueAdapter.fromJson(fileJsonString)

        println(issue)
    }

}
