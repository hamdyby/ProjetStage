package com.microservice.api.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

@RestController
public class TagsController {
  @Autowired
  private RestTemplate restTemplate;

  HttpHeaders createHeaders() {
    return new HttpHeaders() {
      {
        String authHeader = "Bearer YjQwYWVhNTg2MWRhZmUwYjk4YWJlNzY5Y2Q1YjlkYjE5NzY1YTUwMzM2ZTM5NDM1Yjc3M2MzYmExNTI1OWE2Zg";
        set("Authorization", authHeader);
      }
    };
  }

  @GetMapping("/tags")
  public void getTags() throws IOException {
    String url = "https://api.bigbuy.eu/rest/catalog/tags.json?isoCode=fr" ;
    /*Object[] tags = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders()), Object[].class).getBody();

    ObjectMapper mapper = new ObjectMapper();
    try {

      // Writing to a file
      mapper.writeValue(new File("tags.json"), tags);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return  Arrays.asList(tags);*/

    ResponseEntity<JsonNode> e = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders()),JsonNode.class);


    System.out.println(e.getBody());

  }

}
