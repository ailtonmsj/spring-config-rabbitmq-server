package br.com.amsj.spring.config.client.controller;

import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WordController2 {
	
	@PostConstruct
	public void init() {
		refreshDate = Instant.now().toString();
	}
	
	private String refreshDate;
	
	@Value("${wordConfig.word}")
	public String word;
	
	@Value("${wordConfig.phrase}")
	private String phrase;
	
	@GetMapping("/word2")
	public String getLuckyWord() {
		return phrase + ": " + word;
	}
	
	@GetMapping("/refreshDate2")
	public String getRefreshDate() {
		return refreshDate;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
}
