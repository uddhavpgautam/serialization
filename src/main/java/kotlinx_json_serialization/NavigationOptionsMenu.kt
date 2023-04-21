package kotlinx_json_serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class NavigationMenuData {

    @Serializable
    data class MenuData<T>(val data: T)
    @Serializable
    data class MenuList<T>(val type: String, val menu_items: T)

    @Serializable
    data class Menu(
        val id: String, val name: String, val onclick: String
    )
}

fun readFileUsingBufferedReader(file: String?): String {
    val text = StringBuilder()
    try {
        val br = file?.let { FileReader(it) }?.let { BufferedReader(it) }
        var line: String?
        while (br?.readLine().also { line = it } != null) {
            text.append(line)
            text.append('\n')
        }
        br?.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return text.toString()
    //return Files.readString(file?.let { Path.of(it) })
}

fun constructMenuKotlinX(fileJsonString: String?) {
    if (fileJsonString != null) {
        /*val deserializeDynamicMenu =
            Json.decodeFromString<
                    NavigationMenuData.MenuList<
                            List<
                                    NavigationMenuData.Menu
                                    >
                            >
                    >(fileJsonString)
        println(deserializeDynamicMenu.toString())*/
        /*
{
  "menus": [
    {
      "id": "nav_slideshow",
      "name": "Slideshow",
      "onclick": "SlidShowFragment"
    },
    {
      "id": "nav_slideshow",
      "name": "Slideshow",
      "onclick": "SlidShowFragment"
    },
    {
      "id": "nav_slideshow",
      "name": "Slideshow",
      "onclick": "SlidShowFragment"
    }
  ]
}*/

        val deserializeDynamicMenu =
            Json.decodeFromString<
                    NavigationMenuData.MenuData<
                            NavigationMenuData.MenuList<
                                    List<
                                            NavigationMenuData.Menu
                                            >
                                    >
                            >
                    >(fileJsonString)
        println(deserializeDynamicMenu.toString())
    }

}
