package ua.com.dbncalc.steel.services.exceptions;

public class SteelDoesntExistsException extends Exception{
    @Override
    public String getMessage() {
        return "Steel with such combination of grade and thickness doesn't exist.";
    }
}
