package Data

import com.fasterxml.jackson.dataformat.xml.annotation.*


data class Event(@JacksonXmlProperty(localName="id") val id: Float,
                @JacksonXmlProperty(localName="nom") val name: String,
                @JacksonXmlProperty(localName="nom_curt") val shortName: String,
                @JacksonXmlProperty(localName="alerta") val alert: String,
                @JacksonXmlProperty(localName="lloc_simple") val place: Place?,
                @JacksonXmlProperty(localName="tipus_acte") val type: String,
                @JacksonXmlProperty(localName="rellevant") val rellevancy: String,
                @JacksonXmlProperty(localName="estat") val status: String,
                @JacksonXmlProperty(localName="estat_cicle") val statusCycle: String,
                @JacksonXmlProperty(localName="data")val data: Data)

//                @JacksonXmlProperty(localName = "classificacions") val classi: List<Classification>)


data class Place(@JacksonXmlProperty(localName = "id") val id: Float,
                 @JacksonXmlProperty(localName = "nom") val name: String,
                 @JacksonXmlProperty(localName = "adreca_simple")val address: Address)

data class Data(@JacksonXmlProperty(localName = "data_inici")val dataInici: String?,
                @JacksonXmlProperty(localName = "hora_inic")val startHour: String?,
                @JacksonXmlProperty(localName = "data_proper_acte")val dataNextActe: String?,
                @JacksonXmlProperty(localName = "data_fi")val dataFi: String?)

data class Classification(@JacksonXmlProperty(localName="codi", isAttribute=true) val codi:Float,
        @JacksonXmlProperty(localName="nivell") val level: String)

data class Address(@JacksonXmlProperty(localName = "carrer")val street: String,
                   @JacksonXmlProperty(localName = "numero.enter", isAttribute = true)val streetNum: Int,
                   @JacksonXmlProperty(localName = "districte")val district: String,
                   @JacksonXmlProperty(localName = "codi_postal")val postal: Int,
                   @JacksonXmlProperty(localName = "municipi")val municipi: String,
                   @JacksonXmlProperty(localName = "barri")val neighbourhood: String,
                   @JacksonXmlProperty(localName = "coordenades")val coords: Coords)


data class Street(@JacksonXmlElementWrapper(localName = "carrer")val name: String,
                  @JacksonXmlProperty(localName = "codi", isAttribute = true) val code: Int)

data class StreetNum(@JacksonXmlProperty(localName = "numero")val name: String,
                     @JacksonXmlProperty(localName = "davant")val front: Int,
                     @JacksonXmlProperty(localName = "enter")val enter: Int)

data class District(@JacksonXmlProperty(localName = "districte")val name: String,
                  @JacksonXmlProperty(localName = "codi")val code: Int)

data class Municipi(@JacksonXmlProperty(localName = "municipi")val name: String,
                    @JacksonXmlProperty(localName = "codi")val code: Int)

data class Neighbourhood(@JacksonXmlProperty(localName = "barri")val name: String,
                    @JacksonXmlProperty(localName = "codi")val code: Int)

data class Coords(@JacksonXmlProperty(localName="geocodificacio") val geoCode: GeoCode,
                  @JacksonXmlProperty(localName="googleMaps") val gMaps: GMaps)

data class GeoCode(@JacksonXmlProperty(localName="x", isAttribute=true) val x: Int,
                   @JacksonXmlProperty(localName="y", isAttribute=true) val y: Int)

data class GMaps(@JacksonXmlProperty(localName="lat", isAttribute=true) val lat: Float,
                 @JacksonXmlProperty(localName="lon", isAttribute=true) val lon: Float)