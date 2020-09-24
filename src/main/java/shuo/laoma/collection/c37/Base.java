package shuo.laoma.collection.c37;

class MyBase implements Comparable<MyBase>{
    private int sortOrder;
    
    public MyBase(int sortOrder) {
        this.sortOrder = sortOrder;
    }
    
    @Override
    public int compareTo(MyBase o) {
        if(sortOrder < o.sortOrder){
            return -1;
        }else if(sortOrder > o.sortOrder){
            return 1;
        }else{
            return 0;
        }
    }
}
