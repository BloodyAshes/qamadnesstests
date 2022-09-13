package enums;

public enum Alphabets {
    RU_ALPHABET ("абвгдеёжзийклмнопрстуфхцчшщьъыэюя"),
    EN_ALPHABET("abcdefghijklmnopqrstuvwxyz"),
    NUMBERS ("0123456789"),
    EN_AND_NUMBERS ("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789"),
    SPECIAL_SYMBOLS ("!@#$%^&*()_+=");

    private String alphabet;

    Alphabets(String alphabet){
    this.alphabet = alphabet;
    }

    public String getAlphabet(){
        return alphabet;
    }

    @Override
    public String toString() {
        return alphabet;
    }
}
