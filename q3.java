// Modify your solution within this file only.

import java.util.function.Function;

// Create a maybe of a maybe
abstract class Potential<T> {}

class Maybe<T> extends Potential<T> {
    private final Potential<T> thing;
    private final boolean empty;
 
    private Maybe (Maybe<T> thing) {
        this.thing = thing;
        this.empty = false;
    }

    private Maybe (boolean empty) {
        this.thing = new Maybe<>(true);
        this.empty = true;
    }
    
    static <T> Maybe<T> of(T thing) {
        return new Maybe<T>(Potential<T>(thing));
    }

    static <T> Maybe<T> empty() {
        return new Maybe<T>(true);
    }

    boolean isEmpty() {
        return this.empty;
    }

    <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
        if (this.isEmpty()) {
            return Maybe.<R>empty();
        } else {
            return Maybe.<R>of(mapper.apply(this.thing));
        }
    }

    @Override
    public String toString() {
        return (this.isEmpty()) ? "Maybe.empty" : "Maybe[" + thing + "]";
    }
}


