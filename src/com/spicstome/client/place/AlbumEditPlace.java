package com.spicstome.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AlbumEditPlace extends Place
{

	public AlbumEditPlace() {
		
	}
	

	/**
	 * PlaceTokenizer knows how to serialize the Place's state to a URL token.
	 */
	public static class Tokenizer implements PlaceTokenizer<AlbumEditPlace> {

		@Override
		public String getToken(AlbumEditPlace place) {
			return "";
		}

		@Override
		public AlbumEditPlace getPlace(String token) {
			return new AlbumEditPlace();
		}

	}
	
}