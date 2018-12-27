abstract public class Stroka implements IComparable {

    private String string;

    Stroka() {

    }

    Stroka(String string) {
        this.string = string;
    }

    Stroka(char symbol) {

    }

    int getStringLength() {
        return string.length();
    }

    public void setString() {
        string = "";
    }

    public String getString() {
        return string;
    }

    abstract String addition(ComplexNumber anotherCN);

    abstract String multiplication(ComplexNumber anotherCN);
}
