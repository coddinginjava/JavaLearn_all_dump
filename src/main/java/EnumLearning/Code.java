package EnumLearning;

public enum Code {
    PYTHON(80), JAVA(79), JAVASCRIPT(40), CPP(50), GO(20);

    private int no;

    Code(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}
