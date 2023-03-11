public class Designer extends Person{
    private String speciality;

    public Designer(String name, String birthdate, String bestSkill) {
        super(name, birthdate);
        this.speciality = bestSkill;
    }

    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String bestSkill) {
        this.speciality = bestSkill;
    }
    @Override
    public String toString() {
        return String.format("Job: Designer, Name: %s, Birthdate: %s, Best Skill: %s", getName(), getBirthdate(), getSpeciality());
    }
}
