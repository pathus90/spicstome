package com.spicstome.client.syntax.state;

import com.spicstome.client.dto.AdjectiveDTO;
import com.spicstome.client.dto.ArticleDTO;
import com.spicstome.client.dto.SubjectDTO;

/* Ajdective's complement */

public class StateAdjectiveComplement extends SyntaxState{

	public StateAdjectiveComplement(SyntaxAnalyser analyser) {
		super(true, analyser);
	}
	
	@Override
	public  String check(ArticleDTO article,int range)
	{

		SubjectDTO subject = (SubjectDTO) analyser.extractArticle(range-1);
	
		if(article instanceof AdjectiveDTO)
		{
			AdjectiveDTO adjective = (AdjectiveDTO) article;

			analyser.currentState=analyser.statefinal;
			
			return analyser.syntaxFrenchManager.match(subject.getGender(),subject.getNumber(), 
					adjective.getMatching1(),adjective.getMatching2(),adjective.getMatching3(),adjective.getMatching4());

		}
		else
		{
			analyser.currentState=analyser.trashState;
			return null;
		}
		
		
	}

}