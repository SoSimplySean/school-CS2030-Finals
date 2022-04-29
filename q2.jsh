// Answer 2ai below. Do not remove this comment.
double pow(double a, long b) {
    return Stream.<Double>generate(() -> a).limit(b).reduce(1, (x,y) -> x * y);
}




// Answer 2aii below. Do not remove this comment.
double seriesPi(long n) {
    return Stream.<Integer>iterate(1, x -> x + 1)
                 .filter(val -> val % 2 != 0)
                 .limit(n)
                 .map(x -> {
                            int test = (x - 1) / 2;
                            return test % 2 != 0 ? -x : x;
                         })
                 .map(val -> 4/val)
                 .reduce(0, (x,y) -> x + y);




// Answer 2b below. Do not remove this comment.
// Assuming radius is 1 from the image. Can adjust the value of 1 and 2 accordingly depending on radius.
double approxPi(long n) {
    return Stream.iterate(-1.0, x -> x <= 1.0, x -> x + 2/(n-1))
                 .map(x -> new Point(x,x))
                 .map(point -> unitCircle.contains(point))
                 .map(boo -> boo ? 1 : 0)
                 .reduce(0, (x,y) -> x + y) * 4 / n
}








