package play.classandobjects;

import java.util.ArrayList;
import java.util.List;

import play.classandobjects.Card.Rank;
import play.classandobjects.Card.Suit;

public class Deck {
    public static List<Card> getFullCards() {
        var fullCards = new ArrayList<Card>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                fullCards.add(new Card(rank, suit));
            }
        }
        return fullCards;
    }
}
