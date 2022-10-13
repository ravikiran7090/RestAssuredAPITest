package qa.b2b.api.constants;

public interface IConstants {

    //file paths
    String EXCEL_SHEETPATH = "./src/test/resources/testdatasample.xlsx";
    String RUNNERMANAGER_SHEETNAME = "RUNMANAGER";
    String TESTDATA_SHEETNAME = "TESTDATA";
    String RESPONSE_TXTPATH = "./output/responses/";
    String PROPERTY_FILE_PATH = "./src/test/resources/propertyfile/propertyfile.properties";
    String REQUEST_JSON_FILE_PATH = "./src/test/resources/requestjsonfiles";
    String SCHEMA_JSON_FILE_PATH = "./src/test/resources/schemaJsonfiles";


    //pre-requiremnts like base uri and Oauth
    String BASEURI = "https://petstore.swagger.io/v2";
    String USERNAME = "";
    String CLIENT_SECRET = "";
    String GRANT_TYPE = "";
    String CLIENT_ID = "";
    String PASSWORD = "";


    //End Points
    String GET_PET_BY_ID = "/pet";
    String ADD_NEW_PET_STORE = "/pet";

}
