import org.specs2.mutable._
import models._

import play.api.libs.json._

/**
 * Created with IntelliJ IDEA.
 * User: sun
 * Date: 7/7/13
 * Time: 2:48 PM
 */
class PropertySMConvSpec extends Specification {


  "Property transformation from mongo to solr" should {

    "return None when null or empty string is passed" in{
      PropertySMConv.convertMongoToSolr(None) must_== Nil
    }

    val addressMJs = """{"address": {
                           "address1": "123 Apartment Demo Street",
                           "address2": "STE. 1102",
                           "statecode": "mo",
                           "statename": "Missouri",
                           "cityname": "Rosebud",
                           "postalcode": "63091"
                         }
                       }"""

    val addressSJs = Json.obj(
      "PropertyAddress1" -> "123 Apartment Demo Street",
      "PropertyAddress2" -> "STE. 1102",
      "PropertyStateCode" -> "mo",
      "PropertyState" -> "Missouri",
      "PropertyCity" -> "Rosebud",
      "PropertyPostalCode" -> "63091")

    "return the address data correctly with valid address input" in {
      PropertySMConv.convertAddress(List(Json.parse(addressMJs))) must_== addressSJs
    }

    val singleElementFromMJs = """{
        "address":{
          "address1":"1850 Thibodo Rd",
          "address2":"",
          "cityname":"Vista",
          "statecode":"ca",
          "statename":"California",
          "postalcode":"92081"
        },
        "shortDescription":"Rejuvenate your senses."
      }"""

    val singleElementSJs = Json.obj(
      "PropertyShortDescription" -> "Rejuvenate your senses."
    )

    "extract single string value from mongo json e.g. short description" in {
      PropertySMConv.extractStringValueFromTopLevelJsElement("shortDescription", "PropertyShortDescription")(Json.parse(singleElementFromMJs)) must_== singleElementSJs
    }

    val fpMjs = """{
                  "rentRange":"$1,448 - $1,548",
                  "minimumSquareFeet":744,
                  "maximumSquareFeet":744,
                  "minimumMarketRent":1448.0,
                  "maximumMarketRent":1548.0,
                  "floorPlanImages":[
                    {
                      "tag":"2D Diagram",
                      "caption":null,
                      "src":"http://capi.myleasestar.com/v2/dimg/150132/%s/150132.jpg",
                      "maxWidth":"350",
                      "maxHeight":"480"
                    }
                  ],
                  "bedRooms":"1",
                  "bathRooms":"1",
                  "floorPlanAmenities":[
                    "Air Conditioning",
                    "View",
                    "Disposal",
                    "Cable/Satellite Available"
                  ],
                  "specials":null,
                  "diagramUrl":"http://capi.myleasestar.com/v2/dimg/150132/%s/150132.jpg",
                  "numberOfUnitsDisplay":3,
                  "name":"Massa",
                  "id":1325291
                }"""

    val fpSjs = Json.obj(
      "MinRent" -> "1448",
      "MaxRent" -> "1548",
      "MinSquareFeet" -> "744",
      "MaxSquareFeet" -> "744",
      "FloorPlanImages" -> "150132",
      "Bedrooms" -> "1",
      "Bathrooms" -> "1",
      "FloorPlanAmenities" -> Json.arr("Air Conditioning", "View", "Disposal", "Cable/Satellite"),
      "FloorPlanSpecials" -> JsNull,
      "FloorPlanName" -> "Massa",
      "ReferenceId" -> "F_1325291"
    )

    "return the floorplan data correctly with valid floorplan input" in{
      PropertySMConv.convertFloorplan(Json.parse(fpMjs)) must_== fpSjs
    }

    val combinedJsonValuesExpected = Json.obj(
      "PropertyAddress1" -> "123 Apartment Demo Street",
      "PropertyAddress2" -> "STE. 1102",
      "PropertyStateCode" -> "mo",
      "PropertyState" -> "Missouri",
      "PropertyCity" -> "Rosebud",
      "PropertyPostalCode" -> "63091",
      "PropertyShortDescription" -> "Rejuvenate your senses."
    )

    "combine separate Json values into one Json resulting value" in{
      addressSJs ++ singleElementSJs must_== combinedJsonValuesExpected
    }
  }























}
