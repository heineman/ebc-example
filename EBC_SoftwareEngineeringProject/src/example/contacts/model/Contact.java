package example.contacts.model;

public class Contact implements Comparable<Contact> {
	String name;
	String phone;
	String email;
	
	public Contact(String name) {
		this.name = name;
	}
	
	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public void setName(String n) { this.name = n; }
	public String getName() { return name; }
	
	public void setEmail(String e) { this.email = e; }
	public String getEmail() { return email; }
	
	public void setPhone(String p) { this.phone = p; }
	public String getPhone() { return phone; }
	
	public String toString() {
		return name + " (ph:" + phone + ") (em:" + email + ")";
	}

	/** Compare by name. */
	@Override
	public int compareTo(Contact o) {
		return name.compareTo(o.getName());
	}
	
	boolean equalsIgnoreNull(String s1, String s2) {
		if (s1 == null && s2 == null) { return true; }
		if (s1 == null) { return false; }
		return s1.equals(s2);
	}
	
	/** Compare equality. Standard Java implementation. */
	public boolean equals (Object o) {
		if (o == null) { return false; }
		if (o instanceof Contact) {
			Contact other = (Contact) o;
			return equalsIgnoreNull(other.email, email) &&
				   equalsIgnoreNull(other.phone, phone) &&	
				   equalsIgnoreNull(other.name, name);
		}
		
		return false;
	}
}
