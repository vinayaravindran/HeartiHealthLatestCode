package com.discoveri.heartihealth.repositoryImpl;

public class HeartiInfoRepoUtil {
	
	public static int findVariation(int curPrediction,int prevPrediction)
	{
		float percentage = 0;
		
		if (prevPrediction > 0)
			percentage = ((curPrediction - prevPrediction) / (prevPrediction * 1.0f))
					* 100.0f;
		else
			percentage = curPrediction * 100;
		
		return Math.round(percentage);
	}

}
