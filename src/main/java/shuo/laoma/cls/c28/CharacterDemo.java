package shuo.laoma.cls.c28;


public class CharacterDemo {
    public static void main(String[] args) {
        char[] chs = new char[3];
        chs[0] = '马';
        Character.toChars(0x1FFFF, chs, 1);
        System.out.println(Character.codePointCount(chs, 0, 3));
        System.out.println(chs);
        System.out.println(Character.codePointCount("杨恺", 0, 2));
        int codePoint = Character.codePointAt(chs, 1);
        System.out.println(codePoint);
        System.out.println(Character.charCount(codePoint));  // 2, 即由2个char构成
        System.out.println(chs.length);
        System.out.println(Character.offsetByCodePoints(chs, 0, 3, 1, 1));  // 3
        int ma = Character.codePointAt(new char[] {'马'}, 0, 1);
        System.out.println(ma);
        System.out.println((int)'马');
        System.out.println(Character.getType(ma));
        System.out.println(Character.getType('马'));
        System.out.println(Character.getType('9'));
        System.out.println(Character.getType('９'));  // 中文全角
        System.out.println(Character.isDigit('９'));
        System.out.println(new String(Character.toChars(ma)));
        System.out.println(Character.getNumericValue('A'));
    }
}
