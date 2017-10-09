package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.poi.ss.formula.functions.Count;
import org.junit.runner.manipulation.Filter;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	/* 
	 * For each suit in eSuit and each rank in eRank, add one to the deck to create a 52 card deck
	 */
	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}


	/*
	 * if cardsInDeck has cards in it, remove the top card, if there are no cards
	 * in cardsInDeck, throw EmptyDeckException 
	 */
	public Card Draw() throws EmptyDeckException { // the method Draw could potentally throw an exception
		if (cardsInDeck.size() > 0) { // check for an empty deck
			return cardsInDeck.remove(0);
		} else
			throw new EmptyDeckException(this);
	}


	/*
	 * iterate over this intense of cardsInDeck, once you reach one of the 
	 * given Suit, remove it from the deck, if there are none of that suit, throw an exception
	 */
	public Card Draw(eSuit eSuit) throws EmptyDeckException {
		Card card = null;
		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {

				card = c;
			}

		}

		if (card == null) {
			throw new EmptyDeckException(this);

		}
		cardsInDeck.remove(card);
		return card;

	}
	/*
	 * iterate over this intense of cardsInDeck, once you reach one of the 
	 * given Rank, remove it from the deck, if there are none of that Rank, throw an exception
	 */
	public Card Draw(eRank erank) throws EmptyDeckException {
		Card card = null;
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == erank) {
				card = c;
				break;
			}

		}
		if (card == null)
			throw new EmptyDeckException(this);

		cardsInDeck.remove(card);
		return card;
	}

	/*
	 * filter the cards searching for a specific Suit, 
	 * creates a new arrayList of those cards,
	 * returns an integer value equal to the size of that list
	 */
	public int Count(eSuit eSuit) {
		ArrayList<Card> cardsInSuit = cardsInDeck.stream().filter(p -> p.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInSuit.size();

	}
	/*
	 * filter the cards searching for a specific Rank, 
	 * creates a new arrayList of those cards,
	 * returns an integer value equal to the size of that list
	 */
	public int Count(eRank eRank) {
		ArrayList<Card> cardsInSuit = cardsInDeck.stream().filter(p -> p.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInSuit.size();

	}


	/*
	 *  will return 0 or 1 if a given card is left in the deck
	 */

	public int findCard(Card c) {
		for (Card crds : cardsInDeck) {
			if (crds == c)
				return 1;
		}
		return 0;
	}
}

