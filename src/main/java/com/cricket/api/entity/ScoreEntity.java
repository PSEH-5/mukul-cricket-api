package com.cricket.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = { "provider" })
public class ScoreEntity {

	private String stat;
	private String score; // ":"Sunrisers Hyderabad 139/7 v Chennai Super Kings 140/8 *",
	private String description; // ":"Sunrisers Hyderabad 139/7 v Chennai Super Kings 140/8 *",
	private boolean matchStarted; // :true,
	@JsonProperty("team-1")
	private String team1; // ":"Sunrisers Hyderabad",
	@JsonProperty("team-2")
	private String team2; // ":"Chennai Super Kings",
	private String v; // ":"1",
	private int ttl; // ":2,
	private int creditsLeft; // ":250

	public ScoreEntity() {

	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMatchStarted() {
		return matchStarted;
	}

	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	public int getCreditsLeft() {
		return creditsLeft;
	}

	public void setCreditsLeft(int creditsLeft) {
		this.creditsLeft = creditsLeft;
	}

}
