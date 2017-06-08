package Data

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText


data class Event(@JacksonXmlProperty(localName="id") val id: Long = 0,
                 @JacksonXmlProperty(localName="nom") val name: String = "",
                 @JacksonXmlProperty(localName="nom_curt") val shortName: String = "",
                 @JacksonXmlProperty(localName="alerta") val alert: String? = "",
                 @JacksonXmlProperty(localName="lloc_simple") val place: Place? = Place(),
                 @JacksonXmlProperty(localName="tipus_acte") val type: String = "",
                 @JacksonXmlProperty(localName="rellevant") val rellevancy: String = "",
                 @JacksonXmlProperty(localName="estat") val status: String = "",
                 @JacksonXmlProperty(localName="estat_cicle") val statusCycle: String = "",
                 @JacksonXmlProperty(localName="data") val data: Data = Data(),
                 @JacksonXmlProperty(localName="classificacions") val classi: List<Classification>?)

data class Place(@JacksonXmlProperty(localName="id") val id: Long = 0,
                 @JacksonXmlProperty(localName="nom") val name: String = "",
                 @JacksonXmlProperty(localName="adreca_simple") val address: Address? = Address())

data class Data(@JacksonXmlProperty(localName="data_inici") val dataInici: String? = "",
                @JacksonXmlProperty(localName="hora_inic") val startHour: String? = "",
                @JacksonXmlProperty(localName="data_proper_acte") val dataNextActe: String? = "",
                @JacksonXmlProperty(localName="data_fi") val dataFi: String? = "")

data class Classification(@JacksonXmlProperty(localName="codi") val codi:Float? = 0f,
                          @JacksonXmlProperty(localName="nivell") @JacksonXmlText() val level: String? = "")

data class Address(@JacksonXmlProperty(localName="carrer") val street: Carrer? = Carrer(),
                   @JacksonXmlProperty(localName="numero") val streetNum: Numero? = Numero(),
                   @JacksonXmlProperty(localName="districte") val district: District? = District(),
                   @JacksonXmlProperty(localName="codi_postal") val postal: String? = "",
                   @JacksonXmlProperty(localName="municipi") val municipi: Town? = Town(),
                   @JacksonXmlProperty(localName="barri") val neighbourhood: Neighbourhood? = Neighbourhood(),
                   @JacksonXmlProperty(localName="coordenades") val coords: Coords? = Coords())

data class Coords(@JacksonXmlProperty(localName="geocodificacio") val geocoords: Geocoords = Geocoords(),
                  @JacksonXmlProperty(localName="googleMaps") val gMaps: GMaps = GMaps())

data class Carrer(@JacksonXmlProperty(localName="codi", isAttribute = true) val code: String? = "",
                  @JacksonXmlProperty(localName="carrer") @JacksonXmlText() val street: String? = "")

data class Numero(@JacksonXmlProperty(localName="davant", isAttribute = true) val front: Int? = 0,
                  @JacksonXmlProperty(localName="enter", isAttribute = true) val enter: String? = "",
                  @JacksonXmlProperty(localName="numero") @JacksonXmlText() val number: Int? = 0)

data class District(@JacksonXmlProperty(localName="codi", isAttribute = true) val code: String? = "",
                    @JacksonXmlProperty(localName="districte") @JacksonXmlText() val district: String? = "")

data class Town(@JacksonXmlProperty(localName="codi", isAttribute = true) val code: String? = "",
                @JacksonXmlProperty(localName="municipi") @JacksonXmlText() val town: String? = "")

data class Neighbourhood(@JacksonXmlProperty(localName="codi", isAttribute = true) val code: String? = "",
                @JacksonXmlProperty(localName="barri") @JacksonXmlText() val neighbourhood: String? = "")

data class Geocoords(@JacksonXmlProperty(localName="x", isAttribute = true) val x: Float = 0.0f,
                     @JacksonXmlProperty(localName="y", isAttribute = true) val y: Float = 0.0f)

data class GMaps(@JacksonXmlProperty(localName="lat", isAttribute = true) val lat: Float = 0.0f,
                  @JacksonXmlProperty(localName="lon", isAttribute = true) val lon: Float = 0.0f)