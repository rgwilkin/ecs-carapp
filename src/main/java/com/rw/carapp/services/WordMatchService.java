package com.rw.carapp.services;

import com.rw.carapp.models.WordMatch;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@Service
public class WordMatchService {

  public List<String> getMatches(String word)
  {


    Mono<WordMatch[]> response = WebClient.create("https://api.datamuse.com")
        .get()
        .uri(uriBuilder -> uriBuilder
            .path("words")
            .queryParam("sl", word)
            .build())
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(WordMatch[].class).log();


    WordMatch[] readers = response.block();

    List<String> res = Arrays.stream(readers)
        .map(WordMatch::getWord)
        .limit(5)
        .collect(Collectors.toList());

    return res;

  }
}
