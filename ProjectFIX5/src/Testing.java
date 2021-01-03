import gui.MainUI;

public class Testing {
    public static void main(String[] args) {
        String[][]a={
                {"a","b"},
                {"c","d"}
        };
        System.out.println(a[0][1]);
        String[][]b=new String[2][2];
        b[0][0]="a";
        b[0][1]="b";
        b[1][0]="c";
        b[1][1]="d";
        System.out.println(b[0][1]);
    }
}
