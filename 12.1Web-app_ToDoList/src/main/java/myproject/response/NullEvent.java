package myproject.response;

public class NullEvent extends Event{
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getTheme() {
        return "Not found Event!";
    }
}
