package xyz.ge1st.WishlistAPI.web;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class WishlistReader {

    private String url;
    private String htmlContent;

    public WishlistReader(String urlString) throws IOException, InterruptedException {
        this.url = urlString;

        this.readURLContent();
    }

    public void readURLContent() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<byte[]> httpResponse = httpClient.send(httpRequest,
                HttpResponse.BodyHandlers.ofByteArray());

        // Unzip compressed httpResponse
        GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(httpResponse.body()));

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

       htmlContent = stringBuilder.toString();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

}
