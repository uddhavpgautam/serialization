import kotlinx_json_serialization.constructApartmentsKotlinX
import kotlinx_json_serialization.readFile

fun main() {
    val fileJsonString = readFile("./src/main/java/kotlinx_json_serialization/ApartmentListWithKeyX.json")
    constructApartmentsKotlinX(fileJsonString)
}