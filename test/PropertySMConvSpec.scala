import org.specs2.mutable._

/**
 * Created with IntelliJ IDEA.
 * User: sun
 * Date: 7/7/13
 * Time: 2:48 PM
 */
class PropertySMConvSpec extends Specification {


  "Property transformation from mongo to solr" should {

    "return None when null or empty string is passed" in{

    }
  }



  val mongoResultJsonString = """{"address": {
                                |    "address1": "123 Apartment Demo Street",
                                |    "address2": "",
                                |    "statecode": "mo",
                                |    "statename": "Missouri",
                                |    "cityname": "Rosebud",
                                |    "postalcode": "63091"
                                |}, "shortDescription": "Small Town Charm and Comforts", "latitude": 38.388029, "longitude": -91.40245, "propertyKey": "6N1313023855", "parkingType": "Covered Lot", "structureType": "High Rise", "petPolicyRestrictions": null, "numberOfPetsAllowed": 1, "propertyOfficeHours": [
                                |    {
                                |        "dayOfWeek": "Monday",
                                |        "startTime1": "09:00",
                                |        "endTime1": "17:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    },
                                |    {
                                |        "dayOfWeek": "Tuesday",
                                |        "startTime1": "09:00",
                                |        "endTime1": "17:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    },
                                |    {
                                |        "dayOfWeek": "Wednesday",
                                |        "startTime1": "09:00",
                                |        "endTime1": "17:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    },
                                |    {
                                |        "dayOfWeek": "Thursday",
                                |        "startTime1": "09:00",
                                |        "endTime1": "17:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    },
                                |    {
                                |        "dayOfWeek": "Friday",
                                |        "startTime1": "09:00",
                                |        "endTime1": "17:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    },
                                |    {
                                |        "dayOfWeek": "Saturday",
                                |        "startTime1": "11:00",
                                |        "endTime1": "16:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    },
                                |    {
                                |        "dayOfWeek": "Sunday",
                                |        "startTime1": "11:00",
                                |        "endTime1": "19:00",
                                |        "startTime2": null,
                                |        "endTime2": null
                                |    }
                                |], "thumbnail": "http://capi.myleasestar.com/v2/dimg/5390527/%s/5390527.jpg", "companyId": 8509, "mobilePortalUrl": "http://www.m.villaverano.cms.myleasestar.com", "propertyUrl": null, "floorplans": [
                                |    {
                                |        "comment": null,
                                |        "rentRange": "$832 - $1,220",
                                |        "floorplanPartnerId": "1",
                                |        "minimumSquareFeet": 456,
                                |        "maximumSquareFeet": 456,
                                |        "minimumMarketRent": 832.0,
                                |        "maximumMarketRent": 1220.0,
                                |        "note": null,
                                |        "airConditionType": null,
                                |        "floorType": null,
                                |        "heatType": null,
                                |        "rangeType": null,
                                |        "applicationFee": 0.0,
                                |        "floorCount": 0,
                                |        "totalRoomCount": 0,
                                |        "depositDescription": null,
                                |        "depositAmount": 295.0,
                                |        "floorPlanImages": [
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636597/%s/5636597.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Unfurnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636598/%s/5636598.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636599/%s/5636599.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645770/%s/5645770.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645771/%s/5645771.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            }
                                |        ],
                                |        "printBrochureUrl": null,
                                |        "specials": null,
                                |        "bedRooms": "1",
                                |        "bathRooms": "1",
                                |        "depositTypeString": "Specify",
                                |        "fireplaceType": null,
                                |        "floorPlanAmenities": ["Washer/Dryer in Unit"],
                                |        "floorPlanCustomAmenities": ["Window seats ", "Wet bar ", "Granite countertop", "Hardwood"],
                                |        "fpStandardAmenities": [
                                |            {
                                |                "name": "Washer/Dryer in Unit",
                                |                "id": "53",
                                |                "amenityPartnerId": "S100000203",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "fpCustomAmenities": [
                                |            {
                                |                "name": "Window seats ",
                                |                "id": "197158163",
                                |                "amenityPartnerId": "S100000222",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Wet bar ",
                                |                "id": "197158162",
                                |                "amenityPartnerId": "S100000220",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Granite countertop",
                                |                "id": "197158161",
                                |                "amenityPartnerId": "S100000141",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Hardwood",
                                |                "id": "197158160",
                                |                "amenityPartnerId": "S100000111",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "diagramUrl": "http://capi.myleasestar.com/v2/dimg/5636597/%s/5636597.jpg",
                                |        "numberOfUnitsDisplay": 3,
                                |        "name": "St Lucia",
                                |        "id": 1485586
                                |    },
                                |    {
                                |        "comment": null,
                                |        "rentRange": "$1,232 - $1,274",
                                |        "floorplanPartnerId": "2",
                                |        "minimumSquareFeet": 730,
                                |        "maximumSquareFeet": 730,
                                |        "minimumMarketRent": 1232.0,
                                |        "maximumMarketRent": 1274.0,
                                |        "note": null,
                                |        "airConditionType": null,
                                |        "floorType": null,
                                |        "heatType": null,
                                |        "rangeType": null,
                                |        "applicationFee": 0.0,
                                |        "floorCount": 0,
                                |        "totalRoomCount": 0,
                                |        "depositDescription": null,
                                |        "depositAmount": 295.0,
                                |        "floorPlanImages": [
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636602/%s/5636602.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Unfurnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636603/%s/5636603.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636604/%s/5636604.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645772/%s/5645772.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645773/%s/5645773.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            }
                                |        ],
                                |        "printBrochureUrl": null,
                                |        "specials": null,
                                |        "bedRooms": "1",
                                |        "bathRooms": "1",
                                |        "depositTypeString": "Specify",
                                |        "fireplaceType": null,
                                |        "floorPlanAmenities": ["Washer/Dryer in Unit"],
                                |        "floorPlanCustomAmenities": ["Window seats ", "Wet bar ", "Granite countertop", "Hardwood"],
                                |        "fpStandardAmenities": [
                                |            {
                                |                "name": "Washer/Dryer in Unit",
                                |                "id": "53",
                                |                "amenityPartnerId": "S100000203",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "fpCustomAmenities": [
                                |            {
                                |                "name": "Window seats ",
                                |                "id": "197158167",
                                |                "amenityPartnerId": "S100000222",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Wet bar ",
                                |                "id": "197158166",
                                |                "amenityPartnerId": "S100000220",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Granite countertop",
                                |                "id": "197158165",
                                |                "amenityPartnerId": "S100000141",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Hardwood",
                                |                "id": "197158164",
                                |                "amenityPartnerId": "S100000111",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "diagramUrl": "http://capi.myleasestar.com/v2/dimg/5636602/%s/5636602.jpg",
                                |        "numberOfUnitsDisplay": 3,
                                |        "name": "Antigua",
                                |        "id": 1485587
                                |    },
                                |    {
                                |        "comment": null,
                                |        "rentRange": "$1,495",
                                |        "floorplanPartnerId": "4",
                                |        "minimumSquareFeet": 965,
                                |        "maximumSquareFeet": 965,
                                |        "minimumMarketRent": 1495.0,
                                |        "maximumMarketRent": 1495.0,
                                |        "note": null,
                                |        "airConditionType": null,
                                |        "floorType": null,
                                |        "heatType": null,
                                |        "rangeType": null,
                                |        "applicationFee": 0.0,
                                |        "floorCount": 0,
                                |        "totalRoomCount": 0,
                                |        "depositDescription": null,
                                |        "depositAmount": 295.0,
                                |        "floorPlanImages": [
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5435583/%s/5435583.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Unfurnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5435584/%s/5435584.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5435585/%s/5435585.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645776/%s/5645776.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645777/%s/5645777.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            }
                                |        ],
                                |        "printBrochureUrl": null,
                                |        "specials": [
                                |            {
                                |                "specialDisplayText": "$100 off your 1st month's rent",
                                |                "specialAmount": 0.0
                                |            }
                                |        ],
                                |        "bedRooms": "2",
                                |        "bathRooms": "1",
                                |        "depositTypeString": "Specify",
                                |        "fireplaceType": null,
                                |        "floorPlanAmenities": ["Washer/Dryer in Unit"],
                                |        "floorPlanCustomAmenities": ["Wet bar ", "Granite countertop", "Hardwood"],
                                |        "fpStandardAmenities": [
                                |            {
                                |                "name": "Washer/Dryer in Unit",
                                |                "id": "53",
                                |                "amenityPartnerId": "S100000203",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "fpCustomAmenities": [
                                |            {
                                |                "name": "Wet bar ",
                                |                "id": "197158170",
                                |                "amenityPartnerId": "S100000220",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Granite countertop",
                                |                "id": "197158169",
                                |                "amenityPartnerId": "S100000141",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Hardwood",
                                |                "id": "197158168",
                                |                "amenityPartnerId": "S100000111",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "diagramUrl": "http://capi.myleasestar.com/v2/dimg/5435583/%s/5435583.jpg",
                                |        "numberOfUnitsDisplay": 3,
                                |        "name": "Martinique",
                                |        "id": 1485588
                                |    },
                                |    {
                                |        "comment": null,
                                |        "rentRange": "$1,500",
                                |        "floorplanPartnerId": "5",
                                |        "minimumSquareFeet": 945,
                                |        "maximumSquareFeet": 945,
                                |        "minimumMarketRent": 1500.0,
                                |        "maximumMarketRent": 1500.0,
                                |        "note": null,
                                |        "airConditionType": null,
                                |        "floorType": null,
                                |        "heatType": null,
                                |        "rangeType": null,
                                |        "applicationFee": 0.0,
                                |        "floorCount": 0,
                                |        "totalRoomCount": 0,
                                |        "depositDescription": null,
                                |        "depositAmount": 295.0,
                                |        "floorPlanImages": [
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636605/%s/5636605.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636606/%s/5636606.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Unfurnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636607/%s/5636607.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645778/%s/5645778.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645779/%s/5645779.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            }
                                |        ],
                                |        "printBrochureUrl": null,
                                |        "specials": null,
                                |        "bedRooms": "2",
                                |        "bathRooms": "1",
                                |        "depositTypeString": "Specify",
                                |        "fireplaceType": null,
                                |        "floorPlanAmenities": ["Washer/Dryer in Unit"],
                                |        "floorPlanCustomAmenities": ["Wet bar ", "Granite countertop", "Hardwood"],
                                |        "fpStandardAmenities": [
                                |            {
                                |                "name": "Washer/Dryer in Unit",
                                |                "id": "53",
                                |                "amenityPartnerId": "S100000203",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "fpCustomAmenities": [
                                |            {
                                |                "name": "Wet bar ",
                                |                "id": "197158173",
                                |                "amenityPartnerId": "S100000220",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Granite countertop",
                                |                "id": "197158172",
                                |                "amenityPartnerId": "S100000141",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Hardwood",
                                |                "id": "197158171",
                                |                "amenityPartnerId": "S100000111",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "diagramUrl": "http://capi.myleasestar.com/v2/dimg/5636605/%s/5636605.jpg",
                                |        "numberOfUnitsDisplay": 3,
                                |        "name": "Margarita",
                                |        "id": 1485589
                                |    },
                                |    {
                                |        "comment": null,
                                |        "rentRange": "$1,503",
                                |        "floorplanPartnerId": "3",
                                |        "minimumSquareFeet": 967,
                                |        "maximumSquareFeet": 967,
                                |        "minimumMarketRent": 1503.0,
                                |        "maximumMarketRent": 1503.0,
                                |        "note": null,
                                |        "airConditionType": null,
                                |        "floorType": null,
                                |        "heatType": null,
                                |        "rangeType": null,
                                |        "applicationFee": 0.0,
                                |        "floorCount": 0,
                                |        "totalRoomCount": 0,
                                |        "depositDescription": null,
                                |        "depositAmount": 295.0,
                                |        "floorPlanImages": [
                                |            {
                                |                "tag": "3D Unfurnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636608/%s/5636608.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636609/%s/5636609.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": "",
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5636610/%s/5636610.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "2D Diagram",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645774/%s/5645774.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            },
                                |            {
                                |                "tag": "3D Furnished",
                                |                "caption": null,
                                |                "src": "http://capi.myleasestar.com/v2/dimg/5645775/%s/5645775.jpg",
                                |                "maxWidth": "800",
                                |                "maxHeight": "800"
                                |            }
                                |        ],
                                |        "printBrochureUrl": null,
                                |        "specials": null,
                                |        "bedRooms": "2",
                                |        "bathRooms": "2",
                                |        "depositTypeString": "Specify",
                                |        "fireplaceType": null,
                                |        "floorPlanAmenities": ["Washer/Dryer in Unit"],
                                |        "floorPlanCustomAmenities": ["Granite countertop", "Hardwood", "Wet bar "],
                                |        "fpStandardAmenities": [
                                |            {
                                |                "name": "Washer/Dryer in Unit",
                                |                "id": "53",
                                |                "amenityPartnerId": "S100000203",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "fpCustomAmenities": [
                                |            {
                                |                "name": "Granite countertop",
                                |                "id": "197158175",
                                |                "amenityPartnerId": "S100000141",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Hardwood",
                                |                "id": "197158174",
                                |                "amenityPartnerId": "S100000111",
                                |                "displaySequence": 9999
                                |            },
                                |            {
                                |                "name": "Wet bar ",
                                |                "id": "197158176",
                                |                "amenityPartnerId": "S100000220",
                                |                "displaySequence": 9999
                                |            }
                                |        ],
                                |        "diagramUrl": "http://capi.myleasestar.com/v2/dimg/5636608/%s/5636608.jpg",
                                |        "numberOfUnitsDisplay": 3,
                                |        "name": "St Maarten",
                                |        "id": 1485590
                                |    }
                                |], "fullDescription": "Escape city life at Villa Verano, where you can enjoy scenic views of Missouri hills and woods while taking advantage of more affordable living. Located in Rosebud, Missouri, midway between Jefferson City and St Louis, Villa Verano offers the benefits of rural life without sacrificing access to city services. \nYou're sure to be charmed by our small town which offers quaint antique shops, a local pub, and a cafe known for its home-style cooking. At Rosebud Banc Antiques, you can spend your time browsing a variety of unique items for your home. If you're in the mood for authentic Irish food, you can head to Clancy's Irish Pub #2, the local watering hole, which offers live entertainment twice a month. Located on the west side of town, Kline's Down Home Cafe features generous portions of delicious food served by a welcoming staff. \nFor more dining and recreation options, you can take a quick drive to the city of Owensville, less than seven miles away. In this neighboring town, you'll fin", "leaseLength": "1 month, 2 months, 3 months, 4 months, 5 months, 6 months, 7 months, 8 months, 9 months, 10 months, ", "phoneNumber": null, "walkScore": 11, "amenities": ["Gate", "Clubhouse", "Playground", "Sports Courts", "Pool", "High Speed Internet Available", "Courtyard", "Fitness Center"], "monthlyPetRentMax": null, "monthlyPetRentMin": null, "oneTimePetFee": 0.0, "onlineLeasingURL": "http://property.onesite.realpage.com/ol/default.aspx?siteID=1192787&leaseterm=12", "parkingComment": null, "unitCount": 100, "yearBuilt": 1999, "rentalApplicationUrl": null, "images": [
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5266376/%s/5266376.jpg",
                                |        "maxWidth": "540",
                                |        "maxHeight": "266"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5266375/%s/5266375.jpg",
                                |        "maxWidth": "540",
                                |        "maxHeight": "266"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5266374/%s/5266374.jpg",
                                |        "maxWidth": "540",
                                |        "maxHeight": "266"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5266377/%s/5266377.jpg",
                                |        "maxWidth": "540",
                                |        "maxHeight": "266"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5636475/%s/5636475.jpg",
                                |        "maxWidth": "460",
                                |        "maxHeight": "306"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5636472/%s/5636472.jpg",
                                |        "maxWidth": "441",
                                |        "maxHeight": "345"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5636471/%s/5636471.jpg",
                                |        "maxWidth": "441",
                                |        "maxHeight": "345"
                                |    },
                                |    {
                                |        "tag": null,
                                |        "caption": "",
                                |        "src": "http://capi.myleasestar.com/v2/dimg/5636494/%s/5636494.jpg",
                                |        "maxWidth": "441",
                                |        "maxHeight": "345"
                                |    }
                                |], "petsAllowed": true, "customAmenities": ["TV Lounge", "Media room/theater", "Conference/Meeting room", "24hr. Business center", "Multiple phone lines", "Bike trail", "Bike rack or bike storage"], "petPolicyOther": null, "rentPaymentUrl": "https://property.onesite.realpage.com/welcomehome/?siteId=2190606", "managementCompanyLogoUrl": null, "propStandardAmenities": [
                                |    {
                                |        "name": "Gate",
                                |        "id": "50",
                                |        "amenityPartnerId": "S100000004",
                                |        "displaySequence": 0
                                |    },
                                |    {
                                |        "name": "Clubhouse",
                                |        "id": "63",
                                |        "amenityPartnerId": "S100000019",
                                |        "displaySequence": 2
                                |    },
                                |    {
                                |        "name": "Playground",
                                |        "id": "42",
                                |        "amenityPartnerId": "S100000035",
                                |        "displaySequence": 6
                                |    },
                                |    {
                                |        "name": "Sports Courts",
                                |        "id": "69",
                                |        "amenityPartnerId": "S100000037",
                                |        "displaySequence": 7
                                |    },
                                |    {
                                |        "name": "Pool",
                                |        "id": "41",
                                |        "amenityPartnerId": "S100000042",
                                |        "displaySequence": 8
                                |    },
                                |    {
                                |        "name": "High Speed Internet Available",
                                |        "id": "58",
                                |        "amenityPartnerId": "S100000058",
                                |        "displaySequence": 11
                                |    },
                                |    {
                                |        "name": "Courtyard",
                                |        "id": "67",
                                |        "amenityPartnerId": "S100000253",
                                |        "displaySequence": 14
                                |    },
                                |    {
                                |        "name": "Fitness Center",
                                |        "id": "53",
                                |        "amenityPartnerId": "S100000278",
                                |        "displaySequence": 16
                                |    }
                                |], "propCustomAmenities": [
                                |    {
                                |        "name": "TV Lounge",
                                |        "id": "83585519",
                                |        "amenityPartnerId": "S100000021",
                                |        "displaySequence": 3
                                |    },
                                |    {
                                |        "name": "Media room/theater",
                                |        "id": "83585520",
                                |        "amenityPartnerId": "S100000025",
                                |        "displaySequence": 5
                                |    },
                                |    {
                                |        "name": "Conference/Meeting room",
                                |        "id": "83585521",
                                |        "amenityPartnerId": "S100000050",
                                |        "displaySequence": 9
                                |    },
                                |    {
                                |        "name": "24hr. Business center",
                                |        "id": "83585522",
                                |        "amenityPartnerId": "S100000051",
                                |        "displaySequence": 10
                                |    },
                                |    {
                                |        "name": "Multiple phone lines",
                                |        "id": "83585523",
                                |        "amenityPartnerId": "S100000065",
                                |        "displaySequence": 13
                                |    },
                                |    {
                                |        "name": "Bike trail",
                                |        "id": "83585524",
                                |        "amenityPartnerId": "S100000277",
                                |        "displaySequence": 15
                                |    },
                                |    {
                                |        "name": "Bike rack or bike storage",
                                |        "id": "83585525",
                                |        "amenityPartnerId": "S100000308",
                                |        "displaySequence": 18
                                |    }
                                |], "parkingAssignmentAvailable": false, "petPolicyType": "Cats and Dogs", "managementCompanyName": "LeaseStar Demo Company", "dynamicMediaHostUrl": "http://capi.myleasestar.com/v2", "printBrochureUrl": null, "socialNetworkDetailsList": [
                                |    {
                                |        "siteUrl": "http://www.facebook.com/realpage",
                                |        "linkText": "",
                                |        "siteName": "Facebook"
                                |    },
                                |    {
                                |        "siteUrl": "https://twitter.com/RealPage",
                                |        "linkText": "",
                                |        "siteName": "Twitter"
                                |    },
                                |    {
                                |        "siteUrl": "http://www.linkedin.com/company/realpage-inc.",
                                |        "linkText": "",
                                |        "siteName": "LinkedIn"
                                |    },
                                |    {
                                |        "siteUrl": "http://www.youtube.com/RealPageMedia",
                                |        "linkText": "",
                                |        "siteName": "YouTube"
                                |    }
                                |], "propertyVideos": [
                                |    {
                                |        "videoThumbnailPath": "http://thumbs.fliqz.com/e3b7207656c1406cb48a5624419c5305.jpg",
                                |        "caption": "1130385",
                                |        "src": "http://applications.fliqz.com/?file=e3b7207656c1406cb48a5624419c5305",
                                |        "maxWidth": "396",
                                |        "maxHeight": "345"
                                |    }
                                |], "incomeQualifications": null, "vanityUrls": null, "webSiteUrlStrategy": "property", "specials": null, "name": "Villa Verano", "id": 1130385}"""


}
