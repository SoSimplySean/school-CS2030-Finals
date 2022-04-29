// Write your solution in this file only.

// Include packages below.  Do not remove this comment.
import java.util.function.Predicate;
import java.util.function.Function;

class IfElse<T, U> implements Function<T,U> {

    // Answer 4a below. Do not remove this comment.

    Predicate<T> boo;
    Function<T,U> tru;
    Function<T,U> fal;

    private IfElse(Predicate<T> boo, Function<T,U> tru, Function<T,U> fal) {
        this.boo = boo;
        this.tru = tru;
        this.fal = fal;
    }

    static <T,U> IfElse<T,U> of(Predicate<T> boo, Function<T,U> tru, Function<T,U> fal) {
        return new IfElse<T,U>(boo, tru, fal);
    }

    @Override
    U apply(T val) {
        return boo.test(val) ? tru.apply(val) : fal.apply(val);
    }


    // Answer 4b below. Do not remove this comment.

    // IfElse<T,U> mapIf(IfElse<T,U> condition) {
    //     return new IfElse<T,U>(this.boo.and(condition.boo), this.tru, this.fal);
    // }

    IfElse<T,U> mapIf(IfElse<T,U> condition) {
        return new IfElse<T,U>(condition.boo, this, this.fal);
    }

    // Answer 4c below. Do not remove this comment.

    IfElse<T,U> mapElse(IfElse<T,U> condition) {
        return new IfElse<T,U>(this.boo, this.tru, condition);
    }


    // Answer 4d below. Do not remove this comment.

    <R> IfElse<T,R> map(Function<T, R> mapper) {
        return new IfElse<T,R>() {
            @Override
            U apply(T val) {
                return boo.test(val) ? mapper.apply(tru.apply(val)) : mapper.apply(fal.apply(val));
            }
        };
    }


    <R> IfElse<T,R> flatMap(Function<T, IfElse<R>> mapper) {
        return mapper.apply(this.map);
    }


} // end of class IfElse
