package Bai7_1;

public class Customer {
	private String name;
    private boolean member = false;
    private String memberType = "None";  

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String type) {
        if (type != null && (type.equalsIgnoreCase("Premium") || type.equalsIgnoreCase("Gold") || type.equalsIgnoreCase("Silver"))) {
            this.memberType = type;
            this.member = true;
        } else {
            this.memberType = "None";
            this.member = false;
        }
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', member=" + member + ", memberType='" + memberType + "'}";
    }
}
