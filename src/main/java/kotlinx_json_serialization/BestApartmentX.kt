package kotlinx_json_serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Path

class BestApartment {
    //each apartment has several types of amenities
    @Serializable
    data class Apartment(
        val gym: String, val school: String, val store: String, val office: String
    )

    //T is List<BestApartment.Apartment>
    @Serializable
    data class ApartmentList<T>(val apartments: T)

    val reqAmenities = mutableListOf("gym", "school", "store")

}

fun readFile(file: String?): String {
    return Files.readString(file?.let { Path.of(it) })
}

fun constructApartmentsKotlinX(fileJsonString: String?) {
    if (fileJsonString != null) {
        //val deserializedStringApartmentListNoKey = Json.decodeFromString<List<kotlin_json_serialization.BestApartment.Apartment>>(fileJsonString)
        //val deserializedStringApartmentCore = Json.decodeFromString<kotlin_json_serialization.BestApartment.Apartment>(fileJsonString)
        val deserializedStringApartmentListWithKey =
            Json.decodeFromString<BestApartment.ApartmentList<List<BestApartment.Apartment>>>(fileJsonString)

        println(deserializedStringApartmentListWithKey)
    }

}