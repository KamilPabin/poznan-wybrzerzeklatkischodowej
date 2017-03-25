package braincode.com.smartsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestParser {

    private static final String[] keywords = {"stan","miejscowość","cena" ,"rodzaj"};

    public static Query query;

    public RequestParser(){
    }

    public static Query parseQuery(String request) {
        query = new Query();
        Scanner scanner = new Scanner(request);
        String phrase = "";

        while(scanner.hasNext()) {

            String next = scanner.next();

            if (next.equals(keywords[0]) ) {

                next = scanner.next();
                if(next.equals("nowy")) {
                    query.params.put("buyNew", "1");
                } else {
                    query.params.put("buyUsed","1");
                }

            } else if (next.equals(keywords[1])) {
                next = scanner.next();
                query.params.put("city",next);
            } else if(next.equals(keywords[2] )) {

                next = scanner.next();
                if(next .equals("od")) {
                    query.params.put("price_from", scanner.next());
                } else {
                    query.params.put("price_to", scanner.next());
                }

            } else if ( next.equals(keywords[3] )) {

                next = scanner.next();

                if(next.equals("licytacje") || next.equals("licytacja") ) {
                    query.params.put("offerTypeAuction", "1");
                    query.params.put("offerTypeBuyNow", "0");
                } else {
                    scanner.next();
                    query.params.put("offerTypeBuyNow", "1");
                    query.params.put("offerTypeAction", "0");
                }

            } else {
                phrase += next + " ";
            }
        }
        query.phrase = phrase;
        return query;
    }

    @Override
    public String toString() {
        return query.toString();
    }

    public static class Query {

        public Query() {
            params = new HashMap<>();
        }

        String phrase;
        Map<String, String> params;

        @Override
        public String toString() {
            return "Query{" +
                    "phrase='" + phrase + '\'' +
                    ", params=" + params +
                    '}';
        }
    }
}