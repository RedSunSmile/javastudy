package editlist.overriding2_16chapter.refactoring;

public class PhoneInfo {
  String name;
  String phoneNumber;

  public PhoneInfo(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public void showPhoneInfo(){
    System.out.println("name : "+name);
    System.out.println("phone : "+phoneNumber);
  }
}
