import moshi_serialization.constructIssueMoshi
import moshi_serialization.readFile

fun main() {
    val fileJsonString = readFile("./src/main/java/moshi_serialization/Issue.json")
    constructIssueMoshi(fileJsonString)
}