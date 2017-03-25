package braincode.com.smartsearch;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kkoza on 25.03.2017.
 */

public class RequestParser {

    String[] keywords = {"stan","miejscowosc","cena" ,"rodzaj"};

    public Query query;

    public RequestParser(){
    }

    public Query parseQuery(String request) {
        query = new Query();
        Scanner scanner = new Scanner(request);
        String phrase = "";

        while(scanner.hasNext()) {

            String next = scanner.next();

            if (next == keywords[0] ) {

                next = scanner.next();
                if(next == "nowy") {
                    query.params.put("buyNew", "1");
                } else {
                    query.params.put("buyUsed","0");
                }

            } else

                if (next == keywords[1]) {
                    next = scanner.next();
                    query.params.put("city",next);
                } else

                    if(next == keywords[3]) {

                        next = scanner.next();
                        if( next == "od") {
                            query.params.put("price_from", scanner.next());
                        } else {
                            query.params.put("price_to", scanner.next());
                        }

                    } else
                        if ( next == keywords[4]) {

                            next = scanner.next();

                            if(next == "licytacje") {
                                query.params.put("offerTypeAuction", "0");
                            } else {
                                query.params.put("offerTypeBuyNow", "1");
                            }

                        } else {
                            phrase += next;
                        }
        }
        return query;
    }

    public class Query {

        public Query() {
            params = new HashMap<>();
        }

        String phrase;
        Map<String, String> params;
    }
}