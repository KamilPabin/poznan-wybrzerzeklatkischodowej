package braincode.com.smartsearch;

import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public Query query;

    private RequestParser(){
    }

    public Query parseQuery(String request) {
        query = new Query();

        request = getData(request,"nowe", "buyNew", "1");
        request = getData(request,"nowa", "buyNew", "1");
        request = getData(request,"nowy", "buyNew", "1");

        request = getData(request,"uzywane", "buyUsed", "0");
        request = getData(request,"uzywana", "buyUsed", "0");
        request = getData(request,"uzywany", "buyUsed", "0");

        request = getData(request,"kup teraz", "offerTypeBuyNow", "1");

        request = getData(request,"licytacje", "offerTypeAuction", "0");

        query.phrase = request;
        return query;
    }

    private String getData(String request,String paramName, String paramKey, String paramValue) {
        StringBuilder builder = new StringBuilder(request);

        if (request.contains(paramName)) {

            query.params.put(paramKey,paramValue);

            int pos = request.indexOf(paramName);
            builder = builder.delete(pos,pos + paramName.length());
            request = builder.toString();
        }

        return request;
    }


    public class Query {

        public Query() {
            params = new HashMap<>();
        }

        String phrase;
        Map<String, String> params;
    }
}
