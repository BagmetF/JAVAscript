package HomeWork02;

public class MyArrayEndDataException extends Exception {
    @Override
    public String getMessage() {
        return "Сумма массива больше 40";
    }
}