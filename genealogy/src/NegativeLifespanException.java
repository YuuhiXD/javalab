public class NegativeLifespanException extends Exception{
    public NegativeLifespanException(Person person) {
        super(String.format("osoba %s urodziła sie w %s ktory jest pozniejszy niz data smierci %s.",person.name(),person.getBirthDate(),person.getDeathDate()));
    }
}
