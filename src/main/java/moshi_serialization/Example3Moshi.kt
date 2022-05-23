package moshi_serialization

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Example3Moshi {
    data class Label(val url: String, val id: Long, val name: String)
}

private val jsonString: String = """
	[
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
    """.trimIndent()

fun main() {
    val moshi = Moshi.Builder()
        .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
        .build()

    val listType = Types.newParameterizedType(List::class.java, Example3Moshi.Label::class.java)
    val labelAdapter: JsonAdapter<List<Label>> = moshi.adapter(listType)
    val label = labelAdapter.fromJson(jsonString)
    println(label)
}