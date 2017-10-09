package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	@Test(expected=EmptyDeckException.class)
	
	public void TestEmptyDeck() throws EmptyDeckException {
		//TODO: Build a deck, draw until you get a DeckException
		
		Deck Deck1= new Deck();
		for (int i =0; i < 60; i++)
		{
			Card c = Deck1.Draw();
		}
		
		}
		

		
		
	@Test
	public void TestDrawSuit() {
		//TODO: Build a deck, test the Draw(eSuit) method
		Deck Deck1= new Deck();
		Card c=null;
		try {
			c = Deck1.Draw(eSuit.HEARTS);
		} catch (EmptyDeckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(c.geteSuit(), eSuit.HEARTS);
		
		
		
	}
	
	@Test
	public void TestDrawRank() {
		//TODO: Build a deck, test the Draw(eRank) method
		Deck Deck1= new Deck();
		Card c=null;
		try {
			c = Deck1.Draw(eRank.TWO);
		} catch (EmptyDeckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(c.geteRank(), eRank.TWO);
	}
	
	public void TestDeckRankCount() {
		//TODO: Build a deck, test the DeckRankCount method
		Deck Deck1= new Deck();
		int count= Deck1.Count(eRank.ACE);
		assertEquals(count, 4);
	}
	
	public void TestDeckSuitCount() {
		//TODO: Build a deck, test the DeckSuitCount method
		Deck Deck1= new Deck();
		int count= Deck1.Count(eSuit.CLUBS);
		assertEquals(count, 13);
	}

}
