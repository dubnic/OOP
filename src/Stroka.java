public class Stroka implements IComparable {

    private String string;

    Stroka() {

    }

    Stroka(String string) {
        this.string = string;
    }

    Stroka(char symbol) {

    }


    public int getStringLength() {
        return string.length();
    }

    public void setClearString() {
        string = "";
    }

    public String getComplexNumber() {
        return string;
    }

    public void setComplexNumber() {

    }

}
