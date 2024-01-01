package org.assistments.vts.manager.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Optional;
import javax.annotation.PreDestroy;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.assistments.util.Pair;
import org.assistments.vts.manager.ZoomRequestHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class ZoomRequestHandlerImpl implements ZoomRequestHandler
{
  private final CloseableHttpClient httpClient;
  private final ObjectMapper objectMapper;

  public ZoomRequestHandlerImpl(final ObjectMapper objectMapper)
  {
    this.httpClient = HttpClientBuilder.create()
      .setDefaultRequestConfig(
        RequestConfig.custom()
        .setConnectTimeout(5000)
        .setConnectionRequestTimeout(5000)
        .setSocketTimeout(5000)
        .build()
      ).build();
    this.objectMapper = objectMapper;
  }

  @PreDestroy
  private void shutdown()
  {
    try
    {
      this.httpClient.close();
    }
    catch (IOException e)
    {
      ; // Do nothing
    }
  }

  @Override
  public Pair<Pair<Long, String>, Optional<String>> getZoomURL(Instant expectedStartTime, int expectedDuration)
  {
    try
    {
      String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6ImZpa3JZUlY5VDhtakUwc3ZfUGh6cXciLCJleHAiOjE2NzA1"
          + "NzgyMDAsImlhdCI6MTYzOTA4MTU2M30.26YmQ_UJhBwTgQM8BrAXBor7ogzEMAcajZVTmJBi3dA";
      final HttpPost createMeeting = new HttpPost("https://api.zoom.us/v2/users/me/meetings");
      createMeeting.addHeader("Authorization", "Bearer " + authToken);
      createMeeting.addHeader("Content-Type", "application/json");

      ObjectNode requestBody = objectMapper.createObjectNode();
      requestBody.put("topic", "Tutor session");
      requestBody.put("type", 2);
      requestBody.put("start_time", expectedStartTime.toString());
      requestBody.put("duration", expectedDuration);
      requestBody.put("password", "");

      ObjectNode settings = objectMapper.createObjectNode();
      settings.put("join_before_host", true);
      settings.put("jbh_time", 0);
      settings.put("host_video", true);
      settings.put("participant_video", true);
      settings.put("auto_recording", "cloud");
      settings.put("waiting_room", false);

      requestBody.set("settings", settings);

      String requestAsString = objectMapper.writeValueAsString(requestBody);
      createMeeting.setEntity(new StringEntity(requestAsString));

      CloseableHttpResponse response = this.httpClient.execute(createMeeting);

      if (response == null)
      {
        return new Pair<>(null, Optional.of("No response was returned."));
      }
      else
      {
        final HttpEntity entity = response.getEntity();
        final String responseData = EntityUtils.toString(entity, StandardCharsets.UTF_8.name());
        JsonNode responseBody = objectMapper.readTree(responseData);
        long id = responseBody.get("id").asLong();
        String url = responseBody.get("join_url").asText();

        EntityUtils.consume(entity);
        response.close();
        return new Pair<>(new Pair<>(id, url), Optional.empty());
      }
    }
    catch (IOException e)
    {
      return new Pair<>(null, Optional.of(
        Optional.ofNullable(e.getMessage()).orElse("An exception has occurred trying to create meeting.")
      ));
    }
  }

  @Override
  public Pair<String, Optional<String>> getZoomRecording(Long zoomId)
  {
    try
    {
      String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6ImZpa3JZUlY5VDhtakUwc3ZfUGh6cXciLCJleHAiOjE2NzA1"
          + "NzgyMDAsImlhdCI6MTYzOTA4MTU2M30.26YmQ_UJhBwTgQM8BrAXBor7ogzEMAcajZVTmJBi3dA";
      final HttpGet getRecording = new HttpGet("https://api.zoom.us/v2/meetings/" + zoomId.toString() + "/recordings");
      getRecording.addHeader("Authorization", "Bearer " + authToken);
      CloseableHttpResponse response = this.httpClient.execute(getRecording);
      if (response == null)
      {
        return new Pair<>(null, Optional.of("No response was returned."));
      }
      else
      {
        final HttpEntity entity = response.getEntity();
        final String responseData = EntityUtils.toString(entity, StandardCharsets.UTF_8.name());
        JsonNode responseBody = objectMapper.readTree(responseData);
        System.out.println("hello");
        System.out.println(responseBody.get("recording_count").asText());
        String url = responseBody.get("share_url").asText();


        EntityUtils.consume(entity);
        response.close();
        return new Pair<>(url, Optional.empty());
      }
    }
    catch (IOException e)
    {
      return new Pair<>(null, Optional.of(
        Optional.ofNullable(e.getMessage()).orElse("An exception has occurred trying to grab the recording data")
      ));
    }
  }
}
