package likeinhaskell;

/**
 * Created by Niklas on 2016-02-07.
 */
public interface Function<T,R> {
    public R apply(T t);

    // TODO: Step 6: Can you broaden the parameter type for
    //   the parameter 'other', to make 'compose' work for
    //   a wider range of functions?
    default <Q> Function<Q,R> compose(Function<Q,T> other){
        return new Function<Q,R>(){
            public R apply(Q q){
                T t = other.apply(q);
                return Function.this.apply(t);
            }
        };
    };

}
