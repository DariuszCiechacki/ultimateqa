package library.modules.automation.fillingoutforms;

public enum FormNumber {
    FIRST_FORM(0),
    SECOND_FORM(1);

    private final int index;

    FormNumber(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
