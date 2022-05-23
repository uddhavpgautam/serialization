package moshi_serialization

import com.squareup.moshi.Moshi

class Example2Moshi {
    data class Label(val url: String, val id: Long, val name: String)
    data class Issue(val labels: List<Label> = listOf())
}

private val jsonString: String = """
      {
	    "labels": [
            {
                "url": "https://api.github.com/repos/square/okio/labels/enhancement",
                "id": 86454697,
                "name": "enhancement",
                "color": "84b6eb"
		    },
		    {
                "url": "https://api.github.com/repos/square/okio/labels/enhancement1",
                "id": 864546971,
                "name": "enhancement1",
                "color": "84b6eb1"
		    }
	    ]
    }
    """.trimIndent()

fun main() {
    val moshi = Moshi.Builder()
        .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
        .build()

    val issueAdapter = moshi.adapter(Example2Moshi.Issue::class.java)
    val issue = issueAdapter.fromJson(jsonString)

    println(issue)
}