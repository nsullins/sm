package models

import play.api.libs.json._
import play.api.libs.json.extensions.JsExtensions

/**
 * Created with IntelliJ IDEA.
 * User: sun
 * Date: 7/7/13
 * Time: 3:15 PM
 */
object PropertySMConv {

  def convertMongoToSolr(mongoJson: Option[String]): List[JsValue] = {
    mongoJson.map(json =>loopOnFPOrUnitElement(Json.parse(json))).getOrElse(Nil)
  }

  def convertAddress(address: List[JsValue]): JsValue = {
    address.headOption.map{addJs =>
      JsExtensions.buildJsObject(
        __ \ "PropertyAddress1" -> (__ \ "address" \ "address1")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyAddress2" -> (__ \ "address" \ "address2")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyCity" -> (__ \ "address" \ "cityname")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyState" -> (__ \ "address" \ "statename")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyStateCode" -> (__ \ "address" \ "statecode")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyPostalCode" -> (__ \ "address" \ "postalcode")(addJs).headOption.getOrElse(JsNull)
      )
    }.getOrElse(JsNull)
  }

  def loopOnFPOrUnitElement(json: JsValue): List[JsValue] = {

    val addressOpt = convertAddress((__ \ "address")(json))
    val shortDescription = (__ \ "shortDescription")(json)
    val latitude = (__ \ "latitude")(json)
    val longitude = (__ \ "longitude")(json)
    val propertyKey = (__ \ "propertyKey")(json)
    val parkingType = (__ \ "parkingType")(json)
    val structureType = (__ \ "structureType")(json)






    val floorplans = (__ \ "floorplans")(json)
    Nil
  }
}



//    First re-read the mandubian blog to understand the API better
//    1) The floorplans will be the root loop element
//    2) This method will need to reformat the floorplans json to the Solr format
//    3) Get it to work and then look into refactoring.
