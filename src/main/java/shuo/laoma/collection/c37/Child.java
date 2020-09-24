package shuo.laoma.collection.c37;

import shuo.laoma.basic.c4.c4_2.Child;

class MyChild extends MyBase {
    public MyChild(int sortOrder) {
        super(sortOrder);
    }

    @Override
    public int compareTo(MyBase o) {
        if (!(o instanceof MyChild)) {
            throw new IllegalArgumentException();
        }
        MyChild c = (MyChild) o;
        //...
        return 0;
    }

}
