package project1;


public class Pairalt<K , U> {
    K k;
    U u;

    Pairalt(K k ,U u){
        this.k = k;
        this.u = u;
    }

    public K getKey() {
        return k;
    }

    public U getValue() {
        return u;
    }
}

