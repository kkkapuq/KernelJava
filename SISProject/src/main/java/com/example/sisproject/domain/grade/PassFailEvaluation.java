package com.example.sisproject.domain.grade;

public class PassFailEvaluation implements GradeEvaluation{

	@Override
	public String getGrade(int point) {
		
		if( point >= 70) return "P";
		
		else return "F";
	}

}