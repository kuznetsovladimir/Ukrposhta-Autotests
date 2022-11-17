package utils;

import org.json.JSONObject;

public class ApiConstants {
    private final String USER_KEY = "637d5af3866f332ced48448e4a2c22e8";
    private final String CITY_REF = "e71f8842-4b33-11e4-ab6d-005056801329";
    private final String DELIVERY_CITY_REF = "db5c88e0-391c-11dd-90d9-001a92567626";
    private final String STREET_REF = "0099b64f-213f-11e8-8974-0025b502a06e";
    private final String URL = "https://api.novaposhta.ua/v2.0/json/";

    public String getURL () {
        return URL;
    }

    public JSONObject counterpartyDataInitial () {
        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "Counterparty");
        userData.put("calledMethod", "save");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("FirstName", "Іван");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("LastName", "Іванов");
        propertiesData.put("Phone", "+380970191682");
        propertiesData.put("Email", "test@i.com");
        propertiesData.put("CounterpartyType", "PrivatePerson");
        propertiesData.put("CounterpartyProperty", "Recipient");

        //JSONObject methodProperties = new JSONObject();
        //methodProperties.put("methodProperties", propertiesData);

        userData.put("methodProperties", propertiesData);
        return userData;


    }

    public JSONObject counterpartyDataModified (String ref) {
        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "Counterparty");
        userData.put("calledMethod", "update");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("Ref", ref);
        propertiesData.put("CityRef", DELIVERY_CITY_REF);
        propertiesData.put("FirstName", "Петро");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("LastName", "Іванов");
        propertiesData.put("Phone", "+380970191683");
        propertiesData.put("Email", "test@i.com");
        propertiesData.put("CounterpartyType", "PrivatePerson");
        propertiesData.put("CounterpartyProperty", "Recipient");

        //JSONObject methodProperties = new JSONObject();
        //methodProperties.put("methodProperties", propertiesData);

        userData.put("methodProperties", propertiesData);
        return userData;


    }

    public JSONObject counterpartyDataDelete (String ref) {
        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "Counterparty");
        userData.put("calledMethod", "delete");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("Ref", ref);


        //JSONObject methodProperties = new JSONObject();
        //methodProperties.put("methodProperties", propertiesData);

        userData.put("methodProperties", propertiesData);
        return userData;


    }

    public JSONObject contactPersonDataInitial () {
        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "ContactPerson");
        userData.put("calledMethod", "save");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("CounterpartyRef","c983247e-36b7-11ed-a60f-48df37b921db" );
        propertiesData.put("FirstName", "Іван");

        propertiesData.put("LastName", "Іванов");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("Phone", "+380970191683");


        //JSONObject methodProperties = new JSONObject();
        //methodProperties.put("methodProperties", propertiesData);

        userData.put("methodProperties", propertiesData);
        return userData;


    }

    public JSONObject contactPersonDataUpdate (String ref) {
        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "ContactPerson");
        userData.put("calledMethod", "update");

        JSONObject propertiesData = new JSONObject();
        propertiesData.put("CounterpartyRef","c983247e-36b7-11ed-a60f-48df37b921db" );
        propertiesData.put("Ref",ref );
        propertiesData.put("FirstName", "Іван");

        propertiesData.put("LastName", "Петров");
        propertiesData.put("MiddleName", "Іванович");
        propertiesData.put("Phone", "+380970191683");


        //JSONObject methodProperties = new JSONObject();
        //methodProperties.put("methodProperties", propertiesData);

        userData.put("methodProperties", propertiesData);
        return userData;


    }

    public JSONObject contactPersonDataDelete ( String ref2) {
        JSONObject userData = new JSONObject();
        userData.put("apiKey", "637d5af3866f332ced48448e4a2c22e8");
        userData.put("modelName", "ContactPerson");
        userData.put("calledMethod", "delete");

        JSONObject propertiesData = new JSONObject();
        ;
        propertiesData.put("Ref",ref2 );



        //JSONObject methodProperties = new JSONObject();
        //methodProperties.put("methodProperties", propertiesData);

        userData.put("methodProperties", propertiesData);
        return userData;


    }




}
