package shuo.laoma.basic.c5.c_513;

public enum Size {
    SMALL("S", "小号"),
    MEDIUM("M", "中号"),
    LARGE("L", "大号"),
    ;

    private String abbr;
    private String title;

    Size(String abbr, String title) {
        this.abbr = abbr;
        this.title = title;
    }

    public static Size fromAbbr(String abbr) {
        for (Size size: Size.values()) {
            if (size.abbr.equals(abbr))
                return size;
        }
        return null;
    }

    public static void main(String[] args) {
        Size s = Size.fromAbbr("M");
        System.out.println(s);

    }
}
