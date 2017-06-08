package Data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStreamReader
import java.net.URL
import javax.xml.stream.XMLInputFactory
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.sun.javaws.exceptions.ExitException
import org.elasticsearch.client.RestClient
import org.apache.http.HttpHost
import org.apache.http.entity.ContentType
import org.apache.http.nio.entity.NStringEntity

fun main(args: Array<String>) {
    val url = URL("http://w10.bcn.es/APPS/asiasiacache/peticioXmlAsia?id=199")
    val f = XMLInputFactory.newFactory()
    val info = InputStreamReader(url.openStream())
    val sr = f.createXMLStreamReader(info)
    val mapper = XmlMapper()

    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
    mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
    mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    val restClient = RestClient.builder(HttpHost("127.0.0.1", 9200, "http")).build()

    while (sr.hasNext()) {
        sr.next()
        if (sr.isStartElement) {
            if(sr.localName.equals("acte")) {
                try {
                    val acte = mapper.readValue(sr, Event::class.java)

                    val jsonActe = ObjectMapper().writeValueAsString(acte)
                    println(jsonActe)
                    val entity = NStringEntity(jsonActe, ContentType.APPLICATION_JSON)
                    println(restClient.performRequest("POST", "/index/type/", emptyMap<String, String>(), entity))
                } catch (e: ExitException) {
                    println(e.message)
                }
            }
        }
    }

    info.close()
}

