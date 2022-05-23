import java.util.*


internal object HashMapByValues {
    @JvmStatic
    fun main(args: Array<String>) {
        val hashMap = HashMap<String, Int>()

        // enter data into hashmap
        hashMap["Math"] = 98
        hashMap["Data Structure"] = 85
        hashMap["Database"] = 91
        hashMap["Java"] = 95
        hashMap["Operating System"] = 79
        hashMap["Networking"] = 80
        println(hashMap.entries)
        //sorting of hashmap based on value
        val list = ArrayList<Map.Entry<String, Int>>(hashMap.entries)
        Collections.sort(list, java.util.Map.Entry.comparingByValue()) //1st way
        list.sortWith { (_, value1), (_, value2) -> value1.compareTo(value2) } //2nd way
        //3rd way
        Collections.sort(list,
            Comparator<Map.Entry<String, Int>> { (_, value), (_, value1) -> value.compareTo(value1) })
        println(list)
    }
}