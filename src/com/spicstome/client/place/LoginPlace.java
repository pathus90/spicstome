package com.spicstome.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends Place
{

	public LoginPlace() {
		
	}
	

	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		@Override
		public String getToken(LoginPlace place) {
			return "login";
		}

		@Override
		public LoginPlace getPlace(String token) {
			return new LoginPlace();
		}

	}
	
}