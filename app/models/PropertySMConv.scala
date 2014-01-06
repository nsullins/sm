package models

import play.api.libs.json._
//import play.api.libs.json.extensions.JsExtensions

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
      extensions.JsExtensions.buildJsObject(
        __ \ "PropertyAddress1" -> (__ \ "address" \ "address1")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyAddress2" -> (__ \ "address" \ "address2")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyCity" -> (__ \ "address" \ "cityname")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyState" -> (__ \ "address" \ "statename")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyStateCode" -> (__ \ "address" \ "statecode")(addJs).headOption.getOrElse(JsNull),
        __ \ "PropertyPostalCode" -> (__ \ "address" \ "postalcode")(addJs).headOption.getOrElse(JsNull)
      )
    }.getOrElse(JsNull)
  }

  def extractStringValueFromTopLevelJsElement(elementToExtract: String, solrElementName: String)(json: JsValue): JsValue = {
    extensions.JsExtensions.buildJsObject(
      __ \ solrElementName -> (__ \ elementToExtract)(json).headOption.getOrElse(JsNull)
    )
  }

  def floorplanTransformer = (
    (__ \ 'MinRent).json.copyFrom((__ \ 'rentRange))update(
      __.read[JsString].map{range => JsString(splitRentRange(formatRentRangeVal(range.value)).head)}
    )andThen
    (__ \ 'MaxRent).json.update(
      __.read[JsString].map{range => JsString(splitRentRange(formatRentRangeVal(range.value)).last)}
    )//andThen
//    (__ \ '
//      __.read[JsString]
//    )
  )

  def formatRentRangeVal(rentRange: String): String = rentRange.replaceAll("$", "").replaceAll(",", "")

  def splitRentRange(formattedRentRange: String): Seq[String] = formattedRentRange.split("-")

  def convertFloorplan(floorplan: JsValue): JsResult[JsObject] = {
    println("floorplan jsvalue is: " + floorplan)
    floorplan.transform(floorplanTransformer)
  }

  def loopOnFPOrUnitElement(json: JsValue): List[JsValue] = {

    val addressOpt = convertAddress((__ \ "address")(json))
    val shortDescription = extractStringValueFromTopLevelJsElement("shortDescription", "PropertyShortDescription")(json)
    val floorplans = (__ \ "floorplans")(json)
    Nil
  }
}

//val latitude = (__ \ "latitude")(json)
//val longitude = (__ \ "longitude")(json)
//val propertyKey = (__ \ "propertyKey")(json)
//val parkingType = (__ \ "parkingType")(json)
//val structureType = (__ \ "structureType")(json)


//TODO 1) convert to futures
//TODO 2) validate input Json with reads validator
//TODO 3) use macros?
//TODO 4) refactor iterate

//TODO 5) Gather requirements for changes to Mongo Result
//        a) Need to include Unit level data
//        b) Possibly add is_display flag to result
//        c) depending on strategy we should probably include all data and provide details about display status. Perhaps this should be an authenticated request?


/*
Links referenced

http://www.playframework.com/documentation/2.1.1/ScalaJson
http://www.playframework.com/documentation/2.1.1/ScalaJsonCombinators
http://www.playframework.com/documentation/2.1.1/ScalaJsonTransformers
http://www.playframework.com/documentation/2.1.1/ScalaJsonInception
http://www.playframework.com/documentation/2.1.1/ScalaJsonRequests
http://stackoverflow.com/questions/17596809/how-to-merge-a-jsvalue-to-jsobject-in-flat-level

 */
