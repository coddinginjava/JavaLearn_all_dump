package EnumLearning;

public class MyEnumExample {
    public static void main(String[] args) {
        Code[] c = Code.values();
        for(Code code : c){
            switch (code){
                case JAVA:
                    System.out.println(Code.JAVA.getNo());
                    break;
                case GO:
                    System.out.println(Code.GO.getNo());
                    break;
                case PYTHON:
                    System.out.println(Code.PYTHON.getNo());
                    break;
                default:
                    System.out.println("code. 🥼" + code.name().toLowerCase() +" ➡"+code.getNo());
            }
        }
    }
}
