package im430.xmas.business;

public class Address {

    private int id;
    private String text;

    public Address() {
        this("");
    }

    public Address(String text) {
        this.id = -1;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (this.text == null) {
            if (other.getText() != null)
                return false;
        } else if (!this.text.equals(other.getText()))
            return false;
        return true;
    }
}
