import java.io.*;
import java.math.*;
import java.net.http.HttpResponse;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.*;



class Result3 {

    /*
     * Complete the 'bestInGenre' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING genre as parameter.
     *
     * Base URL: https://jsonmock.hackerrank.com/api/tvseries?page=
     */

    public static String bestInGenre(String genre) {
        // Write your code here
        int page = 0;

        List<Item> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            String url = "https://jsonmock.hackerrank.com/api/tvseries?page=" + i;

            try {
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();

                if(responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();

                    Response res = parseResponse(response.toString());

                    if(res.getPage().getPage() == res.getPage().getTotal_pages()) {
                        break;
                    }

                    for (Item item : res.getData()) {
                        if(item.getGenre().contains(genre)) {
                            list.add(item);
                        }
                    }
                }
            } catch (Exception e) {

            }
        }

        String name = "";
        int max = 0;

        for (Item item : list) {
            if(item.getImdb_rating() > max) {
                max = item.getImdb_rating();
                name = item.getName();
            }
        }

        return name;

    }

    static Response parseResponse(String response) {
        Response res = new Response();
        res.setPage(parsePage(response));
        res.setData(parseData(response));

        return res;
    }

    static Page parsePage(String response) {
        Page page = new Page();
        page.setPage(parseInt(extractValueFromJson(response, "page")));
        page.setPer_page(parseInt(extractValueFromJson(response, "per_page")));
        page.setTotal(parseInt(extractValueFromJson(response, "total")));
        page.setTotal_pages(parseInt(extractValueFromJson(response, "total_pages")));

        return page;
    }

    static List<Item> parseData(String response) {
        List<Item> list = new ArrayList<>();

        String data = extractValueFromJson(response, "data");

        int index = data.indexOf('{');
        while(index != -1) {
            int end = data.indexOf('}', index);
            String item = data.substring(index, end + 1);
            list.add(parseItem(item));
            index = data.indexOf('{', end);
        }

        return list;
    }

    static Item parseItem(String item) {
        Item i = new Item();
        i.setName(extractValueFromJson(item, "name"));
        i.setRuntime_of_series(extractValueFromJson(item, "runtime_of_series"));
        i.setCertificate(extractValueFromJson(item, "certificate"));
        i.setRuntime_of_episodes(extractValueFromJson(item, "runtime_of_episodes"));
        i.setGenre(extractValueFromJson(item, "genre"));
        i.setImdb_rating(parseInt(extractValueFromJson(item, "imdb_rating")));
        i.setOverview(extractValueFromJson(item, "overview"));
        i.setNo_of_votes(parseInt(extractValueFromJson(item, "no_of_votes")));
        i.setId(parseInt(extractValueFromJson(item, "id")));

        return i;
    }

    static String extractValueFromJson(String json, String key) {
        String value = "\"" + key + "\":";
        int index = json.indexOf(value) + value.length();
        if(json.charAt(index) == '"') {
            int start = json.indexOf('"', index) + 1;
            int end = json.indexOf('"', start);
            return json.substring(start, end);
        }else {
            int end = json.indexOf(',', index);
            if(end == -1) {
                end = json.indexOf('}', index);
            }
            return json.substring(index, end);
        }
    }

    static class Response {
        Page page;
        List<Item> data;

        public Page getPage() {
            return page;
        }

        public void setPage(Page page) {
            this.page = page;
        }

        public List<Item> getData() {
            return data;
        }

        public void setData(List<Item> data) {
            this.data = data;
        }
    }

    static class Page {
        int page;
        int per_page;
        int total;
        int total_pages;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }
    }

    static class Item {
        String name;
        String runtime_of_series;
        String certificate;
        String runtime_of_episodes;
        String genre;
        Integer imdb_rating;
        String overview;
        Integer no_of_votes;
        Integer id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRuntime_of_series() {
            return runtime_of_series;
        }

        public void setRuntime_of_series(String runtime_of_series) {
            this.runtime_of_series = runtime_of_series;
        }

        public String getCertificate() {
            return certificate;
        }

        public void setCertificate(String certificate) {
            this.certificate = certificate;
        }

        public String getRuntime_of_episodes() {
            return runtime_of_episodes;
        }

        public void setRuntime_of_episodes(String runtime_of_episodes) {
            this.runtime_of_episodes = runtime_of_episodes;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public Integer getImdb_rating() {
            return imdb_rating;
        }

        public void setImdb_rating(Integer imdb_rating) {
            this.imdb_rating = imdb_rating;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public Integer getNo_of_votes() {
            return no_of_votes;
        }

        public void setNo_of_votes(Integer no_of_votes) {
            this.no_of_votes = no_of_votes;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String genre = bufferedReader.readLine();

        String result = Result3.bestInGenre(genre);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
