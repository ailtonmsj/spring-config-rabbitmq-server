package br.com.amsj.spring.config.client.controller;

import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix="word-config")
public class WordController {
	
	@PostConstruct
	public void init() {
		refreshDate = Instant.now().toString();
	}
	
	public String refreshDate;
	
	private String word;
	
	private String phrase;
	
	@GetMapping("/word")
	public String getLuckyWord() {
		return phrase + ": " + word;
	}
	
	@GetMapping("/refreshDate")
	public String getRefreshDate() {
		return refreshDate;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
