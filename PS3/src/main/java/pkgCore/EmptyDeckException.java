package pkgCore;

public class EmptyDeckException extends Exception{
private Deck d;
    public EmptyDeckException(Deck d){
    	this.d = d;
    }

    public EmptyDeckException(String message, Deck d){
        super(message);
        this.d = d;
    }

    public EmptyDeckException(Throwable cause){
        super(cause);
    }

    public EmptyDeckException(String message, Throwable cause){
        super(message, cause);
    }
}