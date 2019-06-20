public class PhoneNumber {
    private String number;
    private int callsCounter;

    public PhoneNumber(String number) {
        setNumber(number);
        setCallsCounter(0);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.matches("^(00359|\\+359|0)(8[789][2-9]\\d{6})$")) {
            this.number = number;
        }
    }

    public int getCallsCounter() {
        return callsCounter;
    }

    public void setCallsCounter(int callsCounter) {
        if (callsCounter >= 0) {
            this.callsCounter = callsCounter;
        }
    }
}
