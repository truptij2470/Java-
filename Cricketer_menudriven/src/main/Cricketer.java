package main;




public class Cricketer {
    private String name;
    private int age;
    private String emailId;
    private String phone;
    private int rating;

    public Cricketer(String name, int age, String emailId, String phone, int rating) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.phone = phone;
        this.rating = rating;
    }

    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getters and setters
    public String getName() {
        return name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailId='" + emailId + '\'' +
                ", phone='" + phone + '\'' +
                ", rating=" + rating +
                '}';
    }
}
