package com.cricket.api.util;

import org.springframework.stereotype.Component;

import com.cricket.api.dto.ScoreDTO;
import com.cricket.api.entity.ScoreEntity;

@Component
public class MapperUtil {

	public ScoreDTO mapData(ScoreEntity entity) {
		ScoreDTO dto = new ScoreDTO();
		dto.setTeam1(entity.getTeam1());
		dto.setTeam2(entity.getTeam2());
		String score = entity.getScore();
		String team1 = entity.getTeam1();
		String team2 = entity.getTeam2();
		int scoreOfTeam1;
		int wicketOfTeam1;
		int scoreOfTeam2;
		int wicketOfTeam2;
		;
		if (score.indexOf(team1) == 0) {
			score = score.replaceAll(team1, "").replaceAll(team2, "").replaceAll("v", "").replaceAll("\\s+", " ")
					.replaceAll("\\*", "");

			String[] arr = score.trim().split(" ");
			
			scoreOfTeam1 = Integer.parseInt(arr[0].substring(0, arr[0].indexOf('/')));
			wicketOfTeam1 = Integer.parseInt(arr[0].substring(arr[0].indexOf('/') + 1, arr[0].length()));
			scoreOfTeam2 = Integer.parseInt(arr[1].substring(0, arr[0].indexOf('/')));
			wicketOfTeam2 = Integer.parseInt(arr[0].substring(arr[0].indexOf('/') + 1, arr[0].length()));

		} else {
			score = score.replaceAll(team2, "").replaceAll(team1, "").replaceAll("v", "").replaceAll("\\s+", " ")
					.replaceAll("\\*", "");

			String[] arr = score.trim().split(" ");
			
			
			
			scoreOfTeam1 = Integer.parseInt(arr[0].substring(0, arr[0].indexOf('/')));
			wicketOfTeam1 = Integer.parseInt(arr[0].substring(arr[0].indexOf('/') + 1, arr[0].length()));
			scoreOfTeam2 = Integer.parseInt(arr[1].substring(0, arr[0].indexOf('/')));
			wicketOfTeam2 = Integer.parseInt(arr[1].substring(arr[0].indexOf('/') + 1, arr[0].length()));
		}

		if(scoreOfTeam1 > scoreOfTeam2) {
			dto.setWinningScore(scoreOfTeam1+"/"+wicketOfTeam1);
		}else {
			dto.setWinningScore(scoreOfTeam2+"/"+wicketOfTeam2);
		}
		
		return dto;
	}

}
