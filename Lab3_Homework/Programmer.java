public class Programmer extends Person{
    private String language;
    public Programmer(String name, String birthdate, String language) {
        super(name, birthdate);
        this.language = language;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
        return String.format("Job: Programmer, Name: %s, Birthdate: %s, language: %s, relationships: ", getName(), getBirthdate(), getLanguage());
    }
}
