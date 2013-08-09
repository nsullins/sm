import org.specs2.mutable._
import models._

import play.api.libs.json._
import play.api.libs.json.extensions._

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

    val addressSJs = JsExtensions.buildJsObject(
      __ \ "PropertyAddress1" -> JsString("123 Apartment Demo Street"),
      __ \ "PropertyAddress2" -> JsString("STE. 1102"),
      __ \ "PropertyStateCode" -> JsString("mo"),
      __ \ "PropertyState" -> JsString("Missouri"),
      __ \ "PropertyCity" -> JsString("Rosebud"),
      __ \ "PropertyPostalCode" -> JsString("63091"))

    "return the address data correctly with valid address input" in {
      PropertySMConv.convertAddress(List(Json.parse(addressMJs))) must_== addressSJs
    }

  }
}
