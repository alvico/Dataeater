package Data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty



data class Event(@JsonProperty("id") val id: Long = 0,
                 @JsonProperty("nom") val name: String = "",
                 @JsonProperty("nom_curt") val shortName: String = "",
                 @JsonProperty("alerta") val alert: String? = "",
                 @JsonProperty("lloc_simple") val place: Place? = Place(),
                 @JsonProperty("tipus_acte") val type: String = "",
                 @JsonProperty("rellevant") val rellevancy: String = "",
                 @JsonProperty("estat") val status: String = "",
                 @JsonProperty("estat_cicle") val statusCycle: String = "",
                 @JsonProperty("data") val data: Data = Data(),
                 @JsonProperty("classificacions") val classi: List<Classification>?)


data class Place(@JsonProperty("id") val id: Long = 0,
                 @JsonProperty("nom") val name: String = "",
                 @JsonProperty("adreca_simple") val address: Address? = Address())

data class Data(@JsonProperty("data_inici") val dataInici: String? = "",
                @JsonProperty("hora_inic") val startHour: String? = "",
                @JsonProperty("data_proper_acte") val dataNextActe: String? = "",
                @JsonProperty("data_fi") val dataFi: String? = "")

data class Classification(@JsonProperty("codi") val codi:Float? = 0f,
                          @JsonProperty("nivell") val level: String? = "")


data class Address(@JsonProperty("carrer") val street: String? = "",
                   @JsonProperty("carrer.codi") val streetCode: String? = "",
                   @JsonProperty("numero.enter") val streetNum: Int? = 0,
                   @JsonProperty("districte") val district: String? = "",
                   @JsonProperty("districte.codi") val districtCode: String? = "",
                   @JsonProperty("codi_postal") val postal: String? = "",
                   @JsonProperty("municipi") val municipi: String? = "",
                   @JsonProperty("municipi.codi") val municipiCode: String? = "",
                   @JsonProperty("barri") val neighbourhood: String? = "",
                   @JsonProperty("barri.codi") val neighbourhoodCode: String? = "",
                   @JsonProperty("coordenades") val coords: Coords? = Coords())

data class Coords(@JsonProperty("geocodificacio.x") val x: Float = 0.0f,
                  @JsonProperty("geocodificacio.y") val y: Float = 0.0f,
                  @JsonProperty("googleMaps.lat") val lat: Float = 0.0f,
                  @JsonProperty("googleMaps.lon") val lon: Float = 0.0f)
