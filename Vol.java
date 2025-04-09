import java.io.Serializable;
import java.util.Date;

public class Vol implements Serializable {
    private String Numeroserie;
    private String Type;
    private String Description;
    private String ContactPerso;
    private Date Date;

    public Vol(String Numeroserie, String Type, String Description, String ContactPerso, Date Date) {
        this.Numeroserie = Numeroserie;
        this.Type = Type;
        this.Description = Description;
        this.ContactPerso = ContactPerso;
        this.Date = Date;
    }

    // Getters
    public String getNumeroserie() { return Numeroserie; }
    public String getType() { return Type; }
    public String getDescription() { return Description; }
    public String getContactPerso() { return ContactPerso; }
    public Date getDateReported() { return Date; }
}