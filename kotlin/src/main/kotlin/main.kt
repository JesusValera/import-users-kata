import org.json.JSONObject
import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val USER_URL = "https://randomuser.me/api/?inc=gender,name,email,location&results=5&seed=a9b25cd955e2037h"

    val classLoader = object {}.javaClass
    val stream = classLoader.getResourceAsStream("users.csv")
    val csv_providers: ArrayList<Array<String>> = ArrayList()
    val csvFile: Scanner = Scanner(stream)
    while (csvFile.hasNextLine()) {
        val line = csvFile.nextLine()
        // fields: ID, gender, Name ,country, postcode, email, Birthdate
        val attributes: Array<String> = line.split(",").toTypedArray()
        if (attributes.size == 0) {
            continue;
        }
        csv_providers.add(attributes)
    }
    val csvProviers: List<List<String>> = ArrayList()
    var a: ArrayList<String> = ArrayList()
    for (i in 0 until a.size step 1) {
        a.add(csvProviers.get(i)[0])
    }
    csv_providers.removeAt(0) // Remove header column

    // Parse URL content
    val url = USER_URL;
    val command = "curl -X GET " + url
    val processBuilder = ProcessBuilder(command.split(" "))
    val process = processBuilder.start()
    val iStream = process.inputStream
    val webProvider = Scanner(iStream)
    var result = ""
    while (webProvider.hasNextLine()) {
        result += webProvider.nextLine()
    }
    webProvider.close()

    val jsonObject = JSONObject(result)
    val results = jsonObject.getJSONArray("results")
    a = ArrayList()
    for (i in a.indices) {
        a.add(results.getString(i))
    }

    var j = BigInteger("100000000000")
    val b = ArrayList<Array<String>>()
    for (i in 0 until results.length()) {
        j = j.add(BigInteger("1"))
        b.add(
            arrayOf(
                j.toString(),  // id
                results.getJSONObject(i).getString("gender"),
                results.getJSONObject(i).getJSONObject("name").getString("first") + " " + results.getJSONObject(i)
                    .getJSONObject("name").getString("last"),
                results.getJSONObject(i).getJSONObject("location").getString("country"),
                results.getJSONObject(i).getJSONObject("location")["postcode"].toString(),
                results.getJSONObject(i).getString("email"),
                GregorianCalendar()[Calendar.YEAR].toString()
            )
        )
    }

    /**
     * csv_providers ArrayList<id: number,
     *       email: string
     *       first_name: string
     *       last_name: string>
     */
    csv_providers.addAll(b)

    println("*********************************************************************************")
    println("* ID\t\t\t* COUNTRY\t\t* NAME\t\t\t\t* EMAIL\t\t\t\t\t\t*")
    println("*********************************************************************************")
    for (item in csv_providers) {
        println(String.format("* %s\t* %s\t\t* %s\t\t* %s\t*", item[0], item[3], item[2], item[5]))
    }
    println("*********************************************************************************")
    println(csv_providers.size.toString() + " users in total!")

}