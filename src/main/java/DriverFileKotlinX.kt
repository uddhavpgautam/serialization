import kotlinx_json_serialization.constructApartmentsKotlinX
import kotlinx_json_serialization.constructMenuKotlinX
import kotlinx_json_serialization.readFile
import kotlinx_json_serialization.readFileUsingBufferedReader

fun main() {
    val fileJsonString = readFile("./src/main/java/kotlinx_json_serialization/ApartmentListWithKeyX.json")
    constructApartmentsKotlinX(fileJsonString)

    val fileJsonString1 = readFileUsingBufferedReader("./src/main/java/kotlinx_json_serialization/dynamicMenu.json")
    constructMenuKotlinX(fileJsonString1)
}