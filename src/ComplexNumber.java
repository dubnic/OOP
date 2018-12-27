import java.util.Scanner;

class ComplexNumber extends Stroka implements IComparable {
    private String realPart;
    private String imaginaryPart;

    ComplexNumber(String imaginaryPart, String realPart) {
        this.realPart = realPart.matches("-?\\d+") ? realPart : "0";
        this.imaginaryPart = imaginaryPart.matches("([-+])?\\d+") ? imaginaryPart : "0";
    }

    @Override
    public String getString() {
        return imaginaryPart + "i" + realPart;
    }

    @Override
    public void setString() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the imagine part of the complex number: ");
        while (!input.hasNextInt()) {
            System.out.println("That not a number!");
            input.next();
        }
        imaginaryPart = String.valueOf(input.nextLine());

        System.out.print("Enter the real part of the complex number: ");
        while (!input.hasNextInt()) {
            System.out.println("That not a number!");
            input.next();
        }
        realPart = String.valueOf(input.nextLine());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ComplexNumber anotherCN = (ComplexNumber) obj;

        return ((realPart.equals(anotherCN.realPart)) && (imaginaryPart.equals(anotherCN.imaginaryPart)));
    }

    @Override
    String addition(ComplexNumber anotherCN) {
        return Integer.parseInt(imaginaryPart) + Integer.parseInt(anotherCN.imaginaryPart) + "i" +
                (Integer.parseInt(realPart) + Integer.parseInt(anotherCN.realPart));
    }

    String multiplication(ComplexNumber anotherCN) {
        return Integer.parseInt(realPart) * Integer.parseInt(anotherCN.imaginaryPart) +
                Integer.parseInt(imaginaryPart) * Integer.parseInt(anotherCN.realPart) + "i" +
                (Integer.parseInt(realPart) * Integer.parseInt(anotherCN.realPart) -
                        Integer.parseInt(imaginaryPart) * Integer.parseInt(anotherCN.imaginaryPart));
    }
}
