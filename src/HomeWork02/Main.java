package HomeWork02;

public class Main {

    public static void main(String[] args) {
        String[][] wrongArr = new String[4][4];

        try {
            getSumOfElementsFrom(wrongArr);
        } catch (MyArraySizeException | MyArrayEndDataException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        String[][] goodArr = {
                {"1", "2", "3", "8"},
                {"1", "2", "3", "8"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println(getSumOfElementsFrom(goodArr));
        } catch (MyArraySizeException | MyArrayEndDataException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int getSumOfElementsFrom(String[][] array) throws MyArraySizeException, MyArrayDataException, MyArrayEndDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    int element = Integer.parseInt(array[i][j]);
                    sum += element;
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(i, j);
                }

                if
                (sum >= 41) {
                    throw new MyArrayEndDataException();
                }
            }
        }
         return sum;
    }
}