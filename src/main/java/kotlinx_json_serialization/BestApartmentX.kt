package kotlinx_json_serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Path

class BestApartment {
    @Serializable
    data class ApartmentList<T>(val apartments: T)
    @Serializable
    data class Apartment(
        val gym: String, val school: String, val store: String, val office: String
    )
}

fun readFile(file: String?): String {
    return Files.readString(file?.let { Path.of(it) })
}

fun constructApartmentsKotlinX(fileJsonString: String?) {
    if (fileJsonString != null) {
        val deserializedStringApartmentListWithKey =
            Json.decodeFromString<
                    BestApartment.ApartmentList<
                            List<
                                    BestApartment.Apartment
                                    >
                            >
                    >(fileJsonString)
        println(deserializedStringApartmentListWithKey.toString())
    }

}